package com.company.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.company.mongo.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
