package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {
	
	private LocalDate timestamp;
	private String message;
	private String details;
	/**
	 * @return the timestamp
	 */
	public LocalDate getTimestamp() {
		return timestamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	public ErrorDetails(LocalDate timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	
}
