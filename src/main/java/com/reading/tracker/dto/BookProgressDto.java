package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class BookProgressDto implements Serializable {

	private static final long serialVersionUID = 5179305429969958666L;

	private UUID id;
	private String imageLink;
	private String title;
	private String authors;
	private String description;
	private int pageCount;
	private int currentPage;
	private boolean completeStatus;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isCompleteStatus() {
		return completeStatus;
	}
	public void setCompleteStatus(boolean completeStatus) {
		this.completeStatus = completeStatus;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(authors, completeStatus, currentPage, description, id, imageLink, pageCount, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookProgressDto other = (BookProgressDto) obj;
		return Objects.equals(authors, other.authors) && completeStatus == other.completeStatus
				&& currentPage == other.currentPage && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(imageLink, other.imageLink)
				&& pageCount == other.pageCount && Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "BookProgressDto [id=" + id + ", imageLink=" + imageLink + ", title=" + title + ", authors=" + authors
				+ ", description=" + description + ", pageCount=" + pageCount + ", currentPage=" + currentPage
				+ ", completeStatus=" + completeStatus + "]";
	}
	
}
