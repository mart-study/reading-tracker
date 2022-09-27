package com.reading.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reading.tracker.properties.GoogleBookProperties;
import com.reading.tracker.service.BookService;
import com.reading.tracker.service.KeySearchService;
import com.reading.tracker.client.GoogleBooksPlaceHolderClient;
import com.reading.tracker.dto.BookDetailDto;
import com.reading.tracker.dto.BookProgressDto;
import com.reading.tracker.dto.ItemDto;
import com.reading.tracker.dto.PageRequestDto;
import com.reading.tracker.dto.SearchBookResponseDto;
import com.reading.tracker.dto.SearchBookResultDto;

@RestController
public class BookController {

	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private GoogleBookProperties properties;
	
	@Autowired
	private GoogleBooksPlaceHolderClient googleBooksPlaceHolderClient;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private KeySearchService keySearchService;
	
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
		keySearchService.addKeySearch(title, author);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * Get book details using id from search result
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BookDetailDto> getBook(@PathVariable String id) {
		ResponseEntity<ItemDto> response = googleBooksPlaceHolderClient.getBookById(id);
	
		BookDetailDto book = new BookDetailDto();
		if (response.getBody().getVolumeInfo() != null) {
			book = modelMapper.map(response.getBody().getVolumeInfo(), BookDetailDto.class);
			StringBuilder AUTHORS = new StringBuilder("");
			if (response.getBody().getVolumeInfo().getAuthors() != null) {
				response.getBody().getVolumeInfo().getAuthors().stream().forEach(author -> {
					AUTHORS.append(author).append(", ");
				});
			}
			
			String authors = AUTHORS.toString().trim();
			if (!authors.isBlank() && authors.charAt(authors.length() - 1) == ',') {
				authors = authors.substring(0, authors.length() - 1);
			}
			book.setAuthors(authors);
			
			StringBuilder ISBN = new StringBuilder("");
			if (response.getBody().getVolumeInfo().getIndustryIdentifiers() != null) {
				response.getBody().getVolumeInfo().getIndustryIdentifiers().stream().forEach(isbn -> {
					ISBN.append(isbn.getType()).append(": ").append(isbn.getIdentifier()).append(", ");
				});
			}
			
			String isbn = ISBN.toString().trim();
			if (!isbn.isBlank() && isbn.charAt(isbn.length() - 1) == ',') {
				isbn = isbn.substring(0, isbn.length() - 1);
			}
			book.setISBN(isbn);
			
			String imageLink = response.getBody().getVolumeInfo().getImageLinks().getSmall().replace("http", "https");
			book.setImageLink(imageLink);
		}
		logger.info("Get book by id from google apis: " + id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	/**
	 * Get reading list using pagination
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @param sortDir
	 * @return
	 */
	@GetMapping("/reading-list")
	public ResponseEntity<List<BookProgressDto>> getReadingList(@RequestParam(value = "pageNo", required=false) int pageNo,
			@RequestParam(value = "pageSize", required=false) int pageSize,
			@RequestParam(value = "sortBy", required=false) String sortBy,
			@RequestParam(value = "sortDir", required=false) String sortDir) {
		
		PageRequestDto pageRequest = new PageRequestDto(pageNo, pageSize, sortBy, sortDir);
		List<BookProgressDto> result = bookService.getReadingList(pageRequest);
		logger.info("Get reading list");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * Add book to reading list
	 * @param bookDetailDto
	 * @return
	 */
	@PostMapping("/reading-list")
	public ResponseEntity<Boolean> addToReadingList(@RequestBody BookDetailDto bookDetailDto) {
		boolean result = bookService.addBookToReadingList(bookDetailDto);
		logger.info("Add book to reading list: " + bookDetailDto.getGoogleId());
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	/**
	 * Remove book from reading list
	 * @param bookId
	 * @return
	 */
	@PutMapping("/reading-list/{bookId}")
	public ResponseEntity<Boolean> removeFromReadingList(@PathVariable String bookId) {
		boolean result = bookService.removeBookFromReadingList(bookId);
		logger.info("Remove book to reading list: " + bookId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}