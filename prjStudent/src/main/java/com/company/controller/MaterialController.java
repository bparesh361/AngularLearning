package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.entity.Material;
import com.company.service.CommonService;
import com.company.vo.BatchVO;
import com.company.vo.MaterialVO;

@Controller
@RequestMapping("/materials")
public class MaterialController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/show")
	public String show(Model model) throws Exception {
		List<BatchVO> list = commonService.getBatchList();
		model.addAttribute("batchlist", list);
		model.addAttribute("materiallist", commonService.getMaterialList());
		return "material";
	}
	
	@RequestMapping("/create")
	public String createMaterialData(@ModelAttribute MaterialVO vo, RedirectAttributes attributes) throws Exception {
		System.out.println(vo);
		commonService.createMaterial(vo);
		attributes.addFlashAttribute("msg", "Content Uploaded Successfully");
		return "redirect:show.do";
	}
	
	@RequestMapping("/download")	
	public void downloadFile(@RequestParam String materialid, @RequestParam String f, HttpServletResponse response) throws Exception {
		Material material = commonService.getMaterialContent(materialid,f);
		String headerKey, headerValue=null;
		if(f.equals("1")){
			headerKey = "Content-Disposition";
	        headerValue = String.format("attachment; filename=\"%s\"",material.getFile1Name());
	        response.setHeader(headerKey, headerValue);
			response.setContentType(material.getFile1ContentType());
			response.getOutputStream().write(material.getFile1Data().getBytes(1, (int) material.getFile1Data().length()));
		} 
		if(f.equals("2")){
			headerKey = "Content-Disposition";
	        headerValue = String.format("attachment; filename=\"%s\"",material.getFile2Name());
	        response.setHeader(headerKey, headerValue);
			response.setContentType(material.getFile2ContentType());
			response.getOutputStream().write(material.getFile2Data().getBytes(1, (int) material.getFile2Data().length()));
		}
	}
	
}
