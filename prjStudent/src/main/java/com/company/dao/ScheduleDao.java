package com.company.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.entity.Batch;
import com.company.entity.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Integer>{

	public List<Schedule> findByBatchId(@PathVariable Batch b);
	
}
