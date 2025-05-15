package com.data.session02;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    private static final List<Product> productList = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Product p : productList) {
                if (p.getId() == id) {
                    request.setAttribute("editProduct", p);
                    break;
                }
            }
        }

        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/Bai6_7_8.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            for (Product p : productList) {
                if (p.getId() == id) {
                    p.setName(name);
                    p.setPrice(price);
                    break;
                }
            }
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            productList.removeIf(p -> p.getId() == id);
        } else {
            // Thêm mới sản phẩm
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            productList.add(new Product(idCounter++, name, price));
        }

        response.sendRedirect("ProductServlet");
    }
}
