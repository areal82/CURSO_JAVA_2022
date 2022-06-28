package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private String template;
	
	@Autowired
	private AtomicLong counter;

	@GetMapping("/greeting")
	// @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World", required = false) String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/getGreeting/{id}")
	@ResponseBody
	public Greeting getGreetingById(@PathVariable(required = true) String id) {
		return new Greeting(Long.valueOf(id), "Greeting By ID");
	}
	
	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createGreeting(@RequestBody Greeting newGreeting) {
	    return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PostMapping(value = "/createWithRS", produces = MediaType.APPLICATION_JSON_VALUE)
	// @RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> createGreetingWithRS(
	  @RequestBody Greeting newGreeting) {
		return ResponseEntity.ok(newGreeting);
	}
}
