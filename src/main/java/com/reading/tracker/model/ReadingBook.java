package com.reading.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reading_book")
public class ReadingBook extends ReadBook {

	@Override
	public String toString() {
		return "ReadingBook [toString()=" + super.toString() + "]";
	}
	
}
