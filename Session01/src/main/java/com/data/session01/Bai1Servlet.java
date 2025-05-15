package com.data.session01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Bai1Servlet", value = "/Bai1Servlet")
public class Bai1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/Bai1.jsp");
        dispatcher.forward(request, response);
    }
}