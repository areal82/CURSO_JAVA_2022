package com.atsistemas.curso.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javax.swing.JButton;

public class Ejemplos {
	
	static Logger log = Logger.getLogger("Ejemplos");
	
	public static void main(String[] args) {

//		runnableExample();

//		handleEvent();
//
//		filterWithPredicate();
//		
		addPredicateToLambda();
//		
//		summaryStatistics();
	}

	
	/**
	 * Use la expresión lambda para implementar Runnable
	 */
	private static void runnableExample() {
		// Antes de Java 8:
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do");
			}
		});
		hilo.start();

		// Forma Java 8:
		Thread hiloLambda = new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!"));
		hiloLambda.start();
	}
	
	/**
	 * Use expresiones lambda de Java 8 para el procesamiento de eventos
	 */
	private static void handleEvent() {
		// Antes de Java 8:
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Event handling without lambda expression is boring");
			}
		});

		// Forma Java 8:
		show.addActionListener((e) -> {
			System.out.println("Light, Camera, Action !! Lambda expressions Rocks " + e.getActionCommand());
		});
		
		// SIN PARENTESIS NI LLAVES
		show.addActionListener(e -> 
			System.out.println("Light, Camera, Action !! Lambda expressions Rocks")
		);
		
		show.addActionListener((ActionEvent e) -> {
			System.out.println("Light, Camera, Action !! Lambda expressions Rocks " + e.getActionCommand());
		});
		
		show.addActionListener((ActionEvent e) -> 
			System.out.println("Light, Camera, Action !! Lambda expressions Rocks " + e.getActionCommand())
		);
	}
	
	
	private static void summaryStatistics() {
		// Obtener el número, mínimo, máximo, suma y promedio de números
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		// IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
		log.info("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}
	
	
	private static void addPredicateToLambda() {
		// Incluso puede usar y (), o () funciones lógicas para combinar Predicate,
		// Por ejemplo, para encontrar todos los nombres que comienzan con J y
		// tienen cuatro letras de longitud, puede combinar dos Predicados y pasar
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		List<String> names = List.of("John", "Mariam", "Alex", "Mohammado", "Mohammado", "Vincent", "Alex",
				"Alex");
		names.stream()
			.filter(startsWithJ.and(fourLetterLong))    
//			.filter(startsWithJ)
//		    .filter(fourLetterLong)
		    .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
	}

	
	private static void filterWithPredicate() {
		
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

		System.out.println("Languages which starts with J :");
		filter(languages, str -> ((String) str).startsWith("J"));

		System.out.println("Languages which ends with a ");
		filter(languages, str -> ((String) str).endsWith("a"));

		System.out.println("Print all languages :");
		filter(languages, str -> true);

		System.out.println("Print no language : ");
		filter(languages, (str) -> false);

		System.out.println("Print language whose length greater than 4:");
		filter(languages, str -> ((String) str).length() > 4);
	}

	public static void filter(List<String> names, Predicate<Object> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

	public static void filterWithLambda(List<String> names, Predicate<Object> condition) {
		names.stream()
			.filter((name) -> (condition.test(name)))
			.forEach((name) -> {System.out.println(name + " ");});
	}

}
