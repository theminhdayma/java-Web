package com.data.session05.controller.Bai1;

import com.data.session05.model.Bai1.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() {
        productList.add(new Product(1, "Áo sơ mi", 150.0, "Áo sơ mi trắng"));
        productList.add(new Product(2, "Quần jeans", 250.0, "Quần jeans xanh"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productList);
        request.getRequestDispatcher("views/Bai1/product.jsp").forward(request, response);
    }
}