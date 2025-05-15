package com.data.session06.service.Bai3;

import com.data.session06.dao.Bai3.ProductDao;
import com.data.session06.dao.Bai3.ProductDaoImp;
import com.data.session06.model.Bai3.Product;

import java.util.List;

public class ProductServiceImp implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImp() {
        productDao = new ProductDaoImp();
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public boolean addProductToCart(int userId, int productId, int quantity) {
        return productDao.addProductToCart(userId, productId, quantity);
    }
}
