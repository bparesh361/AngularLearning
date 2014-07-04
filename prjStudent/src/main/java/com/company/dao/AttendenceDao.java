package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Attendence;

public interface AttendenceDao extends JpaRepository<Attendence, Integer>{

}
