package com.atsistemas.curso.ejemplo2.model;

import java.time.LocalDate;

public interface ITodo2 {

	long getId();

	String getSummary();

	void setSummary(String summary);

	boolean isDone();

	void setDone(boolean isDone);

	LocalDate getDueDate();

	void setDueDate(LocalDate dueDate);

	ITodo2 copy();

}