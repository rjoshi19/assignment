package com.ravi.assignment.transaction.controller;

import com.ravi.assignment.transaction.model.Transaction;
import com.ravi.assignment.transaction.service.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoint for inserting new transaction
 */
@RestController
@RequestMapping("/api")
public class TransactionController {
	private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

	private final ITransactionService transactionServiceImpl;

	@Autowired
	public TransactionController(ITransactionService transactionServiceImpl) {
		this.transactionServiceImpl = transactionServiceImpl;
	}

	/**
	 * Returns transactions for the given customer account
	 * 
	 * @param accountId
	 *            id of the customer account
	 * @return transactions for the given account
	 */
	@GetMapping("/account/{accountId}/transactions")
	public List<Transaction> getAccountTransactions(@PathVariable int accountId) {
		log.info("Request received for geting transactions for account: " + accountId);
		return transactionServiceImpl.findTransactionsByAccountId(accountId);
	}

	/**
	 * Inserts a new transaction. Does not validate if account exists
	 * 
	 * @param transaction
	 *            model object
	 * @return saved transaction model object
	 */
	@PostMapping("/transactions")
	private Transaction createTransaction(@RequestBody Transaction transaction) {
		log.info("Request received for creating transaction");
		return transactionServiceImpl.save(transaction);
	}

	/**
	 * Removes all transaction history for all accounts
	 */
	@DeleteMapping("/transactions")
	private void createTransaction() {
		log.info("Request received for deleting transactions");
		transactionServiceImpl.deleteAll();
	}
}
