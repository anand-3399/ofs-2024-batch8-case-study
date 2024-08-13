package com.ofss.main.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Login;
import com.ofss.main.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public int validateLogin(String loginID, String password) {
		// Retrieve the Login entity using the provided loginID
	    Optional<Login> loginOptional = loginRepository.findById(loginID);
	    
	    if (loginOptional.isPresent()) {
	        Login login = loginOptional.get();

	        // Check if the account is already blocked
	        if ("Blocked".equals(login.getLoginStatus())) {
	            return -2; // Account is blocked
	        }

	        // Check if the provided password matches the stored password
	        if (login.getPassword().equals(password)) {
	            // Password matches, reset the counter and return success
	            login.setLoginAttempts(0);
	            login.setLoginTime(Timestamp.from(Instant.now())); // Set current timestamp
	            loginRepository.save(login);
	            return 1; // Successful login
	        } else {
	            // Password does not match
	            int attempts = login.getLoginAttempts();
	            attempts++;
	            login.setLoginAttempts(attempts);

	            if (attempts >= 3) {
	                // Account should be blocked
	                login.setLoginAttempts(attempts);
	                login.setLoginStatus("Blocked");
	                loginRepository.save(login);
	                return -2; // Account is blocked
	            } else {
	                // Update the login attempts and return failure code
	                loginRepository.save(login);
	                return -1; // Password incorrect
	            }
	        }
	    }

	    // LoginID not found, return a failure code
	    return 0;
	}


	@Override
	public Login getLoginByLoginID(String loginID, String Upassword) {
		// Retrieve the Login entity using the provided loginID
	    Optional<Login> loginOptional = loginRepository.findById(loginID);
	    
	    if (loginOptional.isPresent()) {
	         return loginOptional.get();
	    }
	    
	    // LoginID not found, return a failure code, e.g., 0
	    return null;
	}

}
