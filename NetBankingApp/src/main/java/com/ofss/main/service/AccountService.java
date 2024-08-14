package com.ofss.main.service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Login;

public interface AccountService {
	Account getAccountByCustomer(Login login);
}
