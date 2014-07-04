package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.mongo.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
