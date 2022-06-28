package com.atsistemas.formacion.base.spring.examplewebapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.formacion.base.spring.examplewebapp.model.FiltrosPelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.service.PeliculasService;

@RestController
public class PeliculasController {

	private PeliculasService peliculasService;

	public PeliculasController(PeliculasService peliculasService) {
		this.peliculasService = peliculasService;
	}

	// @GetMapping("/peliculas")
	@GetMapping(value = "/peliculas", produces = MediaType.APPLICATION_JSON_VALUE)
	// @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pelicula> listadoPeliculas() {
		return peliculasService.listarPeliculas();
	}

	@PostMapping(value = "/peliculas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {

		peliculasService.guardarPelicula(pelicula);

		return pelicula;
	}

	@GetMapping(value = "/peliculas/{idPelicula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pelicula obtenerPelicula(@PathVariable(value = "idPelicula") Integer idPelicula) {
		return peliculasService.buscarPelicula(idPelicula);
	}

	@PutMapping(value = "/peliculas/{idPelicula}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Pelicula modificarPelicula(@PathVariable(value = "idPelicula") Integer idPelicula,
			@RequestBody Pelicula pelicula) {
		pelicula.setId(idPelicula);
		peliculasService.guardarPelicula(pelicula);

		return pelicula;
	}

	@DeleteMapping(value = "/peliculas/{idPelicula}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarPelicula(@PathVariable(value = "idPelicula") Integer idPelicula) {
		peliculasService.eliminarPelicula(idPelicula);

	}

	@GetMapping(value = "/peliculas/generos/{genero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pelicula> obtenerPeliculasGenero(@PathVariable(value = "genero") String genero) {
		return peliculasService.buscarPeliculaGenero(genero);
	}

	@GetMapping(value = "/peliculas/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pelicula> buscarPeliculas(FiltrosPelicula filtrosPelicula) {
		return peliculasService.buscarPeliculas(filtrosPelicula);
	}

	@GetMapping(value = "/peliculas/21th", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pelicula> buscarPeliculasSiglo21() {
		return peliculasService.buscarPeliculasSiglo21();
	}
}
