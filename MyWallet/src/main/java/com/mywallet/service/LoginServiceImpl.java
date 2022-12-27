package com.mywallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.LoginException;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Customer;
import com.mywallet.model.UserLogin;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	
	/*-------------------------------------------   Login   --------------------------------------------------*/

	@Override
	public String login(UserLogin userLogin) throws LoginException {
		
        List<Customer> customer= customerRepo.findCustomerByMobile(userLogin.getMobileNumber());
		
		Customer existingCustomer = customer.get(0);
		
		if(existingCustomer == null) {
			throw new LoginException("Invalid MobileNumber!");
		}
		
		
		
		Optional<CurrentUserSession> optional =  currentSessionRepo.findByUserId(existingCustomer.getCustomerId());
		
		if(optional.isPresent()) {
			
			throw new LoginException("User Already Exists in the System.");
			
		}
		
		if(existingCustomer.getPassword().equals(userLogin.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			currentSessionRepo.save(currentUserSession);

			return currentUserSession.toString();
		}

		throw new LoginException("Wrong password");
		
	}

	
	/*-------------------------------------   Logout   ----------------------------------------*/

	@Override
	public String logout(String key) throws LoginException {
		
        CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		
		if(currentUserSession == null) {
			throw new LoginException("Invalid Unique userId (Session Key).");
			
		}
		
		currentSessionRepo.delete(currentUserSession);
		
		return "Logged Out Successfully!";
	}

}
