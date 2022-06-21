package com.curso.modelo.entidad;

import java.util.Optional;

public class Pelicula {
	
	private Integer id;
	private String titulo;
	
	//No es buena idea colocar atributos del tipo Optional
	//Debemos utilizarlos sólo en métodos como return
	private Optional<Director> director;
	
	public Pelicula() {
		super();
		director = Optional.empty();
	}

	public Pelicula(Integer id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
		
		//Esto sería lo adecuado
		//director = Optional.empty();
		
		// Director d = new Director("Sr. Smith");
		this.director = Optional.of(new Director("Sr. Smith"));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Optional<Director> getDirector() {
		return director;
	}
	
	//
	//Esto no:
	/*
	public void setDirector(Optional<Director> director) {
		this.director = director;
	}*/

	//Asín:
	public void setDirector(Director director) {
		this.director = Optional.of(director);
	}
	

}
