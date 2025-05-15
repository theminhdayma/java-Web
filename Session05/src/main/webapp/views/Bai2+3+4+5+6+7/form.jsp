<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thêm sinh viên</title>
</head>
<body>
<h2>Nhập thông tin sinh viên</h2>

<form action="${pageContext.request.contextPath}/studentController" method="post">
    Họ tên: <input type="text" name="name" value="${param.name}" required><br><br>
    Tuổi: <input type="number" name="age" value="${param.age}" required><br><br>
    Địa chỉ: <input type="text" name="address" value="${param.address}" required><br><br>
    <input type="submit" value="Gửi">
</form>
</body>
</html>
