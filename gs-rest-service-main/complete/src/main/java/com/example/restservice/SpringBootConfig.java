package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfig {
	
	@Bean
	String template() {
		return "Hello, %s!";
	}
	
	@Bean
    AtomicLong counter() {
        return new AtomicLong();
    }
}
