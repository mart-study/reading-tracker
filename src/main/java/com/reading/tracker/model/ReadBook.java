package com.reading.tracker.model;

import java.util.Date;
import java.util.Objects;

public class ReadBook {

	private String googleId;
	private String thumbnailLink;
	private String title;
	private String author;
	private String description;
	private int pageCount;
	private int currentPage;
	private String updatedBy;
	private Date updatedDate;
	private String createdBy;
	private Date createdDate;
	
	public String getGoogleId() {
		return googleId;
	}
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
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
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, currentPage, description, googleId, pageCount, thumbnailLink, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReadBook other = (ReadBook) obj;
		return Objects.equals(author, other.author) && currentPage == other.currentPage
				&& Objects.equals(description, other.description) && Objects.equals(googleId, other.googleId)
				&& pageCount == other.pageCount && Objects.equals(thumbnailLink, other.thumbnailLink)
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "ReadBook [googleId=" + googleId + ", thumbnailLink=" + thumbnailLink + ", title=" + title + ", author="
				+ author + ", description=" + description + ", pageCount=" + pageCount + ", currentPage=" + currentPage
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
