package com.ravi.assignment.account.initializer;

import com.ravi.assignment.account.exception.NotFoundException;
import com.ravi.assignment.account.model.Account;
import com.ravi.assignment.account.model.Customer;
import com.ravi.assignment.account.service.IAccountService;
import com.ravi.assignment.account.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class DataLoader implements ApplicationRunner {

	private final ICustomerService customerService;
	private final IAccountService accountService;

	@Autowired
	public DataLoader(ICustomerService customerService, IAccountService accountService) {
		this.customerService = customerService;
		this.accountService = accountService;
	}

	/**
	 * Insert some initial dummy data
	 */
	public void run(ApplicationArguments args) throws NotFoundException {
		accountService.deleteAllTransactions();
		Customer customer = customerService.save(new Customer("Ravi", "Joshi"));
		Account account = accountService.createAccount(new Account(customer.getId(), 1000L));
		if (account != null) {
			accountService.addTransaction(account, -400);
		}
	}
}
