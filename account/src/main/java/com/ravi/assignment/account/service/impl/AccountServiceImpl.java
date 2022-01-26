package com.ravi.assignment.account.service.impl;

import com.ravi.assignment.account.constant.ErrorMessage;
import com.ravi.assignment.account.exception.NotFoundException;
import com.ravi.assignment.account.model.Account;
import com.ravi.assignment.account.model.Transaction;
import com.ravi.assignment.account.proxy.TransactionServiceProxy;
import com.ravi.assignment.account.repository.AccountRepository;
import com.ravi.assignment.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final TransactionServiceProxy transactionServiceProxy;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, TransactionServiceProxy transactionServiceProxy) {
        this.accountRepository = accountRepository;
        this.transactionServiceProxy = transactionServiceProxy;
    }

    @Override
    public List<Account> findAccountsByCustomerId(int customerId) throws NotFoundException {
        return accountRepository.findByCustomerId(customerId).orElseThrow(() -> new NotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND));
    }

    @Override
    public Account findAccountById(int accountId) throws NotFoundException {
        return accountRepository.findById(accountId).orElseThrow(() -> new NotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND));
    }

    @Override
    public Account createAccount(Account account) {
        account = accountRepository.save(account);

        if (account.getInitialBalance() != 0) {
            Transaction transaction = addTransaction(account, account.getInitialBalance());
            if (transaction == null) {
                accountRepository.deleteById(account.getId());
                return null;
            }

        }

        return account;
    }

    @Override
    public Transaction addTransaction(int accountId, long transactionAmount) throws NotFoundException {
        Account account = findAccountById(accountId);
        if (account == null) {
            throw new NotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND);
        }

        return addTransaction(account, transactionAmount);
    }

    @Override
    public Transaction addTransaction(Account account, long transactionAmount) {
        Transaction transaction = transactionServiceProxy.createTransaction(new Transaction(account.getId(), transactionAmount));
        if (transaction != null) {
            account.addBalance(transaction.getTransactionAmount());
            accountRepository.save(account);
        }

        return transaction;
    }

    @Override
    public void deleteAllTransactions() {
        transactionServiceProxy.deleteAllTransactions();
    }

    @Override
    public List<Transaction> getAccountTransactions(int accountId) throws NotFoundException {
        List<Transaction> accountTransactions = transactionServiceProxy.getAccountTransactions(accountId);

        if (null == accountTransactions || accountTransactions.isEmpty()) {
            throw new NotFoundException(ErrorMessage.TRANSACTIONS_NOT_FOUND);
        }
        return accountTransactions;
    }
}