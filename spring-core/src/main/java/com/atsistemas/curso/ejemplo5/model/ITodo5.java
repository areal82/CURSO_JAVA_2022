package com.atsistemas.curso.ejemplo5.model;

import java.time.LocalDate;

public interface ITodo5 {

    long getId();

    String getSummary();

    void setSummary(String summary);

    void setDescription(String description);

    String getDescription();

    boolean isDone();

    void setDone(boolean isDone);

    LocalDate getDueDate();

    void setDueDate(LocalDate dueDate);

    ITodo5 copy();

}