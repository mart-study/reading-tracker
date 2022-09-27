package com.reading.tracker.dto;

import java.util.Objects;

public class KeySearchDto extends PageRequestDto {

	private String title;
	private String author;
	
	public KeySearchDto() {
		
	}
	
	public KeySearchDto(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeySearchDto other = (KeySearchDto) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "KeySearchDto [title=" + title + ", author=" + author + "]";
	}
}
