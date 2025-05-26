<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sửa sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f4f8;
            padding: 40px;
            margin: 0;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 25px 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        div {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #444;
        }

        input[type="text"],
        input[type="number"],
        input[type="file"],
        select,
        textarea {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 15px;
            box-sizing: border-box;
            transition: border-color 0.2s ease-in-out;
        }

        input:focus,
        textarea:focus,
        select:focus {
            border-color: #007bff;
            outline: none;
        }

        textarea {
            resize: vertical;
            min-height: 80px;
        }

        .error {
            color: red;
            font-size: 13px;
            margin-top: 5px;
        }

        button[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h2>Sửa sản phẩm</h2>
<form:form modelAttribute="productDto" method="post" enctype="multipart/form-data">
    <div>
        <form:label path="name">Tên:</form:label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
        <form:label path="price">Giá:</form:label>
        <form:input path="price"/>
        <form:errors path="price" cssClass="error"/>
    </div>
    <div>
        <form:label path="description">Mô tả:</form:label>
        <form:textarea path="description"/>
    </div>
    <div>
        <form:label path="image">Ảnh mới (nếu có):</form:label>
        <form:input type="file" path="image"/>
        <form:errors path="image" cssClass="error"/>
    </div>
    <div>
        <form:label path="status">Trạng thái:</form:label>
        <form:select path="status">
            <form:options items="${statusList}"/>
        </form:select>
        <form:errors path="status" cssClass="error"/>
    </div>
    <button type="submit">Cập nhật</button>
</form:form>
</body>
</html>
