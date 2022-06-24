package com.atsistemas.curso.ejemplo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.ejemplo4.config.Config;
import com.atsistemas.curso.ejemplo4.model.ITodo;

public class Application {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ITodo todo = context.getBean(ITodo.class);
		System.out.println(todo);
		context.close();
	}
}
