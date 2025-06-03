package com.data.service;

import com.data.dao.CustomerDao;
import com.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public Customer login(String username, String password) {
        return customerDao.login(username, password);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public List<Customer> searchCustomerByName(String username) {
        return customerDao.searchCustomerByName(username);
    }

    @Override
    public boolean lockCustomer(Customer customer) {
        return customerDao.lockCustomer(customer);
    }

    @Override
    public boolean unlockCustomer(Customer customer) {
        return customerDao.unlockCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }
}
