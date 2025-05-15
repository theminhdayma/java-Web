package com.data.session01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Bai3Servlet", value = "/Bai3Servlet")
public class Bai3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "Nguyễn Thế Minh";
        int age = 20;


        request.setAttribute("userName", name);
        request.setAttribute("userAge", age);


        RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/Bai3.jsp");
        dispatcher.forward(request, response);
    }
}