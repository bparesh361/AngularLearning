package com.gateway.schemas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace=CommonConstants.NAMESPACE_URI,name="AuthRequest")
public class AuthRequest {
	
	@XmlElement(name="UserId",namespace=CommonConstants.NAMESPACE_URI)
	private String UserId;
	
	@XmlElement(name="Password",namespace=CommonConstants.NAMESPACE_URI)
	private String Password;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	
	
}
