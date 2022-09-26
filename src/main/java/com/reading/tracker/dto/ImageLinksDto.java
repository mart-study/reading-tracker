package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.Objects;

public class ImageLinksDto implements Serializable { 
	
	private static final long serialVersionUID = -214467084915756764L;
	private String smallThumbnail;
	private String thumbnail;
	private String small;
	private String medium;
	private String large;
	private String extraLarge;
	
	public String getSmallThumbnail() {
		return smallThumbnail;
	}
	public void setSmallThumbnail(String smallThumbnail) {
		this.smallThumbnail = smallThumbnail;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getSmall() {
		return small;
	}
	public void setSmall(String small) {
		this.small = small;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getLarge() {
		return large;
	}
	public void setLarge(String large) {
		this.large = large;
	}
	public String getExtraLarge() {
		return extraLarge;
	}
	public void setExtraLarge(String extraLarge) {
		this.extraLarge = extraLarge;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(extraLarge, large, medium, small, smallThumbnail, thumbnail);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageLinksDto other = (ImageLinksDto) obj;
		return Objects.equals(extraLarge, other.extraLarge) && Objects.equals(large, other.large)
				&& Objects.equals(medium, other.medium) && Objects.equals(small, other.small)
				&& Objects.equals(smallThumbnail, other.smallThumbnail) && Objects.equals(thumbnail, other.thumbnail);
	}
	
	@Override
	public String toString() {
		return "ImageLinksDto [smallThumbnail=" + smallThumbnail + ", thumbnail=" + thumbnail + ", small=" + small
				+ ", medium=" + medium + ", large=" + large + ", extraLarge=" + extraLarge + "]";
	}
}
