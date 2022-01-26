package com.ravi.assignment.transaction.service.impl;

import com.ravi.assignment.transaction.model.Transaction;
import com.ravi.assignment.transaction.repository.TransactionRepository;
import com.ravi.assignment.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

	private final TransactionRepository transactionRepository;

	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public Transaction save(Transaction account) {
		account.setTransactionDate(new Date());
		return transactionRepository.save(account);
	}

	@Override
	public List<Transaction> findTransactionsByAccountId(int accountId) {
		return transactionRepository.findByAccountId(accountId);
	}

	@Override
	public void deleteAll() {
		transactionRepository.deleteAll();
	}
}
