
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Đặt hàng</title></head>
<body>
<h2>Form đặt hàng</h2>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<form action="orderBai8" method="post">
    Tên người dùng: <input type="text" name="username" required><br><br>
    Sản phẩm: <input type="text" name="product" required><br><br>
    Số lượng: <input type="number" name="quantity" min="1" required><br><br>
    <button type="submit">Đặt hàng</button>
</form>

<br>
<a href="ordersBai8">Xem đơn hàng đã đặt</a>
</body>
</html>
