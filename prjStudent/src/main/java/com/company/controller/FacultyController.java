package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.FacultyVO;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

//	private static final List<FacultyVO> list = new ArrayList<FacultyVO>();

	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/show")
	public String show(Model model) throws Exception{
		model.addAttribute("facultylist", commonService.getFacultyList());
		return "faculty";
	}
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String create(@ModelAttribute FacultyVO vo, Model model, RedirectAttributes attributes) throws Exception {
		if(vo.getId() ==null || vo.getId().isEmpty()) {
		attributes.addFlashAttribute("msg","Faculty created successfully");
		} else {
			attributes.addFlashAttribute("msg","Faculty updated successfully");
		}
		commonService.createFaculty(vo);
		return "redirect:show.do";
	}
	
}
