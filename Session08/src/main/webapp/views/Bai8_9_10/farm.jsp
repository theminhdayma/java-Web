<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Trang nông trại</title>
</head>
<body>
<h2>Trang nông trại</h2>
<c:forEach var="i" begin="1" end="20">
    <div style="display:inline-block; margin: 5px; border: 1px solid #ccc; padding: 10px;">
        <p>Ô đất ${i}</p>
        <c:choose>
            <c:when test="${plots[i] != null}">
                <img src="${plots[i].imageUrl}" width="80" />
                <p>${plots[i].seedsName}</p>
            </c:when>
            <c:otherwise>
                <form action="plant" method="post">
                    <input type="hidden" name="plotNumber" value="${i}" />
                    <label>
                        <select name="seedId">
                            <c:forEach var="w" items="${warehouseSeeds}">
                                <c:if test="${w.quantity > 0}">
                                    <option value="${w.seeds.id}">${w.seeds.seedsName} (${w.quantity})</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </label>
                    <button>Gieo</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</c:forEach>

<a href="game">Quay lại trang chủ</a>

</body>
</html>
