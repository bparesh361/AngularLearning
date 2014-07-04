package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class LoginDao {

	public boolean checkUser(String userName,String passwod){
		if(userName.equals("admin") && passwod.equals("admin")){
			return true;
		} else {
			return false;
		}
	}
	
	public static List<User> users = new ArrayList<User>();
	
	public void insertUser(String userName,String password){
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		users.add(user);
	}
//		
}

class User{
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}