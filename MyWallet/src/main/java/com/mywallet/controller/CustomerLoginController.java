package com.mywallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.LoginException;
import com.mywallet.model.Login;
import com.mywallet.service.LoginService;

@RestController
public class CustomerLoginController {

	@Autowired
	private LoginService customerLogin;
	
	
	/*-----------------------------------------------  Login Controller  ------------------------------------------------*/	

	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody Login login) throws LoginException {
		
		return new ResponseEntity<String>(customerLogin.CustomerLogin(login),HttpStatus.OK );	
		
	}
	
	
	/*----------------------------------------------- Logout Controller  ------------------------------------------------*/	

	@PostMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam String key) throws LoginException {

		return new ResponseEntity<String>(customerLogin.CustomerLogout(key),HttpStatus.OK);
		
	}
	

}
