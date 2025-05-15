<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Cập nhật nhân viên</title></head>
<body>
<h2>Cập nhật nhân viên</h2>
<form action="employee" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <input type="text" name="name" value="${employee.name}" required><br>
    <input type="date" name="birthday" value="${employee.birthday}" required><br>
    <input type="text" name="phone" value="${employee.phone}" required><br>
    <input type="email" name="email" value="${employee.email}" required><br>
    <input type="number" name="salary" value="${employee.salary}" required><br>
    <input type="text" name="position" value="${employee.position}" required><br>
    <input type="hidden" name="action" value="update">
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
