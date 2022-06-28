package com.example.servingwebcontent;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Value( "${greeting.spanish}" )
	private String defaultGreeting;
	
//	@GetMapping("/greeting")
//	public String greeting(@RequestParam(name="name", 
//		required=true, defaultValue="World") String name,
//			Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false) String name, Model model) {
		if(Objects.nonNull(name)) {
			model.addAttribute("name", name);
		}
		else {
			model.addAttribute("name", defaultGreeting);
		}
		return "greeting";
	}
}
