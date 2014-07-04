package com.company.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.service.CommonService;
import com.company.vo.AttendenceVO;
import com.company.vo.DataTablesTO;

@Controller
@RequestMapping("/attendence")
public class AttendenceController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value = "/show")
	public String showBatch(Model model) throws Exception {
		model.addAttribute("batchlist", commonService.getBatchList());
//		model.addAttribute("attendencelist", commonService.getAttendenceList());
		return "attendence";
	}
	
	@RequestMapping(value = "/create")
	public String createAttendence(@ModelAttribute AttendenceVO vo, RedirectAttributes redirectAttributes, Model model) throws Exception {
		commonService.createAttendence(vo);
		redirectAttributes.addFlashAttribute("msg","Attendence Created Successfully");
		return "redirect:show.do";
	}
	
	@RequestMapping(value="getall",method=RequestMethod.GET)
	@ResponseBody
	public String getAllAttendence(@RequestParam int iDisplayStart,
            @RequestParam int iDisplayLength, @RequestParam int sEcho) throws Exception {
		System.out.println(" --- Body --- " + iDisplayStart);
		List<AttendenceVO> list =  commonService.getAttendenceList(iDisplayStart,iDisplayLength);
		DataTablesTO<AttendenceVO> dt = new DataTablesTO<AttendenceVO>();
		dt.setAaData(list);
		dt.setiTotalDisplayRecords(commonService.getAttendenceCount().intValue());
		dt.setiTotalRecords(commonService.getAttendenceCount().intValue());
		dt.setsEcho(sEcho);
		return toJson(dt);
	}
	
	private String toJson(DataTablesTO<?> dt){
		  ObjectMapper mapper = new ObjectMapper();
		  try {
		   return mapper.writeValueAsString(dt);
		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   return null;
		  }
		 }
	
}
