package com.curso.bbdd2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.bbdd2.modelo.Producto;

//Esta anotación es completamente opcional
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
	
}
