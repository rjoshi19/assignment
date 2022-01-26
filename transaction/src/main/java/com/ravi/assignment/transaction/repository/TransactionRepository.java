package com.ravi.assignment.transaction.repository;

import com.ravi.assignment.transaction.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	@Transactional
	void deleteByAccountId(int accountId);

	List<Transaction> findByAccountId(int accountId);
}
