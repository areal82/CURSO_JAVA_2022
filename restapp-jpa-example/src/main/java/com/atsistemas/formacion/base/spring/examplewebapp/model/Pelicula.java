package com.atsistemas.formacion.base.spring.examplewebapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PELICULA")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITULO", length = 100)
	private String titulo;
	@Column(name = "DIRECTOR", length = 50)
	private String director;
	@Column(name = "GENERO", length = 20)
	private String genero;
	@Column(name = "FECHA_ESTRENO", length = 4)
	private Integer fechaEstreno;

	public Pelicula() {
		super();
	}

	public Pelicula(Integer id, String titulo, String director, String genero, Integer fechaEstreno) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.fechaEstreno = fechaEstreno;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Integer fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

}
