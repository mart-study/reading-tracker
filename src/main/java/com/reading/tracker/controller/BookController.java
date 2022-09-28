package com.reading.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.reading.tracker.dto.GoogleBookResultDto;
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
	public ResponseEntity<SearchBookResponseDto> searchBook(@RequestParam(value = "title", required=true) String title, 
			@RequestParam(value = "author", required=false) String author, 
			@RequestParam(value = "startIndex", defaultValue = "0", required=false) int startIndex, 
			@RequestParam(value = "maxResults", defaultValue = "5", required=false) int maxResults) {
		
		ResponseEntity<SearchBookResultDto> response = 
				googleBooksPlaceHolderClient.searchBookByTitleAndAuthor(title.concat("+inauthor:").concat(author), 0,
						5, "relevance", properties.getApiKey());
		
		List<GoogleBookResultDto> result = new ArrayList<>();
		response.getBody().getItems().stream().forEach(item -> {
			GoogleBookResultDto dto = new GoogleBookResultDto();
			dto.setBookId(item.getId());
			dto.setTitle(item.getVolumeInfo().getTitle());
			
			String authors = bookService.appendAuthorsName(item.getVolumeInfo().getAuthors());
			dto.setAuthors(authors);
			
			String isbn = bookService.appendISBN(item.getVolumeInfo().getIndustryIdentifiers());
			dto.setISBN(isbn);
			
			String thumbnailLink = item.getVolumeInfo().getImageLinks().getThumbnail().replace("http", "https");
			dto.setImageLink(thumbnailLink);
			result.add(dto);
		});
		keySearchService.addKeySearch(title, author);
		
		SearchBookResponseDto searchResponse = new SearchBookResponseDto(result, 
				startIndex, maxResults, response.getBody().getTotalItems());
		logger.info("Search books with title: " + title + " and author: " + author);
		
		return new ResponseEntity<>(searchResponse, HttpStatus.OK);
	}
	
	/**
	 * Get book detail using id from search result
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BookDetailDto> getBook(@PathVariable String id) {
		ResponseEntity<ItemDto> response = googleBooksPlaceHolderClient.getBookById(id);
	
		BookDetailDto book = new BookDetailDto();
		if (response.getBody().getVolumeInfo() != null) {
			book = modelMapper.map(response.getBody().getVolumeInfo(), BookDetailDto.class);
			book.setGoogleId(response.getBody().getId());
			String authors = bookService.appendAuthorsName(response.getBody().getVolumeInfo().getAuthors());
			book.setAuthors(authors);
			
			String isbn = bookService.appendISBN(response.getBody().getVolumeInfo().getIndustryIdentifiers());
			book.setISBN(isbn);
			
			String previewLink = response.getBody().getVolumeInfo().getPreviewLink().replace("http", "https");
			book.setPreviewLink(previewLink);
			
			String imageLink = response.getBody().getVolumeInfo().getImageLinks().getSmall().replace("http", "https");
			book.setImageLink(imageLink);
		}
		logger.info("Get book detail by id from google apis: " + id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	/**
	 * Get reading list
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @param sortDir
	 * @return
	 */
	@GetMapping("/reading-list")
	public ResponseEntity<List<BookProgressDto>> getReadingList(@RequestParam(value = "pageNo", defaultValue = "0", required=false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5", required=false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "updatedDate", required=false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "DESC", required=false) String sortDir) {
		
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
	@DeleteMapping("/reading-list/{bookId}")
	public ResponseEntity<Boolean> removeFromReadingList(@PathVariable String bookId) {
		boolean result = bookService.removeBookFromReadingList(bookId);
		logger.info("Remove book from reading list: " + bookId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
