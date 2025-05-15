<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Giới thiệu bản thân</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f0f2f5;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 800px;
      margin: 50px auto;
      padding: 30px;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    h1 {
      text-align: center;
      color: #333;
    }

    .section {
      margin-top: 20px;
    }

    .section h2 {
      color: #007acc;
    }

    .section p {
      line-height: 1.6;
    }
  </style>
</head>
<body>
<div class="container">
  <h1><%= "Giới Thiệu Về Tôi" %></h1>

  <div class="section">
    <h2>👤 Thông tin cá nhân</h2>
    <p>Tên: <strong>Nguyễn Thế Minh</strong></p>
    <p>Tuổi: <strong>20</strong></p>
    <p>Địa chỉ: <strong>Hà Nội</strong></p>
    <p>Chuyên ngành: <strong>Công nghệ thông tin</strong></p>
  </div>
</div>
</body>
</html>
