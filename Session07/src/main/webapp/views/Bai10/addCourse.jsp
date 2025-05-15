
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Thêm khóa học</title></head>
<body>
<h2>Thêm khóa học mới</h2>

<form action="${pageContext.request.contextPath}/courses/add" method="post">
    Tên khóa học: <input type="text" name="name" required/><br/><br/>
    Mô tả: <textarea name="description" rows="4" cols="30"></textarea><br/><br/>
    <button type="submit">Thêm</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/courses">Quay lại danh sách</a>
</body>
</html>