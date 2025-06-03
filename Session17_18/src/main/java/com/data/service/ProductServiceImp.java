package com.data.service;

import com.data.dao.ProductDao;
import com.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(int page, int size) {
        return productDao.findAll(page, size);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public long countAll() {
        return productDao.countAll();
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public List<Product> filterProductByPrice(double minPrice, double maxPrice) {
        return productDao.filterProductByPrice(minPrice, maxPrice);
    }
}
