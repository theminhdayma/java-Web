<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Kết Quả Dự Án</title>
</head>
<body>
<h2>${message}</h2>

<c:if test="${not empty name}">
    <p><strong>Tên dự án:</strong> ${name}</p>
    <p><strong>Mô tả:</strong> ${description}</p>
    <c:if test="${not empty files}">
        <p><strong>File đã upload:</strong></p>
        <ul>
            <c:forEach var="fileName" items="${files}">
                <li>${fileName}</li>
            </c:forEach>
        </ul>
    </c:if>

</c:if>

<a href="projectForm">⬅ Quay lại form</a>
</body>
</html>
