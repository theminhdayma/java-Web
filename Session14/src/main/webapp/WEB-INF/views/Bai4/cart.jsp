<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<h2>Danh sách sản phẩm trong giỏ hàng (Session)</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="item" items="${cart}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td>
                <a href="remove?index=${loop.index}">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>


<br>
<a href="form">Thêm sản phẩm</a>
</body>
</html>
