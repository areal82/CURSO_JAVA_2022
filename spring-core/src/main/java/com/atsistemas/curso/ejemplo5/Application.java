package com.atsistemas.curso.ejemplo5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.ejemplo5.config.Config;
import com.atsistemas.curso.ejemplo5.model.ITodo;


public class Application {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ITodo todo1 = context.getBean(ITodo.class);
		ITodo todo2 = context.getBean(ITodo.class);
		todo1.setSummary("Spring DI 1");
		todo2.setSummary("Spring DI 2");
		System.out.println(todo1);
		System.out.println(todo2);
		context.close();
	}
}
