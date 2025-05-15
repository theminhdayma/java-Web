package com.data.session06.controller.Bai4;

import com.data.session06.model.Bai4.Employee;
import com.data.session06.service.Bai4.EmployeeService;
import com.data.session06.service.Bai4.EmployeeServiceImp;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeController", value = "/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Employee employee = employeeService.findById(idEdit);
                req.setAttribute("employee", employee);
                req.getRequestDispatcher("views/Bai4/editEmployee.jsp").forward(req, resp);
                break;
            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                employeeService.delete(idDelete);
                resp.sendRedirect("employee");
                break;
            case "search":
                String keyword = req.getParameter("keyword");
                List<Employee> result = employeeService.searchEmployeeByName(keyword);
                req.setAttribute("employees", result);
                req.getRequestDispatcher("views/Bai4/listEmployee.jsp").forward(req, resp);
                break;
            case "add":
                req.getRequestDispatcher("views/Bai4/addEmployee.jsp").forward(req, resp);
                break;
            default:
                List<Employee> list = employeeService.findAll();
                req.setAttribute("employees", list);
                req.getRequestDispatcher("views/Bai4/listEmployee.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                Employee newEmp = new Employee();
                newEmp.setName(req.getParameter("name"));
                newEmp.setBirthday(req.getParameter("birthday"));
                newEmp.setPhone(req.getParameter("phone"));
                newEmp.setEmail(req.getParameter("email"));
                newEmp.setSalary(Float.parseFloat(req.getParameter("salary")));
                newEmp.setPosition(req.getParameter("position"));
                employeeService.save(newEmp);
                break;
            case "update":
                Employee empUpdate = new Employee();
                empUpdate.setId(Integer.parseInt(req.getParameter("id")));
                empUpdate.setName(req.getParameter("name"));
                empUpdate.setBirthday(req.getParameter("birthday"));
                empUpdate.setPhone(req.getParameter("phone"));
                empUpdate.setEmail(req.getParameter("email"));
                empUpdate.setSalary(Float.parseFloat(req.getParameter("salary")));
                empUpdate.setPosition(req.getParameter("position"));
                employeeService.update(empUpdate);
                break;
        }
        resp.sendRedirect("employee");
    }
}
