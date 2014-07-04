package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.service.CommonService;
import com.company.vo.CollegeVO;

@Controller
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<String> getAllColleges(@RequestParam("term")String query) throws Exception {
		List<CollegeVO> list = commonService.getCollegeVOList(query);
		List<String> slist = new ArrayList<String>();
		for(CollegeVO vo : list){
			slist.add(vo.getCollegeName());
		}
		return slist;
	}
	
}
