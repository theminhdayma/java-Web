<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  request.setCharacterEncoding("UTF-8");

  List<Map<String, Object>> products = new ArrayList<>();

  Map<String, Object> p1 = new HashMap<>();
  p1.put("id", 1);
  p1.put("name", "Áo Thun");
  p1.put("price", 200000);
  p1.put("description", "Chất liệu cotton, thoáng mát");
  products.add(p1);

  Map<String, Object> p2 = new HashMap<>();
  p2.put("id", 2);
  p2.put("name", "Quần Jean");
  p2.put("price", 400000);
  p2.put("description", "Bền, phong cách cá tính");
  products.add(p2);

  Map<String, Object> p3 = new HashMap<>();
  p3.put("id", 3);
  p3.put("name", "Giày Thể Thao");
  p3.put("price", 600000);
  p3.put("description", "Êm ái, phù hợp vận động");
  products.add(p3);

  String searchId = request.getParameter("productId");
  Map<String, Object> foundProduct = null;

  if (searchId != null && !searchId.isEmpty()) {
    int idToFind = Integer.parseInt(searchId);
    for (Map<String, Object> p : products) {
      if ((int) p.get("id") == idToFind) {
        foundProduct = p;
        break;
      }
    }
  }

  request.setAttribute("product", foundProduct);
%>

<html>
<head>
  <title>Tìm Kiếm Sản Phẩm</title>
</head>
<body>
<h2>🔍 Tìm Kiếm Sản Phẩm Theo ID</h2>

<form method="get">
  Nhập ID sản phẩm:
  <input type="text" name="productId" />
  <input type="submit" value="Tìm kiếm" />
</form>

<br/>

<c:choose>
  <c:when test="${not empty product}">
    <h3 style="color:green;">Sản phẩm tìm thấy:</h3>
    <p><strong>ID:</strong> ${product.id}</p>
    <p><strong>Tên:</strong> ${product.name}</p>
    <p><strong>Giá:</strong> ${roduct.price} VNĐ</p>
    <p><strong>Mô tả:</strong> ${product.description}</p>
  </c:when>
  <c:otherwise>
    <c:if test="${param.productId != null}">
      <h3 style="color:red;">Sản phẩm không tìm thấy</h3>
    </c:if>
  </c:otherwise>
</c:choose>
</body>
</html>
