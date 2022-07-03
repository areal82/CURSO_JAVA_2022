package com.example.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "greetings")
public class Greeting {

	private Long id;
	private String content;
	private String language;
	
	public Greeting() {
	}
	
	public Greeting(String content, String language) {
		this.content = content;
		this.language = language;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "text", length = 50, nullable = false)
	@NotNull(message = "Content cannot be null")
	@Size(min = 1, max = 50, message = "Greeting Content must be between 1 and 50 characters")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "locale", nullable = false)
	@NotNull(message = "Language cannot be null")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
