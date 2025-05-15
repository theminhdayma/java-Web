<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Task List</title></head>
<body>
<h2>Danh sách công việc</h2>
<a href="tasks?action=add">Thêm mới công việc</a>
<table border="1">
    <tr><th>ID</th><th>Description</th><th>Due Date</th><th>Completed</th><th>Actions</th></tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>${task.dueDate}</td>
            <td><c:choose>
                <c:when test="${task.completed}">Yes</c:when>
                <c:otherwise>No</c:otherwise>
            </c:choose>
            </td>
            <td>
                <a href="tasks?action=edit&id=${task.id}">Edit</a>
                <form action="tasks" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${task.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>