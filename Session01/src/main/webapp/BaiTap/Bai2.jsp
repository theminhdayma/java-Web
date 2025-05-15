
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Web Project Structure</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 40px;
        }

        .directory {
            background-color: #fff;
            padding: 20px;
            margin: 20px 0;
            border: 1px solid #ddd;
            border-radius: 8px;
        }

        h2 {
            color: #4CAF50;
            font-size: 1.5em;
        }

        p {
            color: #555;
            font-size: 1em;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Java Web Project Structure</h1>
    <div class="directory">
        <h2>src/main/java</h2>
        <p>Chứa các file Java như Servlet, Controller, Business Logic.</p>
    </div>
    <div class="directory">
        <h2>src/main/resources</h2>
        <p>Lưu trữ cấu hình (config), tệp tài nguyên (images, properties, XML, ...).</p>
    </div>
    <div class="directory">
        <h2>src/main/webapp</h2>
        <p>Chứa các tài nguyên web tĩnh hoặc động như HTML, JSP, CSS, JS – được đóng gói vào WAR.</p>
    </div>
</div>
</body>
</html>
