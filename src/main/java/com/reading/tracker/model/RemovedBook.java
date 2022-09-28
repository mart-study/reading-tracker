package com.reading.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_removed_book")
public class RemovedBook extends ReadBook {

	@Override
	public String toString() {
		return "RemovedBook [toString()=" + super.toString() + "]";
	}
}
