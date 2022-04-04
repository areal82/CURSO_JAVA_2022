package com.atsistemas.formacion.base.spring.examplewebapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.repository.PeliculasRepository;
import com.atsistemas.formacion.base.spring.examplewebapp.service.PeliculasService;

@Service
public class PeliculasServiceImpl implements PeliculasService {
	
	// @Autowired
	private final PeliculasRepository repository;

	public PeliculasServiceImpl(final PeliculasRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Pelicula buscarPelicula(Integer id) {
		Pelicula resultado;
		try {
			resultado = repository.buscarPelicula(id);
		} catch (Exception e) {
			resultado = new Pelicula();
			resultado.setTitulo("ERROR");
			return resultado;
		}
		return Objects.nonNull(resultado) ? resultado : new Pelicula();
	}
	
	@Override
	public void guardarPelicula(Pelicula pelicula) {
		repository.guardarPelicula(pelicula);
	}
	
	public Integer guardarPeliculaId(Pelicula pelicula) {
		if(Objects.isNull(pelicula)) {
			return Integer.valueOf(-1);
		}
		else {
			return repository.guardarPeliculaId(pelicula);
		}
	}
	
	@Override
	public List<Pelicula> listarPeliculas() throws Exception{
		List<Pelicula> resultado = repository.listarPeliculas();
		
//		if(!resultado.isEmpty()) {
//			resultado = new ArrayList<>();
//		}
		
		return resultado;
	}

	@Override
	public void eliminarPelicula(Integer idPelicula) {
		repository.eliminarPelicula(idPelicula);
	}

}
