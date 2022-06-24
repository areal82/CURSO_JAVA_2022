package com.atsistemas.curso.ejemplo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.ejemplo2.config.Config2;
import com.atsistemas.curso.ejemplo2.model.ITodo2;

public class Application2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
		ITodo2 todo = context.getBean(ITodo2.class);
		System.out.println(todo);
		context.close();
	}

}
