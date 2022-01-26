package com.ravi.assignment.account.controller;

import com.ravi.assignment.account.exception.NotFoundException;
import com.ravi.assignment.account.model.Account;
import com.ravi.assignment.account.model.Customer;
import com.ravi.assignment.account.service.IAccountService;
import com.ravi.assignment.account.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final IAccountService accountServiceImpl;
	private final ICustomerService customerService;

	@Autowired
	public CustomerController(IAccountService accountServiceImpl, ICustomerService customerService) {
		this.accountServiceImpl = accountServiceImpl;
		this.customerService = customerService;
	}

	/**
	 * Lists all existing customers
	 * 
	 * @return all existing customers
	 */
	@GetMapping
	private List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	/**
	 * Returns a specific customer
	 * 
	 * @param id
	 *            of the customer
	 * @return requested customer
	 */
	@GetMapping("/{id}")
	private Customer getCustomer(@PathVariable int id) throws NotFoundException {
		return customerService.findCustomerById(id);
	}

	/**
	 * Displays accounts of given customer
	 * 
	 * @param id
	 *            of the customer
	 * @return accounts of given customer
	 */
	@GetMapping("/{id}/accounts")
	private List<Account> getAccounts(@PathVariable int id) throws NotFoundException {
		return accountServiceImpl.findAccountsByCustomerId(id);
	}

	/**
	 * Creates a new customer
	 * 
	 * @param customer
	 *            model object
	 * @return customer object after creation
	 */
	@PostMapping
	private Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
}
