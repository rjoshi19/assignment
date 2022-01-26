package com.ravi.assignment.account.repository;

import com.ravi.assignment.account.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    Optional<List<Account>> findByCustomerId(int customerId);
}
