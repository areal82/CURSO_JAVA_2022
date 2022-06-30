package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Persona")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	@NotNull(message = "El campo nombre no puede ser nulo")
	private String nombre;
	
	@Column(name = "apellido", nullable = true)
	@Size(min = 1, max = 10, message = "El apellido debe tener de 1 a 10 caracteres")
	private String apellido;
	
	@Column(name = "departamento_id", nullable = false, insertable = true, updatable = true)
	private Integer departamentoId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento_id", insertable = false, updatable = false)
	private Departamento departamento;
	
	@Min(value = 18, message = "La edad no debe ser menor a 18 años")
    @Max(value = 150, message = "La edad no debe ser mayor de 65 años")
    private Integer edad;
	
	@Email(message = "Email should be valid")
    private String email;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
