package com.data.session02;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserRegistrationServlet", value = "/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='vi'>");
        out.println("<head><meta charset='UTF-8'><title>Dang ky nguoi dung</title></head>");
        out.println("<body>");
        out.println("<h2>Form dang ky</h2>");
        out.println("<form action='UserRegistrationServlet' method='post'>");
        out.println("<label>Ten: </label>");
        out.println("<input type='text' name='username' required><br><br>");
        out.println("<label>Email: </label>");
        out.println("<input type='email' name='email' required><br><br>");
        out.println("<label>Mat khau: </label>");
        out.println("<input type='password' name='password' required><br><br>");
        out.println("<button type='submit'>Dang ky</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Đặt dữ liệu vào request attribute
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/Bai5.jsp");
        dispatcher.forward(request, response);
    }
}
