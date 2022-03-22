package com.atsistemas.curso.java.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Value -> //@FieldDefaults(makeFinal = true, level=AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departamento {
	Integer id;
	String nombre;
	List<Persona> personas;
	Persona responsable;
}
