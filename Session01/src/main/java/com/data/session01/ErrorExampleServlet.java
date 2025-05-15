package com.data.session01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ErrorExampleServlet", value = "/ErrorExampleServlet")
public class ErrorExampleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int[] numbers = {1, 2, 3};
            int invalidIndexValue = numbers[5];

            response.getWriter().write("Lỗi, Không thể hiển thị.");
        } catch (ArrayIndexOutOfBoundsException e) {
            request.setAttribute("errorMessage", "Đã xảy ra lỗi: Chỉ mục mảng không hợp lệ.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("BaiTap/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
