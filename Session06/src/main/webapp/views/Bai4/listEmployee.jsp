<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<h1>Danh sách nhân viên</h1>

<form action="employee" method="get">
    <input type="hidden" name="action" value="search" />
    <input type="text" name="keyword" placeholder="Tìm theo tên" />
    <button type="submit">Tìm kiếm</button>
</form>

<a href="employee?action=add">Thêm mới nhân viên</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Điện thoại</th>
        <th>Email</th>
        <th>Lương</th>
        <th>Chức vụ</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="e" items="${employees}">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.birthday}</td>
            <td>${e.phone}</td>
            <td>${e.email}</td>
            <td>${e.salary}</td>
            <td>${e.position}</td>
            <td>
                <a href="employee?action=edit&id=${e.id}">Sửa</a> |
                <a href="employee?action=delete&id=${e.id}" onclick="return confirm('Xoá?')">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
