package com.reading.tracker.service;

import java.util.Map;

public interface KeySearchService {

	void addKeySearch(String title, String author);
	Map<String, Integer> getMostSearchedKeyword(); 
}
