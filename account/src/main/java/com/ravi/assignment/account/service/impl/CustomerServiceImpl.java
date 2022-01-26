package com.ravi.assignment.account.service.impl;

import com.ravi.assignment.account.constant.ErrorMessage;
import com.ravi.assignment.account.exception.NotFoundException;
import com.ravi.assignment.account.model.Customer;
import com.ravi.assignment.account.repository.CustomerRepository;
import com.ravi.assignment.account.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer findCustomerById(int id) throws NotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessage.CUSTOMER_NOT_FOUND));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}