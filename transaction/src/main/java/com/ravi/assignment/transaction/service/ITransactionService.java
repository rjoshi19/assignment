package com.ravi.assignment.transaction.service;

import com.ravi.assignment.transaction.model.Transaction;

import java.util.List;

public interface ITransactionService {
    Transaction save(Transaction account);

    List<Transaction> findTransactionsByAccountId(int accountId);

    void deleteAll();
}
