package com.gateway.schemas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(namespace=CommonConstants.NAMESPACE_URI,name = "RegistrationRequest")
public class RegistrationRequest {

	@XmlElement(name="fname",namespace=CommonConstants.NAMESPACE_URI)
	private String f_name;
	
	@XmlElement(name="lname",namespace=CommonConstants.NAMESPACE_URI)
	private String l_name;

    public String getFname() {
        return f_name;
    }

   
    public void setFname(String firstname) {
        f_name = firstname;
    }

    public String getLname() {
        return l_name;
    }

    public void setLname(String lastname) {
        l_name = lastname;
    }

}
