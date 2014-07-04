package com.cb;


import javax.jws.WebService;

@WebService(endpointInterface="com.cb.Greeting")
public class GreetingImpl implements Greeting {

	@Override
	public String sayHello(String name) {
		return "Welcome to JAVA world "+name;
	}

	@Override
	public AuthRes validateUser(AuthReq request) {
		AuthRes response = new AuthRes();
		if(request.getUserName().equalsIgnoreCase("admin")&& request.getPassword().equalsIgnoreCase("password")){
			response.setMsg("Successfully login");
			response.setRespCode(RespCode.SUCCESS);
		}else{
			response.setMsg("Fail to login");
			response.setRespCode(RespCode.FAILURE);
		}
		
		return response;
	}

}
