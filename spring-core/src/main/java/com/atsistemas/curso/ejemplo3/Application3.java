package com.atsistemas.curso.ejemplo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.ejemplo3.config.Config3;
import com.atsistemas.curso.ejemplo3.model.ITodo3;

public class Application3 {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);
		ITodo3 todo = context.getBean(ITodo3.class);
		System.out.println(todo);
		context.close();
	}
}
