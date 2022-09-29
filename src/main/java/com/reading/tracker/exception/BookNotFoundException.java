package com.reading.tracker.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4372830947928730619L;

	public BookNotFoundException(String message) {
		super(message);
	}
}
