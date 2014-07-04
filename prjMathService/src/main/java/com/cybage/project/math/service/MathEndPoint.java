package com.cybage.project.math.service;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cybage.project.math.common.CommonConstants;
import com.cybage.schemas.MathRequest;
import com.cybage.schemas.MathResponse;

@Endpoint
public class MathEndPoint {

	@Autowired
	private MathService mathService;
	
	private static final Logger logger = Logger.getLogger(MathEndPoint.class);
	
//	@Autowired
//	public MathEndPoint(MathService mathService) throws JDOMException {
//		this.mathService = mathService;	
//	}
//	
	@PayloadRoot(namespace=CommonConstants.NAMESPACE_URI,localPart="MathRequest")
	@ResponsePayload
	public MathResponse sqrt(@RequestPayload MathRequest mathRequest) throws Exception {
		logger.info(" --- Request Received --- " +  mathRequest);		
		double result = mathService.sqrt(mathRequest.getNumber());
		logger.info("Number Converted --- " + result);
		MathResponse response = new MathResponse();
		response.setNumber(result);
		return response;
	}
	
}
