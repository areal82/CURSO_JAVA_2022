package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PersonaDepartamento")
@IdClass(PersonaDepartamentoKey.class)
public class PersonaDepartamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private PersonaDepartamentoKey id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	@Column(name = "id_persona")
	private Persona persona;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	@Column(name = "id_departamento")
	private Departamento departamento;

	public PersonaDepartamentoKey getId() {
		return id;
	}

	public void setId(PersonaDepartamentoKey id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
