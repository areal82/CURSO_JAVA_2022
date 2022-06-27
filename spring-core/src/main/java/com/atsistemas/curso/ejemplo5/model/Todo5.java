package com.atsistemas.curso.ejemplo5.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class Todo5 implements ITodo5 {

	public final long id;

	private String summary;

	private String description;

	private Boolean done;

	private LocalDate dueDate;

	public Todo5() {
		this(-1);
	}

	public Todo5(long i) {
		this(i, "");
	}

	@Autowired
	public Todo5(long i, @Qualifier("summary") String summary) {
		this.id = i;
		this.summary = summary;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getSummary() {
		return summary;
	}

	@Override
	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Autowired
	@Qualifier("description")
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean isDone() {
		return done;
	}

	@Autowired
	@Override
	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	@Override
	public LocalDate getDueDate() {
		return dueDate;
	}

	@Autowired
	@Override
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo5 other = (Todo5) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", summary=" + summary + ", description=" + description + "]";
	}

	@Override
	public Todo5 copy() {
		Todo5 todo = new Todo5(id, summary);
		todo.setDone(isDone());
		todo.setDueDate(getDueDate());
		todo.setDescription(getDescription());

		return todo;
	}
}