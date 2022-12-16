package com.login.model;

import lombok.Data;

@Data
public class LogInDTO {

	private String mobileNumber;
	private String password;
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LogInDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogInDTO(String mobileNumber, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LogInDTO [mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}
	
}
