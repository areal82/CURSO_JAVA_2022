package com.curso.modelo.negocio;

import java.util.Optional;

import com.curso.modelo.entidad.Pelicula;

public class PeliculaRepositorio {

	public Pelicula buscar(Integer id){
		
		switch(id){
			case 1 : return new Pelicula(1,"Alien");
			case 2 : return new Pelicula(2,"Die Hard");
			case 3 : return new Pelicula(3,"Dracula");
			default: return null;		
		}
		
	}
	
	public Optional<Pelicula> buscarOptional(Integer id){
			
		switch(id){
			case 1 : return Optional.of(new Pelicula(1,"Alien"));
			case 2 : return Optional.of(new Pelicula(2,"Die Hard"));
			case 3 : return Optional.of(new Pelicula(3,"Dracula"));
			default: return Optional.empty();		
		}
		
	}
	
}
