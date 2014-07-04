package com.gateway.ws;


import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gateway.schemas.AuthRequest;
import com.gateway.schemas.AuthResponse;
import com.gateway.schemas.CommonConstants;
import com.gateway.schemas.Resp;

@Endpoint
public class CreditService {
	
	@PayloadRoot(namespace=CommonConstants.NAMESPACE_URI,localPart="AuthRequest")
	@ResponsePayload
	public AuthResponse authenticate(@RequestPayload AuthRequest authRequest) throws Exception {
		System.out.println("---- UserName -- " + authRequest.getUserId());
		System.out.println("---- Password -- " + authRequest.getPassword());
		AuthResponse response = new AuthResponse();
		Resp resp = new Resp(new Short("0"), "message");
		response.setResp(resp);
		return response;
		
	}	
}
