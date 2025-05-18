<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head><title>Danh Sách Sách</title></head>
<body>
<h2>Danh Sách Sách</h2>

<a href="addBookForm">Thêm sách mới</a><br><br>

<table border="1" cellpadding="5">
    <tr>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Mô tả</th>
        <th>File eBook</th>
    </tr>
    <tr>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.description}</td>
        <td><a href="${pageContext.request.contextPath}/uploads/${book.file}">Download</a></td>
    </tr>
</table>

</body>
</html>
