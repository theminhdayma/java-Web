<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<h2>Shop - Số dư: ${user.balance}</h2>
<c:forEach var="s" items="${seeds}">
    <div>
        <img src="${s.imageUrl}" width="100" />
        <p>${s.seedsName} - ${s.price} VND</p>
        <form action="buy" method="post">
            <input type="hidden" name="seedId" value="${s.id}" />
            <button>Mua</button>
        </form>
    </div>
</c:forEach>

<a href="game">Quang lại trang chủ</a>

</body>
</html>
