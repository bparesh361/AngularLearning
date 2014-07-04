package com.cb;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Greeting {

	@WebMethod
	String sayHello(String name);
	
	@WebMethod
	AuthRes validateUser(AuthReq request);
}
