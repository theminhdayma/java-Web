package com.data.dao;

import com.data.entity.Order;

import java.util.List;

public interface OrderDao {
    void save(Order order);
    List<Order> findByCustomerIdPaginated(int customerId, int page, int size);
    int countPagesByCustomerId(int customerId, int size);
    void cancelOrder(int orderId, int customerId);
}
