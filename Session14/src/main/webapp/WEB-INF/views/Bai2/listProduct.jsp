<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<c:choose>
    <c:when test="${empty products}">
        <p>Không có sản phẩm nào.</p>
    </c:when>
    <c:otherwise>
        <table border="1" cellpadding="5">
            <tr><th>Mã</th><th>Tên</th><th>Giá</th><th>Hành động</th></tr>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<br>
<a href="add">Thêm sản phẩm mới</a>
</body>
</html>
