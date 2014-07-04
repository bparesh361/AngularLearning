package com.company.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.company.vo.LoginVO;

@Controller
@RequestMapping("/auth")
public class LoginController {
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	@RequestMapping("/login")
	public String test(){
		LOGGER.info("Returning login page");
		System.out.println("Returning login page....");
		return "login";
	}
	
	
	@RequestMapping("/authlogin")
	public String loginAuth(@ModelAttribute LoginVO loginVO,Model model){
		System.out.println("Inside loginAuth method.");
		if(loginVO.getUsername().equalsIgnoreCase("admin") && loginVO.getPassword().equalsIgnoreCase("admin")){
			return "register";
		}else{
			return "login";
		}
		
	}

}
