package com.data.session01;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Bai4Servlet", value = "/Bai4Servlet")
public class Bai4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/Bai4.jsp");
        dispatcher.forward(request, response);
    }
}