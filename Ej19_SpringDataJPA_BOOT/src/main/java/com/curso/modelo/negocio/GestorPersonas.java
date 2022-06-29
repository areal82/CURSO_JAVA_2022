package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.bbdd1.modelo.Persona;
import com.curso.bbdd1.repo.PersonaRepositorio;

@Service
public class GestorPersonas {

	@Autowired
	private PersonaRepositorio personaRepo;

	@Transactional(value = "bbdd1JpaTransactionManager")
	public void insertar(Persona persona){
		personaRepo.save(persona);
	}
	
}
