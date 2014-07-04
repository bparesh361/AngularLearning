package com.gateway.schemas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Resp",namespace=CommonConstants.NAMESPACE_URI)
public class Resp {

	@XmlElement(name="RespCode",namespace=CommonConstants.NAMESPACE_URI)
	private short RespCode;
	
	@XmlElement(name="RespMsg",namespace=CommonConstants.NAMESPACE_URI)
	private String RespMsg;
	
	public Resp() {
		
	}

	public Resp(short respCode, String respMsg) {
		super();
		this.RespCode = respCode;
		this.RespMsg = respMsg;
	}


	public void setRespCode(short respCode) {
		this.RespCode = respCode;
	}

	public void setRespMsg(String respMsg) {
		this.RespMsg = respMsg;
	}
	
	
	}
