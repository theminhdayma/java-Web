<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<table border="1" cellpadding="8">
  <tr>
    <th>ID</th>
    <th>Tên sản phẩm</th>
    <th>Giá</th>
  </tr>
  <c:forEach var="p" items="${products}">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.price} VND</td>
    </tr>
  </c:forEach>
</table>
<br/>
</body>
</html>
