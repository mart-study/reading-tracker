package com.reading.tracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.reading.tracker.dto.BookDetailDto;
import com.reading.tracker.dto.BookProgressDto;
import com.reading.tracker.dto.IndustryIdentifierDto;
import com.reading.tracker.dto.PageRequestDto;
import com.reading.tracker.model.ReadingBook;
import com.reading.tracker.repository.ReadingBookRepository;
import com.reading.tracker.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private ReadingBookRepository readingBookRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<BookProgressDto> getReadingList(PageRequestDto pageRequest) {
		Sort sort = Sort.by(Sort.Direction.fromString(pageRequest.getSortDir()), pageRequest.getSortBy());
		Pageable pageable = PageRequest.of(pageRequest.getPageNo(), pageRequest.getPageSize(), sort);
	    
	    Page<ReadingBook> pageResult = readingBookRepository.findAll(pageable);
	    
	    List<BookProgressDto> result = new ArrayList<BookProgressDto>();
	    pageResult.getContent().stream().forEach(book -> {
	    	BookProgressDto bookProgress = modelMapper.map(book, BookProgressDto.class);
	    	result.add(bookProgress);
	    });
		
		return result;
	}

	@Override
	public boolean addBookToReadingList(BookDetailDto bookDetailDto) {
		ReadingBook readingBook = modelMapper.map(bookDetailDto, ReadingBook.class);
		readingBookRepository.save(readingBook);
		return true;
	}

	@Override
	public boolean removeBookFromReadingList(String bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String appendAuthorsName(List<String> authors) {
		StringBuilder AUTHORS = new StringBuilder("");
		if (authors != null) {
			authors.stream().forEach(author -> {
				AUTHORS.append(author).append(", ");
			});
		}
		
		String result = AUTHORS.toString().trim();
		if (!result.isBlank() && result.charAt(result.length() - 1) == ',') {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	@Override
	public String appendISBN(List<IndustryIdentifierDto> industryIdentifiers) {
		StringBuilder ISBN = new StringBuilder("");
		if (industryIdentifiers != null) {
			industryIdentifiers.stream().forEach(isbn -> {
				ISBN.append(isbn.getType()).append(": ").append(isbn.getIdentifier()).append(", ");
			});
		}
		
		String isbn = ISBN.toString().trim();
		if (!isbn.isBlank() && isbn.charAt(isbn.length() - 1) == ',') {
			isbn = isbn.substring(0, isbn.length() - 1);
		}
		return isbn;
	}

}
