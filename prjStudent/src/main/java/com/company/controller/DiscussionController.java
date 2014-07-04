package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.DiscussionVO;

@Controller
@RequestMapping("/discussion")
public class DiscussionController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/create")
	public String createDiscussionQuestion(@ModelAttribute DiscussionVO vo, RedirectAttributes attributes) throws Exception {		
		commonService.createDiscussion(vo);
		attributes.addFlashAttribute("msg", "Qusetion Posted Successfully.");
		return "redirect:show.do";
	}
	
	@RequestMapping("/show")
	public String showDiscussion(Model model) throws Exception {
		model.addAttribute("unansweredquestions", commonService.unAnsweredQuestions());
		return "discussion";
	}	
	
	@RequestMapping("/reply")
	public String reply(@ModelAttribute DiscussionVO vo, RedirectAttributes attributes, Model model) throws Exception {
		commonService.createReply(vo);
		attributes.addFlashAttribute("msg", "Reply Posted Successfully.");
		return "redirect:show.do";
	}
		
	@RequestMapping("/searchquestion")
	@ResponseBody
	public List<String> searchQuestions(@RequestParam("term")String query){
		return commonService.findQuestions(query);		
	}
	
	@RequestMapping("/squewithreply")	
	public String searchQuestionsWithReplies(@RequestParam("searchquestion")String question, Model model){
		model.addAttribute("discussionlist", commonService.getDiscussionByQuestions(question));
		return "searchquestion";
	}
	
	
	
	
	
	
}
