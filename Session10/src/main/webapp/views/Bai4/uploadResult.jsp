<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kết Quả Upload</title>
</head>
<body>
<h2>${message}</h2>
<p>Username: ${username}</p>

<c:if test="${not empty avatarPath}">
    <p>Ảnh đại diện:</p>
    <img src="${avatarPath}" width="150" height="150"/>
</c:if>
</body>
</html>
