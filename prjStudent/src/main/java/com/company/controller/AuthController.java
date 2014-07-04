package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/auth")
@SessionAttributes(value = "username")
public class AuthController {

	/*@Autowired
	private CommonService commonService;*/

	/*@RequestMapping(value = "login", method = RequestMethod.POST)
	public String validate(@ModelAttribute AppUser appUser, Model model) {
		System.out.println(appUser.getUsername());
		System.out.println(appUser.getPassword());
		boolean authResult = commonService.validateUser(appUser);
		if (authResult) {
			model.addAttribute("username", appUser.getUsername());
			return "home";
		} else {
			return "error";
		}
	}*/
	
	@RequestMapping(value="login")	
	public String showLoginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "login";
	}

	
	@RequestMapping(value="home")	
	public String showHomePage() throws Exception {
		return "home";
	}
	
	

}
