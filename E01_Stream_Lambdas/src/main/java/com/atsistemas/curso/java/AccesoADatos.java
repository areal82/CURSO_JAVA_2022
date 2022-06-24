package com.atsistemas.curso.java;

public class AccesoADatos {
	
	private DatabaseService dbService = new DatabaseService();
	
	public String temp() {
		return dbService.getDatos();
	}
}
