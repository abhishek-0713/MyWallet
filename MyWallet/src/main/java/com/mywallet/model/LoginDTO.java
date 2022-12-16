package com.mywallet.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {


	private String mobileNumber;

	private String password;

	
}
