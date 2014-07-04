package com.company.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {

	private String streetno,cityname;

	public Address(String streetno, String cityname) {
		super();
		this.streetno = streetno;
		this.cityname = cityname;
	}

	public String getStreetno() {
		return streetno;
	}

	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	
	
	
	
	
}
