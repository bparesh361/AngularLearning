package com.company.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.company.mongo.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
