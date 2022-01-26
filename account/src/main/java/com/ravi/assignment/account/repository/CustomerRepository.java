package com.ravi.assignment.account.repository;

import com.ravi.assignment.account.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
