package com.question2.customer.repository;

import java.util.List;

public interface CustomerRepo {
    List<Customer> findAll();
    Customer findById(int id);
    public Customer save(Customer customer);
    public void deleteById(int id);
    public void update(int id, Customer customer);
}
