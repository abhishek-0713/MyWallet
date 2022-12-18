package com.mywallet.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private LocalDateTime timeStamp;
	
	private String message ;
	
	private String description;
	
	
	
//	public ErrorDetails() {
//		super();
//	}
//
//	public ErrorDetails(LocalDateTime timeStamp, String message, String discription) {
//		super();
//		this.timeStamp = timeStamp;
//		this.message = message;
//		this.description = discription;
//	}
//
//	
//	public LocalDateTime getTimeStamp() {
//		return timeStamp;
//	}
//
//	public void setTimeStamp(LocalDateTime timeStamp) {
//		this.timeStamp = timeStamp;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public String getDiscription() {
//		return description;
//	}
//
//	public void setDiscription(String discription) {
//		this.description = discription;
//	}
//
//	
//	
//	@Override
//	public String toString() {
//		return "MyErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", discription=" + description + "]";
//	}

	
}