package com.curso.bbdd1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.bbdd1.modelo.Persona;

//Esta anotación es completamente opcional
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer>{

}
