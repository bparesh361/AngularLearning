package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Fees;

public interface FeesDao  extends JpaRepository<Fees, Integer>{

	
}
