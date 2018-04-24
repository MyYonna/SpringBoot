package com.roc.springboot.spring_boot_demo.ex5;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDAO extends MongoRepository<Customer, String> {

	List<Customer> findByFirstName(String firstName);
}
