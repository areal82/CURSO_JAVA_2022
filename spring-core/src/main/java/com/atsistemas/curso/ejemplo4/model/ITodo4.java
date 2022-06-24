package com.atsistemas.curso.ejemplo4.model;

import java.time.LocalDate;

public interface ITodo4 {

    long getId();

    String getSummary();

    void setSummary(String summary);

    void setDescription(String description);

    String getDescription();

    boolean isDone();

    void setDone(boolean isDone);

    LocalDate getDueDate();

    void setDueDate(LocalDate dueDate);

    ITodo4 copy();

}