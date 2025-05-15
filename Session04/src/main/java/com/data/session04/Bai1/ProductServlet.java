package com.data.session04.Bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Áo thun", 120000));
        list.add(new Product(2, "Quần jean", 250000));
        list.add(new Product(3, "Giày sneaker", 500000));

        request.setAttribute("products", list);
        request.getRequestDispatcher("BaiTap/Bai1/Bai1.jsp").forward(request, response);
    }
}