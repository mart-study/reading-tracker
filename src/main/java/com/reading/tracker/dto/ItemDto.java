package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.Objects;

public class ItemDto implements Serializable {
	
	private static final long serialVersionUID = -890522263069154811L;
	private String id;
	private String etag;
	private String selfLink;
	private BookDto volumeInfo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEtag() {
		return etag;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public String getSelfLink() {
		return selfLink;
	}
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}
	public BookDto getVolumeInfo() {
		return volumeInfo;
	}
	public void setVolumeInfo(BookDto volumeInfo) {
		this.volumeInfo = volumeInfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(etag, id, selfLink, volumeInfo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDto other = (ItemDto) obj;
		return Objects.equals(etag, other.etag) && Objects.equals(id, other.id)
				&& Objects.equals(selfLink, other.selfLink) && Objects.equals(volumeInfo, other.volumeInfo);
	}
	
	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", etag=" + etag + ", selfLink=" + selfLink + ", volumeInfo=" + volumeInfo + "]";
	}
}
