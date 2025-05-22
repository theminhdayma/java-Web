<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:choose>
        <c:when test="${category.id != null}">Sửa danh mục</c:when>
        <c:otherwise>Thêm danh mục</c:otherwise>
    </c:choose></title>
</head>
<body>
<h2><c:choose>
    <c:when test="${category.id != null}">Sửa danh mục</c:when>
    <c:otherwise>Thêm danh mục</c:otherwise>
</c:choose></h2>

<form action="<c:choose>
                 <c:when test='${category.id != null}'>${pageContext.request.contextPath}/category/update</c:when>
                 <c:otherwise>${pageContext.request.contextPath}/category/save</c:otherwise>
             </c:choose>" method="post">
    <c:if test="${category.id != null}">
        <input type="hidden" name="id" value="${category.id}"/>
    </c:if>

    <label for="categoryName">Tên danh mục:</label>
    <input type="text" id="categoryName" name="categoryName" value="${category.categoryName != null ? category.categoryName : ''}" required/>
    <br/>

    <c:if test="${category.id != null}">
        <label for="status">Trạng thái:</label>
        <input type="checkbox" id="status" name="status" <c:if test="${category.status}">checked</c:if> />
        <br/>
    </c:if>

    <button type="submit">
        <c:choose>
            <c:when test="${category.id != null}">Cập nhật</c:when>
            <c:otherwise>Lưu</c:otherwise>
        </c:choose>
    </button>
</form>

</body>
</html>
