package com.data.session05.controller.Bai2_3_4_5_6_7;

import com.data.session05.model.Bai2_3_4_5_6_7.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentController", value = "/studentController")
public class StudentController extends HttpServlet {
    private static final List<Student> students = new ArrayList<>();
    private static final int STUDENTS_PER_PAGE = 5;

    @Override
    public void init() {
        students.add(new Student(1, "Nguyễn Văn A", 19, "Hà Giang"));
        students.add(new Student(2, "Trần Thị B", 20, "Nam Định"));
        students.add(new Student(3, "Lê Minh C", 21, "Nghệ An"));
        students.add(new Student(4, "Phạm Hữu D", 22, "Vĩnh Long"));
        students.add(new Student(5, "Ngô Quang E", 23, "Hậu Giang"));
        students.add(new Student(6, "Bùi Văn F", 24, "Lạng Sơn"));
        students.add(new Student(7, "Hoàng Thị G", 25, "Kon Tum"));
        students.add(new Student(8, "Đặng Thu H", 26, "Quảng Trị"));
        students.add(new Student(9, "Vũ Anh I", 27, "Điện Biên"));
        students.add(new Student(10, "Lý Tuấn J", 28, "Lâm Đồng"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

        if (loggedIn == null || !loggedIn) {
            response.sendRedirect("views/Bai2+3+4+5+6+7/login.jsp");
            return;
        }

        String action = request.getParameter("action");
        int currentPage = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            currentPage = Integer.parseInt(pageParam);
        }

        int totalStudents = students.size();
        int totalPages = (int) Math.ceil((double) totalStudents / STUDENTS_PER_PAGE);

        if (currentPage < 1) currentPage = 1;
        if (currentPage > totalPages) currentPage = totalPages;

        int startIndex = (currentPage - 1) * STUDENTS_PER_PAGE;
        int endIndex = Math.min(startIndex + STUDENTS_PER_PAGE, totalStudents);
        List<Student> studentsOnPage = students.subList(startIndex, endIndex);

        request.setAttribute("students", studentsOnPage);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = getStudentById(id);
            request.setAttribute("student", student);
            request.getRequestDispatcher("views/Bai2+3+4+5+6+7/editStudent.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            students.removeIf(s -> s.getId() == id);
            response.sendRedirect("studentController");
        } else {
            request.getRequestDispatcher("views/Bai2+3+4+5+6+7/listStudent.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            Student student = getStudentById(id);
            if (student != null) {
                student.setName(name);
                student.setAge(age);
                student.setAddress(address);
            }
        } else {
            int newId = students.size() + 1;
            students.add(new Student(newId, name, age, address));
        }

        response.sendRedirect("studentController");
    }

    private Student getStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }
}
