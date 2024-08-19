package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.service.CustomerService;
import com.ofss.main.service.LoginService;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("bank")
@CrossOrigin(origins = "*")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("checklogin")
	public ResponseEntity<String> validationOfLogin(@RequestBody Login login) {
		String loginId=login.getLoginId(), password=login.getPassword();
		int validationFlag = loginService.validateLogin(loginId, password);
		
        switch (validationFlag) {
            case 1:
                return ResponseEntity.ok("Login successful");
            case -1:
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password incorrect");
            case -2:
                return ResponseEntity.status(HttpStatus.LOCKED).body("Account is blocked");
            case 0:
            default:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login ID not found");
        }
	}
	
	@PostMapping("addcustomer")
    public ResponseEntity<?> addNewCustomerDetails(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.addNewCustomer(customer);
        if (savedCustomer != null) {
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.status(400).body("Login ID already exists");
        }
    }
	
	@PostMapping("getcustomerdetails")
	public ResponseEntity<?> getCustomerDetails(@RequestBody Login login) {
		Customer customer = customerService.getCustomerByLogin(login);
		
		if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(400).body("Login ID/Password dosnt exists");
        }
	}

	@PutMapping("updatecustomerdetails")
	public ResponseEntity<?> updateCustomerDetails(@RequestBody Customer customer) {
		Customer Updatedcustomer = customerService.updateCustomerDetails(customer);
		
		if (Updatedcustomer != null) {
            return ResponseEntity.ok(Updatedcustomer);
        } else {
            return ResponseEntity.status(400).body("Error Occurred. Please check your details");
        }
	}
	
}
