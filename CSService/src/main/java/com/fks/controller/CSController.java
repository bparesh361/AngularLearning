package com.fks.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fks.dao.UserDao;
import com.fks.util.CassandraUtil;
import com.fks.vo.UserVO;

@Controller
@RequestMapping("/cservice")
public class CSController {

	private static Logger logger = Logger.getLogger(CSController.class);
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/users/{userid}")
	@ResponseBody
	public UserVO getUserInfo(@PathVariable("userid")String userid){
		logger.info("---- Fetching Details for User Id " + userid );		
		return userDao.findUser(Long.parseLong(userid));
	}
	
	
	
}
