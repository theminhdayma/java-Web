package com.data.session02;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "UserInfoServlet", value = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("BaiTap/Bai2.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        request.setAttribute("name", name);
        request.setAttribute("age", age);

        RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/Bai2Result.jsp");
        dispatcher.forward(request, response);
    }
}
