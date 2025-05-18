<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <title>Nhập Sản Phẩm</title>
</head>
<body>
<h2>Nhập thông tin sản phẩm</h2>
<form:form method="post" modelAttribute="product" action="addProduct">
  <label for="name">Tên sản phẩm:</label>
  <form:input path="name"/><br/><br/>

  <label for="price">Giá:</label>
  <form:input path="price"/><br/><br/>

  <label for="description">Mô tả:</label>
  <form:textarea path="description"/><br/><br/>

  <input type="submit" value="Thêm sản phẩm"/>
</form:form>
</body>
</html>
