package com.atsistemas.formacion.base.spring.examplewebapp.repository;

import java.util.List;

import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;

public interface PeliculasRepository {
	
	void guardarPelicula(Pelicula pelicula);
	
	Integer guardarPeliculaId(Pelicula pelicula);

	List<Pelicula> listarPeliculas();

	Pelicula buscarPelicula(Integer id) throws Exception;

	void eliminarPelicula(Integer idPelicula);
}
