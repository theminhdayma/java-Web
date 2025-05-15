<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký người dùng</title>
</head>
<body>
<h2>Đăng ký người dùng</h2>
<form:form method="POST" action="/user" modelAttribute="user">
    <p>
        <label for="username">Tên người dùng:</label>
        <form:input path="username" />
        <form:errors path="username" cssClass="error" />
    </p>
    <p>
        <label for="email">Email:</label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error" />
    </p>
    <p>
        <label for="phone">Số điện thoại:</label>
        <form:input path="phone" />
        <form:errors path="phone" cssClass="error" />
    </p>
    <p>
        <button type="submit">Đăng ký</button>
    </p>
</form:form>
</body>
</html>
