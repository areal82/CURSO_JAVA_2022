package com.atsistemas.curso.ejemplo4.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.atsistemas.curso.ejemplo" })
public class Config {

	@Bean
	public Long getId() {
		return Long.valueOf(1);
	}

	@Bean
	public String getSummary() {
		return "Spring DI";
	}

	@Bean
	public String getDescription() {
		return "Dependency in Spring is a powerful feauture for inversion of control.";
	}

	@Bean
	public Boolean isDone() {
		return Boolean.FALSE;
	}

	@Bean
	public LocalDate getDueDate() {
		return LocalDate.now();
	}
}