package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class BookProgressDto implements Serializable {

	private static final long serialVersionUID = 5179305429969958666L;

	private UUID id;
	private String thumbnailLink;
	private String title;
	private String author;
	private String description;
	private int pageCount;
	private int currentPage;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getThumbnailLink() {
		return thumbnailLink;
	}
	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
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
	@Override
	public int hashCode() {
		return Objects.hash(author, currentPage, description, id, pageCount, thumbnailLink, title);
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
		return Objects.equals(author, other.author) && currentPage == other.currentPage
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& pageCount == other.pageCount && Objects.equals(thumbnailLink, other.thumbnailLink)
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "UpdateBookProgressDto [id=" + id + ", thumbnailLink=" + thumbnailLink + ", title=" + title + ", author="
				+ author + ", description=" + description + ", pageCount=" + pageCount + ", currentPage=" + currentPage
				+ "]";
	}
}
