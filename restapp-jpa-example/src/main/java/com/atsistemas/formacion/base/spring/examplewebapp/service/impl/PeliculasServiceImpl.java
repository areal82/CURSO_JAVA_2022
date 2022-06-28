package com.atsistemas.formacion.base.spring.examplewebapp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.atsistemas.formacion.base.spring.examplewebapp.model.FiltrosPelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.repository.PeliculaRepository;
import com.atsistemas.formacion.base.spring.examplewebapp.service.PeliculasService;

@Service
public class PeliculasServiceImpl implements PeliculasService {

	private PeliculaRepository peliculaRepository;

	public PeliculasServiceImpl(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula buscarPelicula(Integer id) {
		return peliculaRepository.findById(id);
	}

	@Override
	@Transactional
	public void guardarPelicula(Pelicula pelicula) {
		
		if (pelicula.getId() == null) {
			peliculaRepository.insert(pelicula);
		} else {
			peliculaRepository.update(pelicula);
		}
	}

	@Override
	@Transactional
	public void eliminarPelicula(Integer idPelicula) {
		peliculaRepository.delete(idPelicula);
	}

	@Override
	public List<Pelicula> buscarPeliculaGenero(String genero) {
		return peliculaRepository.findByGenero(genero);
	}

	@Override
	public List<Pelicula> buscarPeliculas(FiltrosPelicula filtrosPelicula) {
		return peliculaRepository.search(filtrosPelicula);
	}

	@Override
	public List<Pelicula> buscarPeliculasSiglo21() {
		return peliculaRepository.findBy21Century();
	}

}
