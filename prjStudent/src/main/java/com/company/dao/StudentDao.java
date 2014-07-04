package com.company.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Batch;
import com.company.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{
	
	public List<Student> findByBatchId(List<Batch> batch); 

}
