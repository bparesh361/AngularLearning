package com.company.mongo.entity;

import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

public class EmailAddress {

	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);
	
	@Field("email")
	private final String email;

	public EmailAddress(String email){
		Assert.isTrue(isValid(email),"Email Address Not Valid");
		this.email = email;
	}
	
	public static boolean isValid(String email) {
		return PATTERN.matcher(email).matches();
	}

	@Override
	public String toString() {
		return email;
	}
	
	
	
	
}
