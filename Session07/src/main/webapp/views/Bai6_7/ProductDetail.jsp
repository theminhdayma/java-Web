<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Chi tiết sản phẩm</title></head>
<body>
<h2>Chi tiết sản phẩm</h2>
<img src="${product.image}" width="200"/>
<p><strong>Tên:</strong> ${product.name}</p>
<p><strong>Giá:</strong> ${product.price}</p>
<p><strong>Số lượng:</strong> ${product.stock}</p>
<p><strong>Mô tả:</strong> ${product.description}</p>
<a href="products">Quay lại danh sách</a>
</body>
</html>