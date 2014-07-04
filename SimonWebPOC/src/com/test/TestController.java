package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dao.TestDao;






@Controller
@RequestMapping(value="test")
public class TestController {
	
	@Autowired
	private TestDao testDao;
	
	@RequestMapping(value="test")
	public String test(Model model,@RequestParam(value="msg")String msg){
		System.out.println(" --- Test --- ");
		TestVO vo = new TestVO();
		vo.setMyname("neha");
		model.addAttribute("msg",msg);
		model.addAttribute("vo", vo);		
		return "test";
	}
	
	@RequestMapping(value="instest",method=RequestMethod.POST)
	public String ins(@ModelAttribute(value="vo")TestVO vo, Model model){
		System.out.println(" --- received --- " + vo.getMyname());
		if(testDao.checkName(vo.getMyname())){
		model.addAttribute("msg", "Inserted " + vo.getMyname());
		} else {
			model.addAttribute("msg", "Not Correct.... Name Not valid : " + vo.getMyname());
		}		
		return "redirect:test.htm";
	}
	
}
