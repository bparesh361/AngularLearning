package com.gateway.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "RegistrationResponse",namespace=CommonConstants.NAMESPACE_URI)
public class RegistrationResponse {

	@XmlElement(name="Resp",namespace=CommonConstants.NAMESPACE_URI)
	private Resp Resp;
	
    
	public RegistrationResponse() {
		
	}


	public void setResp(Resp Resp) {
		this.Resp = Resp;
	}

}
