package com.company.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Batch;
import com.company.entity.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer>{

	public List<Faculty> findByBatchId(List<Batch> batch);
	
}
