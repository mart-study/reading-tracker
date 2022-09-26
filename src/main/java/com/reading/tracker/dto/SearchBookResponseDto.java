package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SearchBookResponseDto implements Serializable {

	private static final long serialVersionUID = -7579049408026464870L;
	private String id;
	private String title;
	private List<String> authors;
	private String ISBN;
	private String imageLink;
	
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
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN, authors, id, imageLink, title);
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
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(authors, other.authors)
				&& Objects.equals(id, other.id) && Objects.equals(imageLink, other.imageLink)
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "SearchBookResponseDto [id=" + id + ", title=" + title + ", authors=" + authors + ", ISBN=" + ISBN
				+ ", imageLink=" + imageLink + "]";
	}
}
