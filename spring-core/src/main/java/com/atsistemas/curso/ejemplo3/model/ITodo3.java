package com.atsistemas.curso.ejemplo3.model;

import java.time.LocalDate;

public interface ITodo3 {

	long getId();

	String getSummary();

	void setSummary(String summary);

	boolean isDone();

	void setDone(boolean isDone);

	LocalDate getDueDate();

	void setDueDate(LocalDate dueDate);

	ITodo3 copy();

}