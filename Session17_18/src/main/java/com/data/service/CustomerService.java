package com.data.service;

import com.data.entity.Customer;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    Customer login(String username, String password);
    List<Customer> getAllCustomers();
    List<Customer> searchCustomerByName(String username);
    boolean lockCustomer(Customer customer);
    boolean unlockCustomer(Customer customer);
    Customer getCustomerById(int id);
}
