package com.data.service;

import com.data.dao.OrderDao;
import com.data.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> findByCustomerIdPaginated(int customerId, int page, int size) {
        return orderDao.findByCustomerIdPaginated(customerId, page, size);
    }

    @Override
    public int countPagesByCustomerId(int customerId, int size) {
        return orderDao.countPagesByCustomerId(customerId, size);
    }

    @Override
    public void cancelOrder(int orderId, int customerId) {
        orderDao.cancelOrder(orderId, customerId);
    }
}
