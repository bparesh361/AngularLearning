package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Batch;

public interface BatchDao extends JpaRepository<Batch, Integer>{

}
