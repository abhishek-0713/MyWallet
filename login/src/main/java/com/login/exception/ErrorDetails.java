package com.login.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	
private LocalDateTime timeStamp;
	
	private String message ;
	
	private String discription;

	
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime timeStamp, String message, String discription) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.discription = discription;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", discription=" + discription + "]";
	}
	
}
