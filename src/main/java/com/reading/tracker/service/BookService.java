package com.reading.tracker.service;

import java.util.List;

import com.reading.tracker.dto.BookDetailDto;
import com.reading.tracker.dto.BookProgressDto;
import com.reading.tracker.dto.IndustryIdentifierDto;
import com.reading.tracker.dto.PageRequestDto;

public interface BookService {

	List<BookProgressDto> getReadingList(PageRequestDto pageRequest);
	boolean addBookToReadingList(BookDetailDto bookDetailDto);
	boolean removeBookFromReadingList(String bookId);
	String appendAuthorsName(List<String> authors);
	String appendISBN(List<IndustryIdentifierDto> industryIdentifiers);
}
