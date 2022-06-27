package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}