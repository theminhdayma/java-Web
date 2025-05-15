
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi xảy ra</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .error-message {
            color: red;
            font-size: 20px;
            border: 2px solid red;
            padding: 20px;
            border-radius: 5px;
            background-color: #f8d7da;
        }
    </style>
</head>
<body>
<h1>Đã có lỗi xảy ra!</h1>
<div class="error-message">
    <%= request.getAttribute("errorMessage") %>
</div>
</body>
</html>
