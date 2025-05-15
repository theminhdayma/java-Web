package com.data.session01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Bai8Servlet", value = "/Bai8Servlet")
public class Bai8Servlet extends HttpServlet {

    private static final List<Task> taskList = new ArrayList<>();

    public static class Task {
        private String name;
        private boolean completed;

        public Task(String name) {
            this.name = name;
            this.completed = false;
        }

        public String getName() {
            return name;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("taskName");
        if (taskName != null && !taskName.trim().isEmpty()) {
            taskList.add(new Task(taskName));
        }

        String[] completedIndexes = request.getParameterValues("completed");
        if (completedIndexes != null) {
            for (String indexStr : completedIndexes) {
                int index = Integer.parseInt(indexStr);
                if (index >= 0 && index < taskList.size()) {
                    taskList.get(index).setCompleted(true);
                }
            }
        }

        request.setAttribute("tasks", taskList);
        request.getRequestDispatcher("BaiTap/Bai8.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tasks", taskList);
        request.getRequestDispatcher("BaiTap/Bai8.jsp").forward(request, response);
    }
}
