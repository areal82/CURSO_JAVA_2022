package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.HelloService;

@Controller
public class HelloController {

	// @Autowired
	private HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping("/hello")
	public String handle(Model model) {
		model.addAttribute("message", helloService.sayHello());
		return "hello";
	}
	
	@GetMapping("/goodBye")
	public String handleGoodBye(Model model) {
		model.addAttribute("message", helloService.sayGoodBye());
		return "hello";
	}
	
	
	
	
	
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", 
		required=true, defaultValue="World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}