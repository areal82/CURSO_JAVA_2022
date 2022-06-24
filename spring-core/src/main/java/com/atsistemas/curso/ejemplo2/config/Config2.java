package com.atsistemas.curso.ejemplo2.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.atsistemas.curso.ejemplo2.model.ITodo2;
import com.atsistemas.curso.ejemplo2.model.Todo2;

@Configuration
@ComponentScan(basePackages = { "com.atsistemas.curso.ejemplo2" })
public class Config2 {

	@Primary
	@Bean
	public ITodo2 getTodo() {
		ITodo2 todo = new Todo2(0, "Spring DI");
		todo.setDone(false);
		todo.setDueDate(LocalDate.now());
		return todo;
	}

}