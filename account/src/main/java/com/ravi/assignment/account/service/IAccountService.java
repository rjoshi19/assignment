package com.ravi.assignment.account.service;

import com.ravi.assignment.account.exception.NotFoundException;
import com.ravi.assignment.account.model.Account;
import com.ravi.assignment.account.model.Transaction;

import java.util.List;

public interface IAccountService {
    List<Account> findAccountsByCustomerId(int customerId) throws NotFoundException;

    Account findAccountById(int accountId) throws NotFoundException;

    Account createAccount(Account account);

    Transaction addTransaction(int accountId, long transactionAmount) throws NotFoundException;

    Transaction addTransaction(Account account, long transactionAmount);

    void deleteAllTransactions();

    List<Transaction> getAccountTransactions(int accountId) throws NotFoundException;
}
