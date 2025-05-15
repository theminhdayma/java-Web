package com.data.session05.controller.Bai8;

import com.data.session05.model.Bai8.Task;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TaskController", value = "/tasks")
public class TaskController extends HttpServlet {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void init() throws ServletException {
        tasks.add(new Task(nextId++, "Hoàn thành báo cáo", "2025-05-15", false));
        tasks.add(new Task(nextId++, "Học JSP/Servlet", "2025-05-16", true));
        tasks.add(new Task(nextId++, "Gửi email khách hàng", "2025-05-17", false));
        tasks.add(new Task(nextId++, "Chuẩn bị thuyết trình", "2025-05-18", true));
        tasks.add(new Task(nextId++, "Làm bài tập nhóm", "2025-05-19", false));
        tasks.add(new Task(nextId++, "Tham gia họp dự án", "2025-05-20", true));
        tasks.add(new Task(nextId++, "Cập nhật tài liệu kỹ thuật", "2025-05-21", false));
        tasks.add(new Task(nextId++, "Review mã nguồn", "2025-05-22", true));
        tasks.add(new Task(nextId++, "Fix bug giao diện", "2025-05-23", false));
        tasks.add(new Task(nextId++, "Triển khai hệ thống", "2025-05-24", true));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                request.getRequestDispatcher("views/Bai8/form.jsp").forward(request, response);
                break;
            case "edit":
                int editId = Integer.parseInt(request.getParameter("id"));
                for (Task task : tasks) {
                    if (task.getId() == editId) {
                        request.setAttribute("task", task);
                        break;
                    }
                }
                request.getRequestDispatcher("views/Bai8/form.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("tasks", tasks);
                request.getRequestDispatcher("views/Bai8/taskList.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        switch (action) {
            case "create":
                Task newTask = new Task(
                        nextId++,
                        request.getParameter("description"),
                        request.getParameter("dueDate"),
                        request.getParameter("completed") != null
                );
                tasks.add(newTask);
                response.sendRedirect("tasks");
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                for (Task task : tasks) {
                    if (task.getId() == id) {
                        task.setDescription(request.getParameter("description"));
                        task.setDueDate(request.getParameter("dueDate"));
                        task.setCompleted(request.getParameter("completed") != null);
                        break;
                    }
                }
                response.sendRedirect("tasks");
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                tasks.removeIf(task -> task.getId() == deleteId);
                response.sendRedirect("tasks");
                break;
        }
    }
}