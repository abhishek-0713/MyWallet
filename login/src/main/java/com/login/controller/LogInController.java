package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.exception.LogInException;
import com.login.model.LogInDTO;
import com.login.service.LogInService;

@RestController
public class LogInController {

	@Autowired
	private LogInService logService;
	
	@PostMapping("/logIn")
	public ResponseEntity<String> logInService(@RequestBody LogInDTO logdto) throws LogInException{
		
		String output = logService.logInService(logdto);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
	
	@PostMapping("/logOut/{key}")
	public ResponseEntity<String> logOutService(@PathVariable("key") String key) throws LogInException{
		
		String output = logService.logOutService(key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
}
