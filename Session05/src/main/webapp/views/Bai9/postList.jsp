<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Danh sách bài viết</title></head>
<body>
<h1>Danh sách bài viết</h1>
<ul>
    <c:forEach var="post" items="${posts}">
        <li>
            <a href="blog?id=${post.id}">${post.title}</a> -
                ${post.author} - ${post.publishDate}
        </li>
    </c:forEach>
</ul>
</body>
</html>