package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.BatchVO;
import com.company.vo.FacultyVO;
import com.company.vo.ScheduleVO;
import com.company.vo.StudentVO;

@Controller
@RequestMapping("/batch")
@Transactional
public class BatchController {

	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/show")
	public String showBatch(Model model) throws Exception {
		model.addAttribute("batchlist", commonService.getBatchList());
		return "batch";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createBatch(@ModelAttribute BatchVO vo, Model model,
			RedirectAttributes attributes) throws Exception {
		if (vo.getId() == null || vo.getId().isEmpty()) {
			attributes.addFlashAttribute("msg", "batch created successfully");
		} else {
			attributes.addFlashAttribute("msg", "batch updated successfully");
		}
		commonService.createBatch(vo);
		return "redirect:show.do";
	}

	@RequestMapping(value = "/showbtasg")
	public String showBatchFacultyAssign(@RequestParam String batchid, Model model) throws Exception {
		BatchVO batch = commonService.getBatch(Integer.parseInt(batchid));
		model.addAttribute("batchvo", batch);
		List<FacultyVO> faculties = commonService.getFacultyList();
		for(FacultyVO facultyVO : faculties){
			if(batch.getFaculties().contains(facultyVO)){
				facultyVO.setBatch(0);
			} else {
				facultyVO.setBatch(1);
			}
		}
		model.addAttribute("facultylist", faculties);
		return "batchassign";
	}	
	
	@RequestMapping(value = "/showbtasgstudent")
	public String showBatchStudentAssign(@RequestParam String batchid, Model model) throws Exception {
		BatchVO batch = commonService.getBatch(Integer.parseInt(batchid));
		model.addAttribute("batchvo", batch);
		List<StudentVO> students = commonService.getStudentList();
		for(StudentVO studentVO : students){
			if(batch.getStudents().contains(studentVO)){
				studentVO.setBatch(0);
			} else {
				studentVO.setBatch(1);
			}
		}
		model.addAttribute("studentlist", students);
		return "studentassign";
	}
	
	@RequestMapping(value="/btasg")
	public String allocateFaculty(@RequestParam String batchid, @RequestParam String facultyid, @RequestParam boolean allocate){
		commonService.allocateBatch(batchid, facultyid, allocate);
		return "redirect:showbtasg.do?batchid="+batchid;
	}
	
	@RequestMapping(value="/btasgstudent")
	public String assignStudent(@RequestParam String batchid, @RequestParam String studentid, @RequestParam boolean allocate){
		commonService.assignBatch(batchid, studentid, allocate);
		return "redirect:showbtasgstudent.do?batchid="+batchid;
	}
	
	@RequestMapping(value="/getstudent")
	@ResponseBody
	public List<StudentVO> getStudentList(@RequestParam String batchid){
		List<StudentVO> slist = commonService.getStudentList(batchid);
		System.out.println(slist);
		return slist;
	}
	
	@RequestMapping(value="/getfaculty")
	@ResponseBody
	public List<FacultyVO> getFacultyList(@RequestParam String batchid){
		List<FacultyVO> slist = commonService.getFacultyList(batchid);
		System.out.println(slist);
		return slist;
	}
	
	
	@RequestMapping(value="/getschedules")
	@ResponseBody
	public List<ScheduleVO> getSchedules(@RequestParam String batchid){
		List<ScheduleVO> slist = commonService.getScheduleList(batchid);
		System.out.println(slist);
		return slist;
	}
	
}
