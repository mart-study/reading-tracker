package com.reading.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_key_search")
public class KeySearch {

	@Id
	private String keyword;
	private int count;
	
	public KeySearch() {
		
	}
	
	public KeySearch(String keyword, String keywordIn, int count) {
		this.keyword = keyword;
		this.count = count;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
