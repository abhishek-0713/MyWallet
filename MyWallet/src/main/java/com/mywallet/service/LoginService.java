package com.mywallet.service;

import com.mywallet.exceptions.LoginException;
import com.mywallet.model.LoginDTO;

public interface LoginService {
	
	   public String CustomerLogin(LoginDTO logdto) throws LoginException;
		
	   public String CustomerLogout(String Key) throws LoginException;
		
}
