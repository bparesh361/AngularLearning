package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.AppUser;


public interface UserDao extends JpaRepository<AppUser, Integer>{

//	public List<AppUser> findByUsername(String username);
	
}
