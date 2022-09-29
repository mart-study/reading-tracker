package com.reading.tracker.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class ReadBook {

	@Id
    @GeneratedValue
	private UUID id;
	private String googleId;
	
	@Column(columnDefinition="TEXT")
	private String imageLink;
	private String title;
	private String authors;
	
	@Column(columnDefinition="TEXT")
	private String description;
	private int pageCount;
	private int currentPage;
	private boolean completeStatus;
	
	@LastModifiedBy
	private String updatedBy;
	
	@LastModifiedDate
	private Date updatedDate;
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private Date createdDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
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

	public boolean isCompleteStatus() {
		return completeStatus;
	}

	public void setCompleteStatus(boolean completeStatus) {
		this.completeStatus = completeStatus;
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
		return Objects.hash(authors, completeStatus, createdBy, createdDate, currentPage, description, googleId, id,
				imageLink, pageCount, title, updatedBy, updatedDate);
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
		return Objects.equals(authors, other.authors) && completeStatus == other.completeStatus
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdDate, other.createdDate)
				&& currentPage == other.currentPage && Objects.equals(description, other.description)
				&& Objects.equals(googleId, other.googleId) && Objects.equals(id, other.id)
				&& Objects.equals(imageLink, other.imageLink) && pageCount == other.pageCount
				&& Objects.equals(title, other.title) && Objects.equals(updatedBy, other.updatedBy)
				&& Objects.equals(updatedDate, other.updatedDate);
	}

	@Override
	public String toString() {
		return "ReadBook [id=" + id + ", googleId=" + googleId + ", imageLink=" + imageLink + ", title=" + title
				+ ", authors=" + authors + ", description=" + description + ", pageCount=" + pageCount
				+ ", currentPage=" + currentPage + ", completeStatus=" + completeStatus + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}

}
