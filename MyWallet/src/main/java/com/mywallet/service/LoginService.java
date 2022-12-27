package com.mywallet.service;

import com.mywallet.exceptions.LoginException;
import com.mywallet.model.UserLogin;

public interface LoginService {

    public String login (UserLogin userLogin) throws LoginException;
	
	public String logout (String Key) throws LoginException;
}
