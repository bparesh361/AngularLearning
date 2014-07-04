package com.test.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.test.vo.UserVO;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return UserVO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		
		ValidationUtils.rejectIfEmpty(e, "userName", "userName.empty","UserName is EMPTY");
		ValidationUtils.rejectIfEmpty(e, "password", "password.empty","UserName is EMPTY");
		
	}
}
