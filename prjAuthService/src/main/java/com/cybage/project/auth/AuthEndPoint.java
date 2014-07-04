package com.cybage.project.auth;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cybage.project.auth.common.CommonConstants;
import com.cybage.project.schemas.AuthRequest;
import com.cybage.project.schemas.AuthResponse;
import com.cybage.project.schemas.MathSqrtRequest;
import com.cybage.project.schemas.MathSqrtResponse;
import com.cybage.project.schemas.RegisterRequest;
import com.cybage.project.schemas.RegisterResponse;
import com.cybage.project.thirdparty.schemas.MathRequest;
import com.cybage.project.thirdparty.schemas.MathResponse;

/**
 * @author nehabh
 *
 */
@Endpoint
public class AuthEndPoint implements ApplicationContextAware {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/**
	 * 
	 */
	@Autowired
	private AuthService authService;

	/**
	 * 
	 */
	@Autowired
	private WebServiceTemplate webServiceTemplate;

	/**
	 * 
	 */
	private ApplicationContext applicationContext;

	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(AuthEndPoint.class);

	/**
	 * @param authReq
	 * @return
	 * @throws AuthException
	 */
	@PayloadRoot(namespace = CommonConstants.NAMESPACE_URI, localPart = "AuthRequest")
	@ResponsePayload
	public AuthResponse auth(@RequestPayload AuthRequest authReq)	throws AuthException {
		final String  key = authService.getKey(authReq.getUsername(),authReq.getPassword());
		final AuthResponse response = new AuthResponse();
		response.setKey(key);
		return response;
	}

	/**
	 * @param registerRequest
	 * @return
	 */
	@PayloadRoot(namespace = CommonConstants.NAMESPACE_URI, localPart = "RegisterRequest")
	@ResponsePayload
	public RegisterResponse register(@RequestPayload RegisterRequest registerRequest) {
		//LOGGER.info("User name : "+ registerRequest.getUsername() + "  & Password : "	+ registerRequest.getPassword());
		final RegisterResponse response = new RegisterResponse();
		if ((null ==registerRequest.getUsername()|| registerRequest.getUsername().isEmpty() || registerRequest	.getUsername().equals(""))
				&& null ==registerRequest.getPassword()  ||registerRequest.getPassword().isEmpty()|| registerRequest.getPassword().equals("")) {
			response.setMsg(CommonConstants.FAILURE_REGISTER);
			return response;
		}
		authService.register(registerRequest.getUsername(),	registerRequest.getPassword());
		response.setMsg(CommonConstants.SUCCESS_REGISTER);
		return response;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/**
	 * @param mathSqrtRequest
	 * @return
	 * @throws AuthException
	 */
	@PayloadRoot(namespace = CommonConstants.NAMESPACE_URI, localPart = "MathSqrtRequest")
	@ResponsePayload
	public MathSqrtResponse getSqrt(@RequestPayload MathSqrtRequest mathSqrtRequest)throws AuthException {
		LOGGER.info("--- Received Request for Square Root ---- Key : "	+ mathSqrtRequest.getKey() + " - Number : "	+ mathSqrtRequest.getNumber());
		boolean result = authService.validateKey(mathSqrtRequest.getKey());
		LOGGER.info(" --- Validation of Key Result --- " + result);
		if (!result) {
			throw new AuthException("Invalid Key");
		}
		final MathRequest request = new MathRequest();
		request.setNumber(mathSqrtRequest.getNumber());
		LOGGER.info(" - Calling Service - "	+ applicationContext.getBean(WebServiceTemplate.class));
		final MathResponse response = (MathResponse) webServiceTemplate.marshalSendAndReceive(request);
		LOGGER.info(" - Response from third party Service  received - "+ response.getNumber());
		final MathSqrtResponse sqrtResponse = new MathSqrtResponse();
		sqrtResponse.setNumber(response.getNumber());
		return sqrtResponse;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
