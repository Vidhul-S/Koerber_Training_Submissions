package com.question2.customer.web;

import com.question2.customer.repository.Customer;
import com.question2.customer.service.CustomerService;
import com.question2.customer.service.CustomerServiceImp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------all records---------");
        CustomerService customerService = new CustomerServiceImp();
        List<Customer> employees = customerService.findAll();
        employees.forEach(System.out::println);

        System.out.println("-------------find by id---------");
        Customer customer = customerService.findById(6);

        customer.setPhoneNumber(9838383386L);
        System.out.println("-------------update by id---------");
        customerService.update(6, customer);
    }
}
