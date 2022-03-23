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
		
		
		Map<String, String> mapPersonas = new HashMap<>();
		mapPersonas.put("María", "Gonzalez");
		mapPersonas.put("Marta", "Dueñas");
		mapPersonas.put("Juan", "Rubio");
		mapPersonas.put("Javier", "Sanchez");
		// mapPersonas.put("María", "Dueñas");
		
		
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
//		mapPersonas.forEach((k,v)-> 
//			people.add(Person.builder()
//						.firstName(k)
//						.lastName(v)
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
		
		List<Integer> lengthOfNames = personas.stream()
				.map(persona -> Objects.nonNull(persona.getNombre()) 
	    		 ? persona.getNombre().length() : Integer.valueOf(0))
	     .collect(Collectors.toList());
		
		// Expresión lambda con referencia a método de un tipo
		lengthOfNames.forEach(Integer::intValue);
		lengthOfNames.forEach(lengthOfName -> System.out.println(lengthOfName.intValue()));
		
		
		
	}

}
