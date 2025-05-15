package com.data.session01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Bai2Servlet", value = "/Bai2Servlet")
public class Bai2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/Bai2.jsp");
        dispatcher.forward(request, response);
    }
}