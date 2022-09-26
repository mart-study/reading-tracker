package com.reading.tracker.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class SearchBookResultDto implements Serializable {
	
	private static final long serialVersionUID = -8395144110086804317L;
	private String kind;
	private String totalItems;
	private List<ItemDto> items;
	
	public List<ItemDto> getItems() {
		return items;
	}
	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(String totalItems) {
		this.totalItems = totalItems;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(items, kind, totalItems);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchBookResultDto other = (SearchBookResultDto) obj;
		return Objects.equals(items, other.items) && Objects.equals(kind, other.kind)
				&& Objects.equals(totalItems, other.totalItems);
	}
	
	@Override
	public String toString() {
		return "SearchBookResultDto [kind=" + kind + ", totalItems=" + totalItems + ", items=" + items + "]";
	}
}
