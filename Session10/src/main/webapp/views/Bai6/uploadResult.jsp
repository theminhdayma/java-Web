<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Kết quả upload</title>
</head>
<body>
<h2>Kết quả upload file</h2>

<p><strong>Thông báo:</strong> ${message}</p>

<c:if test="${not empty fileUrl}">
    <p><strong>Mô tả:</strong> ${description}</p>
    <p><strong>File URL:</strong> <a href="${fileUrl}" target="_blank">${fileUrl}</a></p>
    <p><strong>Xem file:</strong></p>
    <iframe src="${fileUrl}" width="100%" height="600px"></iframe>
</c:if>

<br>
<a href="uploadFormCloud">⬅ Quay lại form upload</a>
</body>
</html>
