package com.data.session06.controller.Bai3;

import com.data.session06.model.Bai3.Product;
import com.data.session06.service.Bai3.ProductService;
import com.data.session06.service.Bai3.ProductServiceImp;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private final ProductService productService;

    public ProductController() {
        productService = new ProductServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("views/Bai3/listProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean success = productService.addProductToCart(userId, productId, quantity);
        if (success) {
            response.sendRedirect(request.getContextPath() + "/ProductController");
        } else {
        }
    }
}