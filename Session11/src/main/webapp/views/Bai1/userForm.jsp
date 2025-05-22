<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form người dùng</title>
</head>
<body>
<h2>Form nhập thông tin người dùng</h2>
<form:form modelAttribute="user" method="post" action="save">
    <div>
        <label>Tên:</label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
        <label>Email:</label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <label>Số điện thoại:</label>
        <form:input path="phone"/>
        <form:errors path="phone" cssClass="error"/>
    </div>
    <div>
        <label>Mật khẩu:</label>
        <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <label>Trạng thái:</label>
        <form:checkbox path="status"/> Kích hoạt
    </div>
    <div>
        <button type="submit">Gửi</button>
    </div>
</form:form>
</body>
</html>
