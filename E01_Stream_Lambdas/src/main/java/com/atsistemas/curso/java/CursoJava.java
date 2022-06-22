package com.atsistemas.curso.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.atsistemas.curso.MavenBean;

public class CursoJava {

	public static void main(String[] args) {
		
		
//		MavenBean test = new MavenBean("Pepe");
//		test.getNombre();
		
		
		List<String> names = List.of("John", "John", "Mariam", "Alex", "Marlon", "Marlon", "Vincent", "Alex",
				"Alex");

		System.out.println("-------------");
		System.out.println("FOR CLÁSICO");
		System.out.println("-------------");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println("-------------");
		System.out.println("FOR EACH");
		System.out.println("-------------");
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println("########################");
		System.out.println();
		System.out.println();
		
		System.out.println("Expresión lambda sin referencias");
		System.out.println("-----------------------------------");
		names.forEach((String name) -> System.out.println(name));
		
		System.out.println("########################");
		System.out.println();
		System.out.println();

		
		System.out.println("Expresión lambda con referencia a método estático");
		System.out.println("-------------------------------------------------");

		names.forEach(System.out::println);
		
		System.out.println("########################");
		System.out.println();
		System.out.println();

		/*************
		 * API Stream *
		 **************/
		// Filter
		System.out.println("FILTER");
		System.out.println("-------------");
		
		names.stream().filter(name -> name.contains("o")).forEach(System.out::println);
		
		System.out.println("########################");
		System.out.println();
		System.out.println();

		
		System.out.println("SORTED");
		System.out.println("-------------");
		
		names.stream()
			.sorted(Comparator.naturalOrder()) //.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);
		
		System.out.println("########################");
		System.out.println();
		System.out.println();


		System.out.println("Custom Comparator");
		System.out.println("-------------------");
		
		names.stream()
			.sorted(Comparator.comparing(String::length))
			.forEach(System.out::println);
		
		System.out.println("########################");
		System.out.println();
		System.out.println();
		

		System.out.println("Combine Comparators");
		System.out.println("-------------------");
		
		names.stream()
			.sorted(Comparator.comparing(String::length)
			.thenComparing(Comparator.naturalOrder())
			// .thenComparing(XXXXXX)
			// .thenComparing(YYYYYY)
			)
			.forEach(System.out::println);
		
		System.out.println("########################");
		System.out.println();
		System.out.println();
		
		System.out.println("DISTINCT");
		System.out.println("-------------------");
		
		names.stream()
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("########################");
		System.out.println();
		System.out.println();
		
		System.out.println("LIMIT");
		System.out.println("-------------------");
		
		names.stream()
		   .limit(5)
		   .forEach(System.out::println);
		
		System.out.println("########################");
		System.out.println();
		System.out.println();
		
		System.out.println("REDUCE");
		System.out.println("-------------------");
	
		String reduceResult = names.stream().reduce("PREFIX-", String::concat);
		System.out.println(reduceResult);
 	
		System.out.println("########################");
		System.out.println();
		System.out.println();
		
		System.out.println("REDUCE NUMBERS");
		System.out.println("-------------------");
		
		Integer[] integers = {1, 2, 3, 4, 5};
		Integer reduce = Arrays.stream(integers).reduce(0, Integer::sum);
		
		System.out.println(reduce);
		System.out.println("########################");
		System.out.println();
		System.out.println();
		
		System.out.println("COLLECT LIST");
		System.out.println("-------------------");
		List<String> oNames = names.stream().filter(name -> name.contains("o")).collect(Collectors.toList());
		oNames.forEach(System.out::println);
		System.out.println();
		System.out.println("COLLECT MAP -> Counting names");
		System.out.println("-------------------");
		Map<String, Long> counting =
				names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(counting);
		
		System.out.println("COLLECT MAP -> Joining names");
		System.out.println("-------------------");
		// Eliminar duplicados, cambiar la cadena a mayúsculas y vincularlas con una coma
		String collectJoin = names.stream().distinct().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(collectJoin);
		
		
		System.out.println("########################");
		System.out.println();
		System.out.println();
		
	}

}
