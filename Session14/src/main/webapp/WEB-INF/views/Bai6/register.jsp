<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title><fmt:message key="register.title"/></title>
    <style>
        .error {color: red;}
    </style>
</head>
<body>
<h2><fmt:message key="register.title"/></h2>

<!-- Link chọn ngôn ngữ -->
<a href="?lang=en">English</a> | <a href="?lang=vi">Tiếng Việt</a>

<form:form method="post" modelAttribute="user">
    <div>
        <form:label path="username"><fmt:message key="register.username"/></form:label><br/>
        <form:input path="username"/>
        <form:errors path="username" cssClass="error"/>
    </div>
    <div>
        <form:label path="password"><fmt:message key="register.password"/></form:label><br/>
        <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <form:label path="confirmPassword"><fmt:message key="register.confirmPassword"/></form:label><br/>
        <form:password path="confirmPassword"/>
        <form:errors path="confirmPassword" cssClass="error"/>
    </div>
    <div>
        <form:label path="email"><fmt:message key="register.email"/></form:label><br/>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <button type="submit"><fmt:message key="register.submit"/></button>
</form:form>
</body>
</html>
