package com;

import com.cb.AuthReq;
import com.cb.AuthRes;
import com.cb.Greeting;
import com.cb.GreetingImplService;

public class Client {

	public static void main(String[] args) {
		GreetingImplService service = new GreetingImplService();
		Greeting greeting = service.getGreetingImplPort();
		System.out.println("Starting service call sayHello method");
		System.out.println(greeting.sayHello("Spring123"));
		System.out.println("Ending service call sayHello method");
		
		
		System.out.println("Starting service call Validate User method");
		AuthReq request = new AuthReq();
		request.setUserName("admin");
		request.setPassword("password");
		AuthRes res = greeting.validateUser(request);
		System.out.println("Message : " +res.getMsg());
		System.out.println("Response code  : " +res.getRespCode());
		System.out.println("Ending service call Validate User method");
	}

}
