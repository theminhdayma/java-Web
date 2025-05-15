
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form action="${pageContext.request.contextPath}/Bai9/products/save" method="post">
    Tên sản phẩm: <input type="text" name="name" required /><br/>
    Giá: <input type="number" step="0.01" name="price" required /><br/>
    Loại:
    <select name="categoryId">
        <c:forEach var="cat" items="${categories}">
            <option value="${cat.id}">${cat.name}</option>
        </c:forEach>
    </select><br/>
    <button type="submit">Lưu</button>
</form>
<c:if test="${not empty message}">
    <div style="color:green;">${message}</div>
</c:if>
</body>
</html>