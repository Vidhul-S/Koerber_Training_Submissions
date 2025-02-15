package com.question2.customer.service;

import com.question2.customer.exceptions.CustomerNotFoundException;
import com.question2.customer.repository.Customer;
import com.question2.customer.repository.CustomerRepo;
import com.question2.customer.repository.impl.CustomerRepoJdbcImpl;

import java.util.List;

public class CustomerServiceImp implements CustomerService {
    private CustomerRepo customerRepo = new CustomerRepoJdbcImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(int id) {
        Customer customer=customerRepo.findById(id);
        if (customer!=null){
            return customer;
        }else
            throw new CustomerNotFoundException(" Cus with id "+ id +" is not found");
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepo.update(id,customer);
    }
}
