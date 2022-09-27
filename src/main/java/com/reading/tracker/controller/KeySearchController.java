package com.reading.tracker.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reading.tracker.service.KeySearchService;

@RestController
@RequestMapping("/key-search")
public class KeySearchController {
	
	@Autowired
	private KeySearchService keySearchService;
	
	@GetMapping
	public ResponseEntity<?> getMostSearchedKeyword() {
		Map<String, Integer> result = keySearchService.getMostSearchedKeyword();
		return new ResponseEntity<>(result, HttpStatus.OK); 
	}
	
}
