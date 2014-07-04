package com.gateway.schemas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AuthResponse",namespace=CommonConstants.NAMESPACE_URI)
public class AuthResponse {
	
	@XmlElement(name="Resp",namespace=CommonConstants.NAMESPACE_URI)
	private Resp Resp;
	
	public AuthResponse() {
		
	}

//	public Resp getRespT() {
//		return RespT;
//	}

	public void setResp(Resp Resp) {
		this.Resp = Resp;
	}
	
	

		
}
