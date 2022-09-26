package com.reading.tracker.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reading.tracker.properties.GoogleBookProperties;
import com.reading.tracker.client.GoogleBooksPlaceHolderClient;
import com.reading.tracker.dto.SearchBookResponseDto;
import com.reading.tracker.dto.SearchBookResultDto;

@RestController
public class BookController {

	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private GoogleBookProperties properties;
	
	@Autowired
	private GoogleBooksPlaceHolderClient googleBooksPlaceHolderClient;
	
	/**
	 * Search book by title and/or author name
	 * @param title
	 * @param author
	 * @return
	 */
	@GetMapping("/search")
	public ResponseEntity<List<SearchBookResponseDto>> searchBook(@RequestParam(value = "title", required=true) String title, 
			@RequestParam(value = "author", required=false) String author) {
		
		ResponseEntity<SearchBookResultDto> response = 
				googleBooksPlaceHolderClient.searchBookByTitleAndAuthor(title.concat("+inauthor:").concat(author),
						5, "newest", properties.getApiKey());
		
		List<SearchBookResponseDto> result = new ArrayList<>();
		response.getBody().getItems().stream().forEach(item -> {
			SearchBookResponseDto dto = new SearchBookResponseDto();
			dto.setId(item.getId());
			dto.setTitle(item.getVolumeInfo().getTitle());
			dto.setAuthors(item.getVolumeInfo().getAuthors());
			StringBuilder ISBN = new StringBuilder("");
			if (item.getVolumeInfo().getIndustryIdentifiers() != null) {
				item.getVolumeInfo().getIndustryIdentifiers().stream().forEach(isbn -> {
					ISBN.append(isbn.getType()).append(": ").append(isbn.getIdentifier()).append(", ");
				});
			}
			
			String isbn = ISBN.toString().trim();
			if (!isbn.isBlank() && isbn.charAt(isbn.length() - 1) == ',') {
				isbn = isbn.substring(0, isbn.length() - 2);
			}
			dto.setISBN(isbn);
			
			String thumbnailLink = item.getVolumeInfo().getImageLinks().getThumbnail().replace("http", "https");
			dto.setImageLink(thumbnailLink);
			result.add(dto);
		});
		logger.info("Search books with title: " + title + " and author: " + author);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * Get book details using id from search result
	 * @param id
	 * @return
	 */
//	@GetMapping("/{id}")
//	public ResponseEntity<BookDto> getBook(@PathVariable String id) {
//		ResponseEntity<ItemDto> response = googleBooksPlaceHolderClient.getBookById(id);
//		logger.info("Get book by id from google apis: " + id);
//		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
//	}
}
