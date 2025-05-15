<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm - Category: ${category}</h2>
<c:if test="${not empty color}">
    <p>Lọc theo màu: ${color}</p>
</c:if>
<c:if test="${not empty size}">
    <p>Lọc theo size: ${size}</p>
</c:if>

<table border="1">
    <tr>
        <th>Tên</th>
        <th>Màu</th>
        <th>Size</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.color}</td>
            <td>${product.size}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>