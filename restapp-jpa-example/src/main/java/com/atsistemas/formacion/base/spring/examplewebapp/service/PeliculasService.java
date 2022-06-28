package com.atsistemas.formacion.base.spring.examplewebapp.service;

import java.util.List;

import com.atsistemas.formacion.base.spring.examplewebapp.model.FiltrosPelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;

public interface PeliculasService {

	void guardarPelicula(Pelicula pelicula);

	List<Pelicula> listarPeliculas();

	Pelicula buscarPelicula(Integer id);

	void eliminarPelicula(Integer idPelicula);

	List<Pelicula> buscarPeliculaGenero(String genero);
	
	List<Pelicula> buscarPeliculas(FiltrosPelicula filtrosPelicula);

	List<Pelicula> buscarPeliculasSiglo21();
}
