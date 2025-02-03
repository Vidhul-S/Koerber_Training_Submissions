package com.question2.customer.service;

import com.question2.customer.repository.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    public Customer save(Customer customer);
    public void deleteById(int id);
    public void update(int id, Customer customer);
}
