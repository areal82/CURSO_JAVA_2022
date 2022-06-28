package com.atsistemas.formacion.base.spring.examplewebapp.model;

public class FiltrosPelicula {

	private String titulo;
	private String director;
	private String genero;
	private Integer fechaEstreno;

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the fechaEstreno
	 */
	public Integer getFechaEstreno() {
		return fechaEstreno;
	}

	/**
	 * @param fechaEstreno the fechaEstreno to set
	 */
	public void setFechaEstreno(Integer fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

}
