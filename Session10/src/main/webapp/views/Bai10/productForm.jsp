<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form sản phẩm</title>
</head>
<body>
<h2><c:if test="${product.id == 0}">Thêm</c:if><c:if test="${product.id != 0}">Cập nhật</c:if> sản phẩm</h2>

<form action="<c:choose>
                 <c:when test='${product.id == 0}'>${pageContext.request.contextPath}/product/add</c:when>
                 <c:otherwise>${pageContext.request.contextPath}/product/update</c:otherwise>
             </c:choose>" method="post" enctype="multipart/form-data">

    <input type="hidden" name="id" value="${product.id}" />

    <label>Tên:</label>
    <input type="text" name="name" value="${product.name}" required/><br/>

    <label>Giá:</label>
    <input type="number" name="price" value="${product.price}" required/><br/>

    <label>Tồn kho:</label>
    <input type="number" name="stock" value="${product.stock}" required/><br/>

    <label>Hình ảnh:</label>
    <input type="file" name="file"/><br/>
    <c:if test="${not empty product.image}">
        <img src="${product.image}" width="100"/><br/>
    </c:if>

    <button type="submit">Lưu</button>
</form>

<a href="${pageContext.request.contextPath}/product/list">Quay lại danh sách</a>
</body>
</html>
