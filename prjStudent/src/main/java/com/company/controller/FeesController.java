package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.FeesVO;

@Controller
@RequestMapping("/fees")
public class FeesController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/show")
	public String showFeesPage(Model model){
		model.addAttribute("batchlist", commonService.getBatchList());
		model.addAttribute("feeslist", commonService.getFeesList());
		return "fees";
	}
	
	@RequestMapping("/create")
	public String createFees(@ModelAttribute FeesVO feesVO, RedirectAttributes attributes) throws Exception {
		commonService.createFees(feesVO);
		attributes.addFlashAttribute("msg", "Fees Created Successfully.");
		return "redirect:show.do";
	}
	
	
}
