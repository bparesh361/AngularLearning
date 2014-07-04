package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.CustomerVO;


@Controller
@RequestMapping("/auth")
public class RegistrationController {
	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/showregister")
	public String show(Model model) throws Exception {
		
		return "register";
	}
	@RequestMapping("/submitregister")
	public String createRegister(@ModelAttribute CustomerVO customerVO,Model model,
			RedirectAttributes attributes) throws Exception{
		System.out.println("Inside createRegister method.");
		if (customerVO.getFname() == null ||customerVO.getFname().isEmpty()) {
			attributes.addFlashAttribute("msg", "Customer created successfully");
		} else {
			attributes.addFlashAttribute("msg", "Customer updated successfully");
		}
		commonService.createCustomer(customerVO);
		return "redirect:showregister.do";
		
	}
}
