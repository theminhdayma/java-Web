<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form đăng ký</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h2>Đăng ký người dùng</h2>

<form:form action="/register" method="post" modelAttribute="user">

    <p>
    Họ tên:
    <form:input path="name"/>
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors.fieldErrors}">
            <c:if test="${error.field == 'name'}">
                <div class="error">${error.defaultMessage}</div>
            </c:if>
        </c:forEach>
    </c:if>
    </p>

    <p>
    Email:
    <form:input path="email"/>
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors.fieldErrors}">
            <c:if test="${error.field == 'email'}">
                <div class="error">${error.defaultMessage}</div>
            </c:if>
        </c:forEach>
    </c:if>
    </p>

    <p>
    Số điện thoại:
    <form:input path="phone"/>
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors.fieldErrors}">
            <c:if test="${error.field == 'phone'}">
                <div class="error">${error.defaultMessage}</div>
            </c:if>
        </c:forEach>
    </c:if>
    </p>

    <p>
    Mật khẩu:
    <form:password path="password"/>
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors.fieldErrors}">
            <c:if test="${error.field == 'password'}">
                <div class="error">${error.defaultMessage}</div>
            </c:if>
        </c:forEach>
    </c:if>
    </p>

    <p>
        <input type="submit" value="Đăng ký"/>
    </p>

</form:form>

</body>
</html>
