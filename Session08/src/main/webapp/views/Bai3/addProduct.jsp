<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form:form method="POST" action="/product/add" modelAttribute="product">
    <p>
        <label>Tên sản phẩm:</label>
        <form:input path="name" />
    </p>
    <p>
        <label>Giá:</label>
        <form:input path="price" />
    </p>
    <p>
        <button type="submit">Thêm mới</button>
    </p>
</form:form>
</body>
</html>
