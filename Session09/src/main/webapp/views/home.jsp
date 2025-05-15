<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Trang Chủ - Danh sách phim</title>
</head>
<body>
<h1>Danh sách phim đang chiếu</h1>

<table border="1" cellpadding="10">
    <thead>
    <tr>
        <th>Tiêu đề</th>
        <th>Đạo diễn</th>
        <th>Thể loại</th>
        <th>Thời lượng (phút)</th>
        <th>Ngôn ngữ</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.genre}</td>
            <td>${movie.duration}</td>
            <td>${movie.language}</td>
            <td>
                <!-- Nút Đặt vé -->
                <a href="${pageContext.request.contextPath}/movies/${movie.id}/schedules">
                    Đặt vé
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
