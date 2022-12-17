package com.mywallet.service;

import com.mywallet.exceptions.LoginException;
import com.mywallet.model.Login;

public interface LoginService {
	
	   public String CustomerLogin(Login logdto) throws LoginException;
		
	   public String CustomerLogout(String Key) throws LoginException;
		
}
