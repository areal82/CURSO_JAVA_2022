package com.atsistemas.curso.ejemplo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.ejemplo4.config.Config4;
import com.atsistemas.curso.ejemplo4.model.ITodo4;

public class Application4 {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config4.class);
		ITodo4 todo = context.getBean(ITodo4.class);
		System.out.println(todo);
		context.close();
	}
}
