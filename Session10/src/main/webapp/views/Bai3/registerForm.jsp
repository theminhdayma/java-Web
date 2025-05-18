<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Đăng ký tài khoản</title>
</head>
<body>
<h2>Form đăng ký</h2>
<form:form method="post" modelAttribute="account" action="register">
    <label>Tên đăng nhập:</label>
    <form:input path="username"/><br/><br/>

    <label>Mật khẩu:</label>
    <form:password path="password"/><br/><br/>

    <label>Email:</label>
    <form:input path="email"/><br/><br/>

    <input type="submit" value="Đăng ký"/>
</form:form>
</body>
</html>
