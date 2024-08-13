package com.ofss.main.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.LoginRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Customer addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Optional<Login> existingLoginOptional = loginRepository.findById(customer.getLogin().getLoginId());
	    
	    if (existingLoginOptional.isPresent()) {
	        // Customer with the same loginId already exists
	        return null;
	    }

	    // Save the new customer (this will also save the associated Login entity due to cascade)
//	    Login login = customer.getLogin();
	    customer.getLogin().setLoginTime(Timestamp.from(Instant.now()));
	    customer.getLogin().setLoginStatus("New");
	    customer.getLogin().setLoginAttempts(0);
	    loginRepository.save(customer.getLogin());
	    customerRepository.save(customer);
	    return customer;
	}

}
