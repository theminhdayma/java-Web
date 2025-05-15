<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Product List</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<ul>
    <c:forEach items="${productList}" var="product">
        <li>${product.id} - ${product.name} - ${product.price} USD</li>
    </c:forEach>
</ul>
</body>
</html>
