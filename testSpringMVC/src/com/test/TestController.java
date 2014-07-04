package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class TestController {

	@RequestMapping("/login")
	public String test(){
		return "loginpage";
	}
	
}
