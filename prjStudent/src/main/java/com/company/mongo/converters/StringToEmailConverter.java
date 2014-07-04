package com.company.mongo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.company.mongo.entity.EmailAddress;

public class StringToEmailConverter implements Converter<String, EmailAddress>{

	public EmailAddress convert(String email) {
		return StringUtils.hasText(email) ? new EmailAddress(email) : null;
	}

	
	
}
