package com.ofss.main.service;

import com.ofss.main.domain.Login;

public interface LoginService {
	// Stored procedure checking  
	Login getLoginByLoginID(String loginID, String password);
	
	int validateLogin(String loginID, String Upassword);

}
