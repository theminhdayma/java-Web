<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách người dùng</title>
    <style>
        table {
            width: 60%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #333;
            padding: 8px;
        }
    </style>
</head>
<body>
<h2>Danh sách người dùng</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên người dùng</th>
        <th>Email</th>
        <th>Số điện thoại</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
