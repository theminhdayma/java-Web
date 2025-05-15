package com.data.session06.service.Bai3;

import com.data.session06.dao.Bai3.ProductCartDao;
import com.data.session06.dao.Bai3.ProductCartDaoImp;
import com.data.session06.model.Bai3.ProductCart;

import java.util.List;

public class ProductCartServiceImp implements ProductCartService {
    private ProductCartDao productCartDao;

    public ProductCartServiceImp() {
        productCartDao = new ProductCartDaoImp();
    }

    @Override
    public List<ProductCart> findCartByUserId(int userId) {
        return productCartDao.findCartByUserId(userId);
    }

    @Override
    public boolean removeProductFromCart(int userId, int productId) {
        return productCartDao.removeProductFromCart(userId, productId);
    }
}
