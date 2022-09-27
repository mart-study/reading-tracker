package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BookDetailDto implements Serializable {

	private static final long serialVersionUID = 2030282476434276000L;
	private String googleId;
	private String title;
	private String authors;
	private String publisher;
	private String publishedDate;
	private String description;
	private String ISBN;
	private int pageCount;
	private List<String> categories;
	private float averageRating;
	private String maturityRating;
	private String language;
	private String previewLink;
	private String imageLink;
	
	public String getGoogleId() {
		return googleId;
	}
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	public String getMaturityRating() {
		return maturityRating;
	}
	public void setMaturityRating(String maturityRating) {
		this.maturityRating = maturityRating;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPreviewLink() {
		return previewLink;
	}
	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN, authors, averageRating, categories, description, imageLink, language, maturityRating,
				pageCount, previewLink, publishedDate, publisher, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDetailDto other = (BookDetailDto) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(authors, other.authors)
				&& Float.floatToIntBits(averageRating) == Float.floatToIntBits(other.averageRating)
				&& Objects.equals(categories, other.categories) && Objects.equals(description, other.description)
				&& Objects.equals(imageLink, other.imageLink) && Objects.equals(language, other.language)
				&& Objects.equals(maturityRating, other.maturityRating) && pageCount == other.pageCount
				&& Objects.equals(previewLink, other.previewLink) && Objects.equals(publishedDate, other.publishedDate)
				&& Objects.equals(publisher, other.publisher) && Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "BookDetailDto [title=" + title + ", authors=" + authors + ", publisher=" + publisher
				+ ", publishedDate=" + publishedDate + ", description=" + description + ", ISBN=" + ISBN
				+ ", pageCount=" + pageCount + ", categories=" + categories + ", averageRating=" + averageRating
				+ ", maturityRating=" + maturityRating + ", language=" + language + ", previewLink=" + previewLink
				+ ", imageLink=" + imageLink + "]";
	}
}
