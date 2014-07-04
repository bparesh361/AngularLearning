package com.company.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.BatchVO;
import com.company.vo.ScheduleVO;

@Controller
@RequestMapping("/schedule")
@SessionAttributes("batchid")
public class ScheduleController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/show")
	public String showSchedulePage(@RequestParam(required=false) Integer batchid, HttpSession session, Model model) throws Exception {
		if(batchid==null){
			batchid = Integer.parseInt((String)session.getAttribute("batchid"));		
		} 
		BatchVO batch = commonService.getBatch(batchid);
		model.addAttribute("schedulelist", commonService.getScheduleList());
		model.addAttribute("batchvo", batch);
		return "schedule"; 
	}
	
	@RequestMapping("/create")
	public String createSchedule(@ModelAttribute ScheduleVO scheduleVO, HttpSession session, RedirectAttributes attributes,Model model) throws Exception {		
		commonService.createSchedule(scheduleVO, Integer.parseInt(scheduleVO.getId()));
		attributes.addFlashAttribute("msg", "Schedule Created Successfully");
		session.setAttribute("batchid", scheduleVO.getId());
		return "redirect:show.do"; 
	}
	
	
	
}
