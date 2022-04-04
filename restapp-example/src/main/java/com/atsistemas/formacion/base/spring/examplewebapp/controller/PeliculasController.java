package com.atsistemas.formacion.base.spring.examplewebapp.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.service.PeliculasService;

@RestController
public class PeliculasController {

	private PeliculasService peliculasService;

	public PeliculasController(PeliculasService peliculasService) {
		this.peliculasService = peliculasService;
	}

	@GetMapping(value = "/peliculas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pelicula> listadoPeliculas() {
		try {
			return peliculasService.listarPeliculas();
		} catch (Exception e) {
			return null;
		}
	}

}
