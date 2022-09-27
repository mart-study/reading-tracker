package com.reading.tracker.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.reading.tracker.model.KeySearch;
import com.reading.tracker.repository.KeySearchRepository;
import com.reading.tracker.service.KeySearchService;

@Service
public class KeySearchServiceImpl implements KeySearchService {

	@Autowired
	private KeySearchRepository keySearchRepository;

	@Override
	public void addKeySearch(String title, String author) {
		KeySearch keySearchTitle = new KeySearch();
		Optional<KeySearch> existingKeySearchTitle = keySearchRepository.findById(title.toLowerCase().trim());
		
		int count = 0;
		if (existingKeySearchTitle.isPresent()) {
			keySearchTitle = existingKeySearchTitle.get();
			count = keySearchTitle.getCount();
			keySearchTitle.setCount(++count);
		} else {
			keySearchTitle.setKeyword(title);
			keySearchTitle.setCount(count);
		}
		keySearchRepository.save(keySearchTitle);
		
		KeySearch keySearchAuthor = new KeySearch();
		Optional<KeySearch> keySearchAuthorOpt = keySearchRepository.findById(author.toLowerCase().trim());
		
		if (keySearchAuthorOpt.isPresent()) {
			keySearchAuthor = keySearchAuthorOpt.get();
			count = keySearchAuthor.getCount();
			keySearchAuthor.setCount(++count);
		} else {
			keySearchAuthor.setCount(count);
			keySearchAuthor.setKeyword(author);
		}
		keySearchRepository.save(keySearchAuthor);
	}

	@Override
	public Map<String, Integer> getMostSearchedKeyword() {
		Sort sort = Sort.by(Sort.Direction.DESC, "count");
		Pageable pageable = PageRequest.of(0, 20, sort);
	    
	    Page<KeySearch> pageResult = keySearchRepository.findAll(pageable);
	    
	    Map<String, Integer> result = new HashMap<String, Integer>();
	    pageResult.getContent().stream().forEach(keySearch -> {
	    	result.put(keySearch.getKeyword(), keySearch.getCount());
	    });
		return result;
	}
}
