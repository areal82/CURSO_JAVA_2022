package com.atsistemas.curso.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;

import com.atsistemas.curso.java.beans.Departamento;
import com.atsistemas.curso.java.beans.Persona;

public class EjemploDepartamento {

	public static void main(String[] args) {
		
		Map<String,String> mapNombres = new HashMap<>();
		mapNombres.put("María","Gonzalez");
		mapNombres.put("Marta","Dueñas");
		mapNombres.put("Juan","Rubio");
		mapNombres.put("Javier","Sanchez");
		
		List<Persona> personas = new ArrayList<>();
//		mapNombres.forEach((k,v) -> 
//			personas.add(Persona.builder()
//						.identificador(RandomUtils.nextInt())
//						.nombre(k)
//						.apellido(v)
//		                .build())
//		);
		
		Map<Integer, Persona> mapPersonas = new HashMap<>();
		
		mapNombres.forEach((String clave, String valor) -> { 
			
			Persona persona = Persona.builder()
					.identificador(RandomUtils.nextInt())
					.nombre(clave)
					.apellido(valor)
	                .build();
			
			personas.add(persona);
			
			mapPersonas.put(persona.getIdentificador(), persona);
		});
		
		
		final Map<Integer, String> mapDepartamentos = new HashMap<>();
		mapDepartamentos.put(1, "Java");
		mapDepartamentos.put(Integer.valueOf(2), ".Net");
		mapDepartamentos.put(Integer.parseInt("3"), "Sistemas");
		mapDepartamentos.put(Integer.decode("4"), "Arquitectura");
		
		
		// OBTENEMOS LA LISTA DE PERSONAS DEL MAPA
		List<Persona> personasValue = (List<Persona>) mapPersonas.values();
		
		Set<Integer> identificadores = mapPersonas.keySet();
		
		Optional<Integer> idOpt = identificadores.stream().findAny();
		
		Persona responsable = new Persona();
		if(idOpt.isPresent()) {
			Integer identificador = idOpt.get();
			responsable = mapPersonas.get(identificador);
		}
		
		final List<Departamento> departamentos = new ArrayList<>();
		
		// Especificando el tipo de parametros y usando llaves con ;
		mapDepartamentos.forEach((Integer k, String v) -> 
			{
				Departamento dep = Departamento.builder()
						.id(k)
		                .nombre(v)
		                .personas(personas)
		                .responsable(idOpt.isPresent() ? 
		                		personasValue.get(idOpt.get()) : null)
		                .build();
				departamentos.add(dep);
			}
		);
		
		// Sin especificar tipos ni usando llaves ni ;
//		mapDepartamentos.forEach((k, v) -> 
//			departamentos.add(Departamento.builder()
//	                //.id(RandomUtils.nextInt())
//					.id(k)
//	                .nombre(v)
//	                .personas(personas)
//	                .responsable(mapPersonas.get(1))
//	                .build())
//		);
		
		
		
		departamentos.stream()
			//.filter(d -> Objects.nonNull(d.getResponsable()))
			.filter((Departamento d) -> Objects.nonNull(d.getResponsable()))
			.filter((Departamento d) -> Objects.nonNull(d.getResponsable().getTutor()))
			.findFirst()
			.map(departamento -> departamento.getResponsable())
			.ifPresent((Persona p) -> System.out.println(p.getNombre()));
		
	}

}
