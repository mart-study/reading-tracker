package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.Objects;

public class GoogleBookResultDto implements Serializable {

	private static final long serialVersionUID = -7579049408026464870L;
	private String bookId;
	private String title;
	private String authors;
	private String ISBN;
	private String imageLink;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
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
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
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
		return Objects.hash(ISBN, authors, bookId, imageLink, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoogleBookResultDto other = (GoogleBookResultDto) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(authors, other.authors)
				&& Objects.equals(bookId, other.bookId) && Objects.equals(imageLink, other.imageLink)
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "GoogleBookResultDto [bookId=" + bookId + ", title=" + title + ", authors=" + authors + ", ISBN=" + ISBN
				+ ", imageLink=" + imageLink + "]";
	}
}
