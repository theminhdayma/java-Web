<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Task Form</title></head>
<body>
<h2>${task == null ? "Add Task" : "Edit Task"}</h2>
<form action="tasks" method="post">
    <input type="hidden" name="action" value="${task == null ? 'create' : 'update'}"/>
    <c:if test="${task != null}">
        <input type="hidden" name="id" value="${task.id}"/>
    </c:if>
    Description: <input type="text" name="description" value="${task.description}"/><br/>
    Due Date: <input type="text" name="dueDate" value="${task.dueDate}"/><br/>
    Completed: <input type="checkbox" name="completed" <c:if test="${task.completed}">checked</c:if> /><br/>
    <input type="submit" value="Save"/>
</form>
<a href="tasks">Quay lại danh sách</a>
</body>
</html>