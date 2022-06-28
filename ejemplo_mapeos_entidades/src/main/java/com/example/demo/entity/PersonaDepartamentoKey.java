package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonaDepartamentoKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "id_persona")
	private Integer personaId;
	
	@Column(name = "id_departamento")
	private Integer departamentoId;
	
	public Integer getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	public Integer getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}
}
