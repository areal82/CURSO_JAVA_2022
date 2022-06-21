package com.atsistemas.curso.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomUtils;

import com.atsistemas.curso.java.beans.Person;
import com.atsistemas.curso.java.beans.Persona;

public class EjemploPersonas {

	public static void main(String[] args) {
		
		
		List<String> listaCadenas = new ArrayList<>();
		
		listaCadenas.forEach((String cadena) -> System.out.println(cadena));
		listaCadenas.forEach(System.out::println);
		
		
		Map<String, String> mapPersonas = new HashMap<>();
		mapPersonas.put("María", "Gonzalez");
		mapPersonas.put("Marta", "Dueñas");
		mapPersonas.put("Juan", "Rubio");
		mapPersonas.put("Javier", "Sanchez");
		
		
		List<Person> people = new ArrayList<>();
		mapPersonas.forEach((String clave, String valor) -> 
			{
				people.add(Person.builder()
						.firstName(clave)
						.lastName(valor)
		                .id(RandomUtils.nextInt())
		                .build());
			}
		);
		
//		mapPersonas.forEach((clave, valor) -> 
//			people.add(Person.builder()
//						.firstName(clave)
//						.lastName(valor)
//		                .id(RandomUtils.nextInt())
//		                .build())
//		);
		
		
		List<Persona> personas = people.stream().map(person -> {
			return Persona.builder()
				.identificador(person.getId())
				.nombre(person.getFirstName())
				.apellido(person.getLastName())
				.build();
			
		}).collect(Collectors.toList());
		
//		personas = people.stream().map(person -> 
//			Persona.builder()
//				.identificador(person.getId())
//				.nombre(person.getFirstName())
//				.build()
//		).collect(Collectors.toList());
		
		// Expresión lambda con referencia a método de un tipo
		personas.forEach(Persona::toString);
//		personas.forEach(p -> p.toString());
//		personas.forEach((Persona p) -> p.toString());
		
		List<Integer> lengthOfNames = personas.stream()
				.map(persona -> Objects.nonNull(persona.getNombre()) 
	    		 ? persona.getNombre().length() : Integer.valueOf(0))
	     .collect(Collectors.toList());
		
		// Expresión lambda con referencia a método de un tipo
		// lengthOfNames.forEach((Integer size) -> size.intValue());
		lengthOfNames.forEach(Integer::intValue);
		lengthOfNames.forEach(lengthOfName -> System.out.println(lengthOfName.intValue()));
		
		
		
	}

}
