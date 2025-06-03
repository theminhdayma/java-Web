package com.data.dao;

import com.data.entity.Customer;

public interface CustomerDao {
    boolean addCustomer(Customer customer);
    Customer login(String username, String password);
}
