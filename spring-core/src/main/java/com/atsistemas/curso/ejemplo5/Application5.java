package com.atsistemas.curso.ejemplo5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.ejemplo5.config.Config5;
import com.atsistemas.curso.ejemplo5.model.ITodo5;


public class Application5 {
	
	public static void main(String[] args) {
		
		// FIXME
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config5.class);
		ITodo5 todo1 = context.getBean(ITodo5.class);
		ITodo5 todo2 = context.getBean(ITodo5.class);
		todo1.setSummary("Spring DI 1");
		todo2.setSummary("Spring DI 2");
		System.out.println(todo1);
		System.out.println(todo2);
		context.close();
	}
}
