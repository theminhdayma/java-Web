<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách danh mục</title>
</head>
<body>
<h2>Danh sách danh mục</h2>
<a href="${pageContext.request.contextPath}/category/add">Thêm danh mục</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên danh mục</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.categoryName}</td>
            <td><c:choose>
                <c:when test="${category.status}">
                    Hoạt động
                </c:when>
                <c:otherwise>
                    Không hoạt động
                </c:otherwise>
            </c:choose></td>
            <td>
                <a href="${pageContext.request.contextPath}/category/edit/${category.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/category/delete/${category.id}"
                   onclick="return confirm('Xác nhận xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
