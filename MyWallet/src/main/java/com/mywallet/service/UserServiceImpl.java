package com.mywallet.service;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.mywallet.model.Customer;

@Service
public class UserServiceImpl implements UserService{

	
	/*---------------------------------   Login   -------------------------------------*/
	@Override
	public Customer validateLogin(String mobileNumber, String password) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*---------------------------------   Logout   -------------------------------------*/

}
