<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<ul>
  <c:forEach var="product" items="${products}">
    <li>${product.name} - ${product.price} VND - ${product.description}</li>
  </c:forEach>
</ul>
</body>
</html>
