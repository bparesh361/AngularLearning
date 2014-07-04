package com.test.dao;

import org.springframework.stereotype.Service;

@Service
public class TestDao {

	public boolean checkName(String name){
		if(name.equals("neha")){
			return true;
		} else {
			return false;
		}
	}
}
