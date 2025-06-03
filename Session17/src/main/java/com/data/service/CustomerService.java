package com.data.service;

import com.data.entity.Customer;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    Customer login(String username, String password);
}
