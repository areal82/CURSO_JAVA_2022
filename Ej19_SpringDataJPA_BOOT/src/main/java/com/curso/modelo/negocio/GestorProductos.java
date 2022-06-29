package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.bbdd2.modelo.Producto;
import com.curso.bbdd2.repo.ProductoRepositorio;

@Service
public class GestorProductos {

	@Autowired
	private ProductoRepositorio productoRepo;

	@Transactional(value = "bbdd2JpaTransactionManager")
	public void insertar(Producto producto){
		productoRepo.save(producto);
	}
	
}
