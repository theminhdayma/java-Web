<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Library</title></head>
<body>
<h2>Danh sách sách</h2>
<a href="books?action=create">Thêm sách mới</a>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th><th>Tiêu đề</th><th>Tác giả</th><th>Thể loại</th><th>Số lượng</th><th>Hành động</th>
    </tr>
    <c:forEach var="b" items="${listBooks}">
        <tr>
            <td><c:out value="${b.bookId}"/></td>
            <td><c:out value="${b.title}"/></td>
            <td><c:out value="${b.author}"/></td>
            <td><c:out value="${b.category}"/></td>
            <td><c:out value="${b.quantity}"/></td>
            <td>
                <a href="books?action=edit&id=${b.bookId}">Sửa</a> |
                <a href="books?action=delete&id=${b.bookId}" onclick="return confirm('Xóa sách?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
