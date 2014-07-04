package com.company.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.entity.College;

public interface CollegeDao extends JpaRepository<College, Integer>{

	@Query("select c from College c where c.collegeName LIKE %:cname%")
	public List<College> getCollegeList(@Param("cname")String collegeName);
	
}
