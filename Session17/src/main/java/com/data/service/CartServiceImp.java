package com.data.service;

import com.data.dao.CartDao;
import com.data.entity.ProductCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public ProductCart findByCustomerIdAndProductId(int customerId, int productId) {
        return cartDao.findByCustomerIdAndProductId(customerId, productId);
    }

    @Override
    public void save(ProductCart productCart) {
        cartDao.save(productCart);
    }

    @Override
    public void update(ProductCart productCart) {
        cartDao.update(productCart);
    }

    @Override
    public List<ProductCart> findByCustomerId(int customerId) {
        return cartDao.findByCustomerId(customerId);
    }
}
