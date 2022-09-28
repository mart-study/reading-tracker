package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SearchBookResponseDto implements Serializable {
	
	private static final long serialVersionUID = 1022195251222660224L;

	private List<?> content;
	private int startIndex;
	private int maxResults;
	private int totalItems;
	
	public SearchBookResponseDto() {
		
	}
	
	public SearchBookResponseDto(List<?> content, int startIndex, int maxResults, int totalItems) {
		this.content = content;
		this.startIndex = startIndex;
		this.maxResults = maxResults;
		this.totalItems = totalItems;
	}

	public List<?> getContent() {
		return content;
	}
	public void setContent(List<?> content) {
		this.content = content;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(content, maxResults, startIndex, totalItems);
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
		return Objects.equals(content, other.content) && maxResults == other.maxResults
				&& startIndex == other.startIndex && totalItems == other.totalItems;
	}
	
	@Override
	public String toString() {
		return "SearchBookResponseDto [content=" + content + ", startIndex=" + startIndex + ", maxResults=" + maxResults
				+ ", totalItems=" + totalItems + "]";
	}
}
