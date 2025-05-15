
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<h2>Chỉnh sửa sản phẩm</h2>
<form action="${pageContext.request.contextPath}/Bai9/products/update" method="post">
    <input type="hidden" name="id" value="${product.id}" />
    Tên sản phẩm: <input type="text" name="name" value="${product.name}" required /><br/>
    Giá: <input type="number" step="0.01" name="price" value="${product.price}" required /><br/>
    Loại:
    <select name="categoryId">
        <c:forEach var="cat" items="${categories}">
            <option value="${cat.id}" ${cat.id == product.categoryId ? 'selected' : ''}>${cat.name}</option>
        </c:forEach>
    </select><br/>
    <button type="submit">Cập nhật</button>
</form>
<c:if test="${not empty message}">
    <div style="color:green;">${message}</div>
</c:if>
</body>
</html>