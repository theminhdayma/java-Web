<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thêm sách</title></head>
<body>
<h2>Thêm sách mới</h2>
<form action="${pageContext.request.contextPath}/books" method="post">
    <input type="hidden" name="action" value="create"/>
    Tiêu đề: <input type="text" name="title"/><br/>
    Tác giả: <input type="text" name="author"/><br/>
    Thể loại: <input type="text" name="category"/><br/>
    Số lượng: <input type="number" name="quantity"/><br/>
    <input type="submit" value="Thêm"/>
</form>
<a href="books">Quay lại danh sách</a>
</body>
</html>
