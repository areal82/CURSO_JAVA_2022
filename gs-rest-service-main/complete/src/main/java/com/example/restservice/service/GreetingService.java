package com.example.restservice.service;

import java.util.List;

import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.model.Greeting;

public interface GreetingService {
	
	Greeting createGreeting(Greeting newGreeting);
	List<Greeting> findAllGreetings() throws ResourceNotFoundException;
}
