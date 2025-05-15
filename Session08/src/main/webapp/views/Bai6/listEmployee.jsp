<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<h2>Danh sách nhân viên</h2>

<c:if test="${not empty successMessage}">
    <p style="color:green;">${successMessage}</p>
</c:if>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>Tên</th>
        <th>Email</th>
        <th>Vị trí</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>
</table>

<p><a href="employees/add">Thêm nhân viên mới</a></p>
</body>
</html>
