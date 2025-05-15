
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<form action="products" method="get">
    <input type="text" name="keyword" placeholder="Tìm kiếm..."/>
    <button type="submit">Tìm</button>
</form>

<p><a href="products/add">Thêm sản phẩm</a></p>

<c:if test="${not empty message}">
    <p style="color: green">${message}</p>
</c:if>

<table border="1">
    <tr>
        <th>ID</th><th>Tên</th><th>Giá</th><th>Danh mục</th><th>Hành động</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td><a href="products/${p.id}">${p.name}</a></td>
            <td>${p.price}</td>
            <td>
                <c:forEach var="c" items="${categories}">
                    <c:if test="${c.id == p.categoryId}">${c.name}</c:if>
                </c:forEach>
            </td>
            <td>
                <a href="products/edit/${p.id}">Sửa</a> |
                <a href="products/delete/${p.id}" onclick="return confirm('Xóa sản phẩm này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>