<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>
<h2>Danh sách đơn hàng</h2>
<a href="${pageContext.request.contextPath}/orders/add">Thêm đơn hàng mới</a>
<table border="1" cellpadding="8" cellspacing="0" style="margin-top: 10px;">
    <thead>
    <tr>
        <th>Mã đơn hàng</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.productName}</td>
            <td>${order.quantity}</td>
            <td>
                <a href="${pageContext.request.contextPath}/orders/edit/${order.orderId}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/orders/delete/${order.orderId}" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
