package com.example.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.model.Greeting;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}
