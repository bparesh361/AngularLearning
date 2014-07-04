package com.company.mongo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.company.mongo.entity.EmailAddress;

@Component
public class EmailToStringConverter implements Converter<EmailAddress, String>{

	public String convert(EmailAddress emailAddress) {
		return emailAddress==null? null : emailAddress.toString();
	}	

}
