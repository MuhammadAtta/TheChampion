package com.tennis_table.league.champion.exceptions;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * Custom Error class
 */
public class ApiError {

	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ApiError(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public ApiError(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public List<String> getErrors() {
		return this.errors;
	}
}