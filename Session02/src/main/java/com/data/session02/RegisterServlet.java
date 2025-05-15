package com.data.session02;import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegisterServlet ", value = "/RegisterServlet")
public class RegisterServlet  extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html lang='vi'>");
        out.println("<head><meta charset='UTF-8'><title>Nhập Thông Tin</title></head>");
        out.println("<body>");
        out.println("<h2>Nhập Thông Tin</h2>");
        out.println("<form action='RegisterServlet' method='post'>");
        out.println("<label for='username'>Tên người dùng:</label>");
        out.println("<input type='text' id='username' name='username' required><br><br>");
        out.println("<label for='email'>Email:</label>");
        out.println("<input type='email' id='email' name='email' required><br><br>");
        out.println("<button type='submit'>Gửi</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        request.setAttribute("username", username);
        request.setAttribute("email", email);

        response.sendRedirect("BaiTap/Bai4.jsp");
    }

    @Override
    public void destroy() {
        
    }
}