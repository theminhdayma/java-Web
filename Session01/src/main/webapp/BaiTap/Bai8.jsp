<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.session01.Bai8Servlet" %>
<html>
<head>
    <title>Quản lý công việc</title>
    <style>
        body {
            font-family: Arial;
            padding: 20px;
        }
        .task {
            margin-bottom: 10px;
        }
        .completed {
            text-decoration: line-through;
            color: gray;
        }
    </style>
</head>
<body>
<h2>Thêm công việc mới</h2>
<form action="Bai8Servlet" method="post">
    <input type="text" name="taskName" placeholder="Tên công việc" required>
    <button type="submit">Thêm</button>

    <h3>Danh sách công việc</h3>
    <%
        List<Bai8Servlet.Task> tasks = (List<Bai8Servlet.Task>) request.getAttribute("tasks");
        if (tasks != null && !tasks.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                Bai8Servlet.Task task = tasks.get(i);
    %>
    <div class="task">
        <input type="checkbox" name="completed" value="<%= i %>" <%= task.isCompleted() ? "checked disabled" : "" %> />
        <span class="<%= task.isCompleted() ? "completed" : "" %>"><%= task.getName() %></span>
    </div>
    <%
        }
    %>
    <br>
    <button type="submit">Cập nhật trạng thái</button>
    <%
    } else {
    %>
    <p>Chưa có công việc nào.</p>
    <%
        }
    %>
</form>
</body>
</html>
