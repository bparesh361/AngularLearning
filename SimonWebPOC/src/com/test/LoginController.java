package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dao.LoginDao;
import com.test.validation.LoginValidator;
import com.test.vo.UserVO;



@Controller
@RequestMapping(value="login")
public class LoginController {

	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping("showlogin")
	public String showLoginPage(Model model){
		System.out.println("---calling login page");
		model.addAttribute("user", new UserVO());
		return "login";
	}
	
	@RequestMapping(value="auth", method=RequestMethod.POST)
	public String AuthUser(@ModelAttribute("uservo")UserVO vo,Model model,Errors e){
		System.out.println("---inside login service---");
		System.out.println(" --- Authenticating User " + vo.getUserName() +" : " + vo.getPassword());
		LoginValidator validator = new LoginValidator();
		validator.validate(vo, e);
		if(e.hasErrors()){
			System.out.println(e.getAllErrors());
			return "login";
		}
		
		boolean result = loginDao.checkUser(vo.getUserName(), vo.getPassword());
		System.out.println("------------------------Result"+result);
		if(result){
			return "success";
		}else{
		return "error";}
	}
	
	
	@RequestMapping(value="insert")
	public String test(Model model,@RequestParam(value="msg")String msg){
		System.out.println(" --- Insert User --- ");
		loginDao.insertUser("admin", "admin");
		TestVO vo = new TestVO();
		model.addAttribute("msg",msg);
		model.addAttribute("vo", vo);	
		System.out.println("List Size : -----------------"+LoginDao.users.size());
		return "success";
	}
}
