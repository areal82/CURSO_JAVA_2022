package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.impl.HelloServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.example.demo"})
public class Config {
	
	@Bean
	public HelloServiceImpl helloService() {
		return new HelloServiceImpl();
	}
	
}
