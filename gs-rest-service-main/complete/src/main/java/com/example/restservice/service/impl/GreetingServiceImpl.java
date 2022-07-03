package com.example.restservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.model.Greeting;
import com.example.restservice.repository.GreetingRepository;
import com.example.restservice.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
	
	@Autowired
	GreetingRepository repository;
	
	@Override
	public Greeting createGreeting(Greeting newGreeting) {
		return repository.save(newGreeting);
	}

	@Override
	public List<Greeting> findAllGreetings() throws ResourceNotFoundException {
		List<Greeting> greetingsFromDB = (List<Greeting>) repository.findAll();
		if(greetingsFromDB.isEmpty()) {
			throw new ResourceNotFoundException("No existen saludos en la base de datos!");
		}
		return greetingsFromDB;
	}

}
