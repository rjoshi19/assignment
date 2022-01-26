package com.ravi.assignment.account.service;

import com.ravi.assignment.account.exception.NotFoundException;
import com.ravi.assignment.account.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();

    Customer findCustomerById(int id) throws NotFoundException;

    Customer save(Customer customer);
}
