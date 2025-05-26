<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 30px;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }

        .top-actions {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-bottom: 20px;
        }

        .top-actions form {
            display: flex;
            gap: 10px;
        }

        input[type="text"] {
            padding: 8px;
            width: 250px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        button {
            padding: 8px 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }

        button:hover {
            background-color: #0056b3;
        }

        .add-btn {
            padding: 8px 15px;
            background-color: #17a2b8;
            color: white;
            border-radius: 4px;
            text-decoration: none;
            font-size: 14px;
            display: inline-block;
            line-height: 30px;
        }

        .add-btn:hover {
            background-color: #117a8b;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f8f9fa;
            font-weight: bold;
        }

        td img {
            max-width: 100px;
            border-radius: 5px;
        }

        .actions a {
            text-decoration: none;
            padding: 6px 10px;
            border-radius: 4px;
            font-size: 13px;
            color: white;
            margin: 0 3px;
            display: inline-block;
        }

        .actions .edit {
            background-color: #28a745;
        }

        .actions .edit:hover {
            background-color: #218838;
        }

        .actions .delete {
            background-color: #dc3545;
        }

        .actions .delete:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<h2>Danh sách sản phẩm</h2>

<div class="top-actions">
    <form action="${pageContext.request.contextPath}/product/search" method="get">
        <input type="text" name="keyword" placeholder="Nhập tên sản phẩm..." />
        <button type="submit">🔍 Tìm kiếm</button>
    </form>
    <a class="add-btn" href="${pageContext.request.contextPath}/product/add">➕ Thêm sản phẩm</a>
</div>

<table>
    <thead>
    <tr>
        <th>Tên</th>
        <th>Giá</th>
        <th>Mô tả</th>
        <th>Ảnh</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><img src="${pageContext.request.contextPath}/${product.image}" alt="Ảnh sản phẩm" /></td>
            <td>${product.status}</td>
            <td class="actions">
                <a class="edit" href="${pageContext.request.contextPath}/product/edit/${product.id}">✏ Sửa</a>
                <a class="delete" href="${pageContext.request.contextPath}/product/delete/${product.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?');">🗑 Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
