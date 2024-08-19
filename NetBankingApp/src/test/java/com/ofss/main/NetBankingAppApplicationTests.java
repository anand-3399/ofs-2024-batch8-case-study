package com.ofss.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.service.AccountService;
import com.ofss.main.service.CustomerService;

@SpringBootTest
class NetBankingAppApplicationTests {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountService accountService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void checkByLoginId()
	{
		Login login = new Login("anand", "anand", 0, null, null);
		Customer customer= customerService.getCustomerByLogin(login);
		System.out.println(customer);
		System.out.println();
		Account account = accountService.getAccountByCustomer(login);
		System.out.println(account);
	}
	
	@Test
	void newChck()
	{
		Login login = new Login("yash", "yash", 0, null, null);
		Customer customer = customerService.getCustomerByLogin(login);
		System.out.println(customer);
		customer.setAddress("Malad");
		System.out.println(customerService.updateCustomerDetails(customer));
	}

}
