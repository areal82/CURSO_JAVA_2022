package com.atsistemas.curso.ejemplo2.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Todo2 implements ITodo2 {

	public final long id;
	private String summary;
	private Boolean done;
	private LocalDate dueDate;

	public Todo2() {
		this(-1);
	}

	public Todo2(long i) {
		this(i, "");
	}

	public Todo2(long i, String summary) {
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
	public boolean isDone() {
		return done;
	}

	@Override
	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	@Override
	public LocalDate getDueDate() {
		return dueDate;
	}

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
		Todo2 other = (Todo2) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", summary=" + summary + "]";
	}

	@Override
	public Todo2 copy() {
		Todo2 todo = new Todo2(id, summary);
		todo.setDone(this.isDone());
		todo.setDueDate(this.getDueDate());
		return todo;
	}
}