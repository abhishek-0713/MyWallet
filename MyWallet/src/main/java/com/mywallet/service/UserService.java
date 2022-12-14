package com.mywallet.service;

import javax.security.auth.login.LoginException;

import com.mywallet.model.Customer;

public interface UserService {

	public Customer validateLogin(String mobileNumber,String password) throws LoginException;
}
