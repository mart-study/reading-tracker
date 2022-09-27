package com.reading.tracker.dto;

import java.util.Objects;

public class PageRequestDto {

	private int pageNo; 
	private int pageSize;
	private String sortBy;
	private String sortDir;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pageNo, pageSize, sortBy, sortDir);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageRequestDto other = (PageRequestDto) obj;
		return pageNo == other.pageNo && pageSize == other.pageSize && Objects.equals(sortBy, other.sortBy)
				&& Objects.equals(sortDir, other.sortDir);
	}
	
	@Override
	public String toString() {
		return "PageRequestDto [pageNo=" + pageNo + ", pageSize=" + pageSize + ", sortBy=" + sortBy + ", sortDir="
				+ sortDir + "]";
	}
}
