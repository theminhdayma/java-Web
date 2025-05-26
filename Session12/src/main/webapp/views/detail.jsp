<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Chi tiết sản phẩm</title></head>
<body>
<h2>Chi tiết sản phẩm</h2>
<p>Tên: ${product.name}</p>
<p>Giá: ${product.price}</p>
<p>Mô tả: ${product.description}</p>
<p>Trạng thái: ${product.status}</p>
<img src="/uploads/${product.image}" width="200"/>
<br/>
<a href="list.jsp">← Quay lại</a>
</body>
</html>
