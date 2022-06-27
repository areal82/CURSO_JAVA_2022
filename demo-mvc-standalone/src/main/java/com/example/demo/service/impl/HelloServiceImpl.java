package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello() {
		return "Hello World!";
	}

}
