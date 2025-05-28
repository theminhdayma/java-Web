<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title><fmt:message key="register.success.title"/></title>
</head>
<body>
<h2><fmt:message key="register.success.title"/></h2>

<p>${message}</p>

<a href="${pageContext.request.contextPath}/register"><fmt:message key="register.backToRegister"/></a>
</body>
</html>
