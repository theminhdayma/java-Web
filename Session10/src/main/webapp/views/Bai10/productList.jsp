
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="${pageContext.request.contextPath}/product/form">Thêm sản phẩm</a>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Giá</th>
        <th>Tồn kho</th>
        <th>Hình ảnh</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="p" items="${productList}">
        <tr>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
            <td><img src="${p.image}" width="100"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/product/edit/${p.id}">Sửa</a>
                <a href="${pageContext.request.contextPath}/product/delete/${p.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
