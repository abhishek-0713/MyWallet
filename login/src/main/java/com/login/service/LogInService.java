package com.login.service;

import com.login.exception.LogInException;
import com.login.model.LogInDTO;

public interface LogInService {

    public String logInService (LogInDTO logdto) throws LogInException;
	
	public String logOutService (String Key) throws LogInException;
}
