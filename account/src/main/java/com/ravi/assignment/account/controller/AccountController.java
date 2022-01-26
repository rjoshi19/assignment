package com.ravi.assignment.account.controller;

import com.ravi.assignment.account.constant.ErrorMessage;
import com.ravi.assignment.account.exception.NotFoundException;
import com.ravi.assignment.account.exception.ServiceDownException;
import com.ravi.assignment.account.model.Account;
import com.ravi.assignment.account.model.Customer;
import com.ravi.assignment.account.model.Transaction;
import com.ravi.assignment.account.service.IAccountService;
import com.ravi.assignment.account.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

	private final IAccountService accountService;
	private final ICustomerService customerService;

	@Autowired
	public AccountController(IAccountService accountService, ICustomerService customerService) {
		this.accountService = accountService;
		this.customerService = customerService;
	}

	/**
	 * Returns transaction history of the account
	 * 
	 * @param accountId
	 *            id of the account
	 * @return transaction history of the account
	 */
	@GetMapping("/{accountId}/transactions")
	public List<Transaction> getAccountTransactions(@PathVariable int accountId) throws NotFoundException {
		return accountService.getAccountTransactions(accountId);
	}

	/**
	 * Inserts a new input to the account
	 *
	 * @param input
	 *            transaction input object: contains accountId and transaction amount
	 * @return inserted input object
	 */
	@PostMapping("/transactions")
	public Transaction addNewTransaction(@RequestBody Transaction input) throws NotFoundException, ServiceDownException {
		Transaction transaction = accountService.addTransaction(input.getAccountId(), input.getTransactionAmount());
		if (transaction == null) {
			throw new ServiceDownException(ErrorMessage.SERVICE_NOT_AVAILABLE);
		}
		return transaction;
	}

	/**
	 * Creates a new input for the customer
	 *
	 * @param input
	 *            account object: contains customerId and initialBalance
	 * @return created input object
	 * @throws NotFoundException
	 *             if the given customer does not exist
	 */
	@PostMapping
	public Account createAccount(@RequestBody Account input) throws NotFoundException, ServiceDownException {
		Customer customer = customerService.findCustomerById(input.getCustomerId());
		if (customer == null) {
			throw new NotFoundException(ErrorMessage.CUSTOMER_NOT_FOUND);
		}

		Account account = accountService.createAccount(input);
		if (account == null) {
			throw new ServiceDownException(ErrorMessage.SERVICE_NOT_AVAILABLE);
		}
		return account;
	}
}