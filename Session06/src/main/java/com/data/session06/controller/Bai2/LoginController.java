package com.data.session06.controller.Bai2;

import com.data.session06.service.Bai2.UserService;
import com.data.session06.service.Bai2.UserServiceImp;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    private final UserService userService;

    public LoginController() {
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/Bai2/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean loginSuccess = userService.login(username, password);

        if (loginSuccess) {
            req.setAttribute("message", "Đăng nhập thành công!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/Bai2/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/Bai2/login.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
