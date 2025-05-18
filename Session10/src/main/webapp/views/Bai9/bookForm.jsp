<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Thêm Sách</title>
</head>
<body>
<h2>Thêm Sách</h2>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<form:form modelAttribute="book" method="post" enctype="multipart/form-data"
           action="addBook">

    <label>Tiêu đề:</label><br>
    <form:input path="title" required="true"/><br><br>

    <label>Tác giả:</label><br>
    <form:input path="author" required="true"/><br><br>

    <label>Mô tả:</label><br>
    <form:textarea path="description"/><br><br>

    <label>File eBook:</label><br>
    <form:input path="file" type="file" required="true"/><br><br>

    <input type="submit" value="Lưu"/>
</form:form>

<a href="addBookForm">⬅ Danh sách sách</a>
</body>
</html>
