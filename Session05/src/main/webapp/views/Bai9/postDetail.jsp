<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Chi tiết bài viết</title></head>
<body>
<h1>${post.title}</h1>
<p><strong>Tác giả:</strong> ${post.author}</p>
<p><strong>Ngày đăng:</strong> ${post.publishDate}</p>
<hr>
<p>${post.content}</p>
<p><a href="blog">Quay lại danh sách</a></p>
</body>
</html>