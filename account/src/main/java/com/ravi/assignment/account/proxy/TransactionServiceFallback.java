package com.ravi.assignment.account.proxy;

import com.ravi.assignment.account.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionServiceFallback implements TransactionServiceProxy {
	@Override
	public List<Transaction> getAccountTransactions(int accountId) {
		return new ArrayList<>();
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return null;
	}

	@Override
	public void deleteAllTransactions() {
	}
}
