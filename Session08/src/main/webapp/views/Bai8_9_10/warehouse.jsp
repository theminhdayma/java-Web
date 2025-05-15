<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kho hạt giống</title>
</head>
<body>
<h2>Kho hạt giống</h2>

<c:choose>
    <c:when test="${not empty warehouseSeeds}">
        <c:forEach var="w" items="${warehouseSeeds}">
            <div>
                <img src="${w.seeds.imageUrl}" width="80" alt=""/>
                <p>${w.seeds.seedsName} - Số lượng: ${w.quantity}</p>
            </div>
        </c:forEach>
    </c:when>

    <c:otherwise>
        <p style="color: red;">Kho trống</p>
    </c:otherwise>
</c:choose>

<a href="game">Quay lại trang chủ</a>

</body>
</html>
