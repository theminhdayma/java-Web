<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông tin người dùng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f9;
        }
        table {
            width: 70%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 20px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
            text-align: center;
        }
        td {
            background-color: #f9f9f9;
        }
        tr:hover td {
            background-color: #f1f1f1;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Thông tin người dùng</h2>
    <table>
        <tr>
            <th>Tên</th>
            <th>Tuổi</th>
        </tr>
        <tr>
            <td>${userName}</td>
            <td>${userAge}</td>
        </tr>
    </table>
</div>
</body>
</html>
