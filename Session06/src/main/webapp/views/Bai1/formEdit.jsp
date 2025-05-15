<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Sửa sách</title></head>
<body>
<h2>Sửa thông tin sách</h2>
<form action="books" method="post">
    <input type="hidden" name="action" value="edit"/>
    <input type="hidden" name="id" value="${book.bookId}"/>
    Tiêu đề: <input type="text" name="title" value="${book.title}"/><br/>
    Tác giả: <input type="text" name="author" value="${book.author}"/><br/>
    Thể loại: <input type="text" name="category" value="${book.category}"/><br/>
    Số lượng: <input type="number" name="quantity" value="${book.quantity}"/><br/>
    <input type="submit" value="Cập nhật"/>
</form>
<a href="books">Quay lại danh sách</a>
</body>
</html>
