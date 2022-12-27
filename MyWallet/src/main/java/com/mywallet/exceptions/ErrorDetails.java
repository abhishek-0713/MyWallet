package com.mywallet.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDetails {

	private LocalDateTime timeStamp;
		
	private String message ;
		
	private String description;

	
}
