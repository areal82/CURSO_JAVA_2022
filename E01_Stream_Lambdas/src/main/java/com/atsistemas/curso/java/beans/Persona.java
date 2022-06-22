package com.atsistemas.curso.java.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class Persona {
	Integer identificador;
	String nombre;
	String apellido;
	String correo;
	String genero;
	String profesion;
	Integer edad;
	Persona tutor;
	
	@Override
	public String toString() {
		String result = "Persona [identificador=" + identificador + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
				+ correo + ", genero=" + genero + ", edad=" + edad + "]";
		System.out.println(result);
		return result;
	}

	public Persona() {
		identificador = Integer.valueOf(0);
		nombre = "";
		apellido = "";
		correo = "";
		genero = "";
		edad = Integer.valueOf(0);
		tutor = new Persona();
		profesion = "";
	}
	
	
}
