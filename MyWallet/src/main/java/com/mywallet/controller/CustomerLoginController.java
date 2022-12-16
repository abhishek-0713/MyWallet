package com.mywallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.LoginException;
import com.mywallet.model.LoginDTO;
import com.mywallet.service.LoginService;

@RestController
public class CustomerLoginController {

	@Autowired
	private LoginService customerLogin;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO loginDTO) throws LoginException {
		
		String result = customerLogin.CustomerLogin(loginDTO);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );	
		
	}
	
	@PostMapping("/logout/{key}")
	public ResponseEntity<String> logoutCustomer(@PathVariable("key") String key) throws LoginException {
		
		String output = customerLogin.CustomerLogout(key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
		
	}
	

}
