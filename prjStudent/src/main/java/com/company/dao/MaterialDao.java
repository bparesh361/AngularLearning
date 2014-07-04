package com.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Material;

public interface MaterialDao extends JpaRepository<Material, Integer> {

}
