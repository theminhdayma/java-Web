package com.data.session06.controller.Bai3;

import com.data.session06.model.Bai3.ProductCart;
import com.data.session06.service.Bai3.ProductCartService;
import com.data.session06.service.Bai3.ProductCartServiceImp;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CartController", value = "/CartController")
public class CartController extends HttpServlet {
    private ProductCartService productCartService;

    public CartController() {
        productCartService = new ProductCartServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = 1;
        String action = request.getParameter("action");
        if ("remove".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            productCartService.removeProductFromCart(userId, productId);
            response.sendRedirect("CartController");
            return;
        }
        List<ProductCart> cartList = productCartService.findCartByUserId(userId);
        request.setAttribute("cartList", cartList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Bai3/cart.jsp");
        dispatcher.forward(request, response);
    }
}