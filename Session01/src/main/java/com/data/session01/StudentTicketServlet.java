package com.data.session01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentTicketServlet", value = "/StudentTicketServlet")
public class StudentTicketServlet extends HttpServlet {

    private List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyen Van A", "K61", "Xe máy", "29A-12345"));
        students.add(new Student("Tran Thi B", "K62", "Ô tô", "30B-67890"));
        students.add(new Student("Le Minh C", "K63", "Xe đạp", "31C-11223"));
        return students;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Student> students = getStudentList();

        req.setAttribute("students", students);

        req.getRequestDispatcher("BaiTap/listStudent.jsp").forward(req, resp);
    }
}
