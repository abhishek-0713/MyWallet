package com.mywallet.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.LoginException;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Customer;
import com.mywallet.model.Login;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;

import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	@Autowired
	private CustomerRepo customerRepo;

	
	/*-------------------------------------------   Login   --------------------------------------------------*/
	@Override
	public String CustomerLogin(Login logdto) throws LoginException {

		List<Customer> customer= customerRepo.findCustomerByMobile(logdto.getMobileNumber());
		
		Customer existingCustomer = customer.get(0);
		
		if(existingCustomer == null) {
			throw new LoginException("Invalid MobileNumber!");
		}
		
		Optional<CurrentUserSession> validCustomerSessionOpt =  currentSessionRepo.findByUserId(existingCustomer.getCustomerId());
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User Already Exists in the System.");
			
		}
		
		if(existingCustomer.getPassword().equals(logdto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			currentSessionRepo.save(currentUserSession);

			return currentUserSession.toString();
		}

		throw new LoginException("Wrong password");
		
	}

	
	/*-------------------------------------   Logout   ----------------------------------------*/
	@Override
	public String CustomerLogout(String Key) throws LoginException {

		CurrentUserSession validCustomerSession = currentSessionRepo.findByUuid(Key);
		
		if(validCustomerSession == null) {
			throw new LoginException("Invalid Unique userId (Session Key).");
			
		}
		
		currentSessionRepo.delete(validCustomerSession);
		
		return "Logged Out Successfully!";
	}

	

}
