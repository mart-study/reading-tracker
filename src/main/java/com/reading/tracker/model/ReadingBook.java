package com.reading.tracker.model;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reading_book")
public class ReadingBook extends ReadBook {
	
	@Id
    @GeneratedValue
	private UUID id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReadingBook other = (ReadingBook) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ReadingBook [id=" + id + ", toString()=" + super.toString() + "]";
	}
}
