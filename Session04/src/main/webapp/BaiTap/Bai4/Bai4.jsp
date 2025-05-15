<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  Map<String, String> product = new HashMap<>();
  product.put("name", "Áo sơ mi nam");
  product.put("price", "350000");

  request.setAttribute("product", product);
%>

<html>
<head>
  <title>Thông Tin Sản Phẩm</title>
</head>
<body>
<h2>Chi Tiết Sản Phẩm</h2>

<c:choose>
  <c:when test="${not empty product}">
    <p><strong>Tên sản phẩm:</strong> ${product.name}</p>
    <p><strong>Giá:</strong> ${product.price} VNĐ</p>
  </c:when>
  <c:otherwise>
    <p style="color:red;">Sản phẩm không có thông tin.</p>
  </c:otherwise>
</c:choose>

</body>
</html>
