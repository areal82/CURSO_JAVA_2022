package com.example.restservice.dto;

import java.io.Serializable;

public class GreetingDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String content;
	private String language;

	public GreetingDTO(String content, String language) {
		this.content = content;
		this.language = language;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "GreetingDTO [content=" + content + ", language=" + language + "]";
	}
}
