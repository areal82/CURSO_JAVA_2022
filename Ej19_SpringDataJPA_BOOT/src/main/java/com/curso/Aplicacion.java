package com.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.bbdd1.modelo.Persona;
import com.curso.bbdd1.repo.PersonaRepositorio;
import com.curso.bbdd2.modelo.Producto;
import com.curso.bbdd2.repo.ProductoRepositorio;
import com.curso.modelo.negocio.GestorPersonas;
import com.curso.modelo.negocio.GestorProductos;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired private GestorPersonas gestorPersonas;
	@Autowired private PersonaRepositorio personaRepo;
	@Autowired private GestorProductos gestorProductos;
	@Autowired private ProductoRepositorio productoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("========================================");
		Persona p1 = new Persona(null,"Ringo Starr","C/Tal","555123");
		Persona p2 = new Persona(null, "Groucho Marx", "C/Tal", "555123");
		gestorPersonas.insertar(p1);
		gestorPersonas.insertar(p2);

		List<Persona> personas = personaRepo.findAll();
		for(Persona pAux: personas){
			System.out.println(pAux);
		}

		System.out.println("========================================");
		Producto pr1 = new Producto(null,"Chintáfono","Ibérica de Chintáfonos S.A.",100d);
		Producto pr2 = new Producto(null,"Elemento disruptor", "Elementos de la Armuña S.L.", 200d);
		gestorProductos.insertar(pr1);
		gestorProductos.insertar(pr2);
		
		List<Producto> Productos = productoRepo.findAll();
		for(Producto pAux: Productos){
			System.out.println(pAux);
		}
		
	}

}
