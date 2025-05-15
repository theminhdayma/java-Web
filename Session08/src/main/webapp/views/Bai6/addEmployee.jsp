<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm nhân viên</title>
</head>
<body>
<h2>Thêm nhân viên mới</h2>
<form:form method="POST" action="/employees" modelAttribute="employee">
    <p>
        <label>Tên nhân viên:</label>
        <form:input path="name"/>
    </p>
    <p>
        <label>Email:</label>
        <form:input path="email"/>
    </p>
    <p>
        <label>Vị trí:</label>
        <form:input path="position"/>
    </p>
    <p>
        <button type="submit">Thêm mới</button>
    </p>
</form:form>
</body>
</html>
