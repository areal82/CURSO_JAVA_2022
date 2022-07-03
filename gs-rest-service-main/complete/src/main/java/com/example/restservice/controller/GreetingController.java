package com.example.restservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.dto.GreetingDTO;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.model.Greeting;
import com.example.restservice.service.GreetingService;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

	@Autowired
	private String template;
	
	@Autowired
	private GreetingService greetingService;

	@GetMapping("/greetings")
	// @RequestMapping(value = "/greetings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GreetingDTO> greetings() throws ResourceNotFoundException {
		List<GreetingDTO> response = new ArrayList<>(); 
		
		List<Greeting> greetingsFromDB = greetingService.findAllGreetings();
		
		// TODO -> CREATE MAPPING SERVICE
		greetingsFromDB.forEach(gretting -> response.add(convertGreetingToDTO(gretting)));
		
		return response;
	}
	
	private GreetingDTO convertGreetingToDTO(Greeting greeting) {
		return new GreetingDTO(greeting.getContent(), greeting.getLanguage());
	}
	
	@PostMapping("/greeting")
	// @RequestMapping(value = "/greetings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GreetingDTO> createGreeting(@RequestBody GreetingDTO newGreeting) {
		Greeting newEntity = greetingService.createGreeting(createGreetingFromDTO(newGreeting));
		return ResponseEntity.ok(convertGreetingToDTO(newEntity));
	}
	
	private Greeting createGreetingFromDTO(GreetingDTO newGreeting) {
		return new Greeting(newGreeting.getContent(), newGreeting.getLanguage());
	}
	
	@GetMapping("/greeting")
	// @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GreetingDTO greeting(@RequestParam(value = "name", required = false) String name) {
		return new GreetingDTO(Objects.nonNull(name) ? String.format(template, name) : "World", "ES");
	}
	
	@GetMapping("/greeting/{id}")
	@ResponseBody
	public GreetingDTO getGreetingById(@PathVariable(required = true) String id) {
		return new GreetingDTO("Hola", "ES");
	}
	
	@PostMapping(value = "/createWithRS", produces = MediaType.APPLICATION_JSON_VALUE)
	// @RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GreetingDTO> createGreetingWithRS(
	  @RequestBody GreetingDTO newGreeting) {
		return ResponseEntity.ok(newGreeting);
	}
}
