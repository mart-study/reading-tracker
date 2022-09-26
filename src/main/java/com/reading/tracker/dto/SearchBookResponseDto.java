package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SearchBookResponseDto implements Serializable {

	private static final long serialVersionUID = -7579049408026464870L;
	private String id;
	private String title;
	private List<String> authors;
	private String publisher;
	private String publishedDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authors, id, publishedDate, publisher, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchBookResponseDto other = (SearchBookResponseDto) obj;
		return Objects.equals(authors, other.authors) && Objects.equals(id, other.id)
				&& Objects.equals(publishedDate, other.publishedDate) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "SearchBookResponseDto [id=" + id + ", title=" + title + ", authors=" + authors + ", publisher="
				+ publisher + ", publishedDate=" + publishedDate + "]";
	}
}
