package com.data.session06.controller.Bai2;

import com.data.session06.dao.Bai2.UserDao;
import com.data.session06.dao.Bai2.UserDaoImp;
import com.data.session06.model.Bai2.User;
import com.data.session06.service.Bai2.UserService;
import com.data.session06.service.Bai2.UserServiceImp;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {

    private final UserService userService;

    public RegisterController() {
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/Bai2/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User newUser = new User();
        newUser.setUsername(req.getParameter("username"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setEmail(req.getParameter("email"));
        newUser.setPhone(req.getParameter("phone"));

        boolean registrationSuccess = userService.save(newUser);

        if (registrationSuccess) {
            resp.sendRedirect("views/Bai2/login.jsp");
        } else {
            req.setAttribute("error", "Đăng ký không thành công. Vui lòng thử lại.");
            doGet(req, resp);
        }
    }
}
