package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BookDto implements Serializable {
	
	private static final long serialVersionUID = -5008241177336901858L;
	private String title;
	private List<String> authors;
	private String publisher;
	private String publishedDate;
	private String description;
	private List<IndustryIdentifierDto> industryIdentifiers;
	private int pageCount;
	private List<String> categories;
	private float averageRating;
	private String maturityRating;
	private String language;
	private String previewLink;
	private ImageLinksDto imageLinks;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<IndustryIdentifierDto> getIndustryIdentifiers() {
		return industryIdentifiers;
	}
	public void setIndustryIdentifiers(List<IndustryIdentifierDto> industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
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
	public ImageLinksDto getImageLinks() {
		return imageLinks;
	}
	public void setImageLinks(ImageLinksDto imageLinks) {
		this.imageLinks = imageLinks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authors, averageRating, categories, description, imageLinks, industryIdentifiers, language,
				maturityRating, pageCount, previewLink, publishedDate, publisher, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDto other = (BookDto) obj;
		return Objects.equals(authors, other.authors)
				&& Float.floatToIntBits(averageRating) == Float.floatToIntBits(other.averageRating)
				&& Objects.equals(categories, other.categories) && Objects.equals(description, other.description)
				&& Objects.equals(imageLinks, other.imageLinks)
				&& Objects.equals(industryIdentifiers, other.industryIdentifiers)
				&& Objects.equals(language, other.language) && Objects.equals(maturityRating, other.maturityRating)
				&& pageCount == other.pageCount && Objects.equals(previewLink, other.previewLink)
				&& Objects.equals(publishedDate, other.publishedDate) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "BookDto [title=" + title + ", authors=" + authors + ", publisher=" + publisher + ", publishedDate="
				+ publishedDate + ", description=" + description + ", industryIdentifiers=" + industryIdentifiers
				+ ", pageCount=" + pageCount + ", categories=" + categories + ", averageRating=" + averageRating
				+ ", maturityRating=" + maturityRating + ", language=" + language + ", previewLink=" + previewLink
				+ ", imageLinks=" + imageLinks + "]";
	}

}
