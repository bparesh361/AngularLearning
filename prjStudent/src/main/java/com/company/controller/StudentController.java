package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.StudentVO;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/show")
	public String show(Model model) throws Exception {
		model.addAttribute("studentlist", commonService.getStudentList());
		return "student";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute StudentVO vo, Model model,
			RedirectAttributes attributes) throws Exception {
		if (vo.getId() == null || vo.getId().isEmpty()) {
			attributes.addFlashAttribute("msg", "Student created successfully");
		} else {
			attributes.addFlashAttribute("msg", "Student updated successfully");
		}
		commonService.createStudent(vo);
		return "redirect:show.do";
	}

}
