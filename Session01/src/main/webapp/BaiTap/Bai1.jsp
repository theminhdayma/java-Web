
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mô hình hoạt động Java Web</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            margin: 0;
            padding: 0;
            background: #f4f6f9;
            color: #333;
        }

        h1 {
            margin: 0;
            font-size: 26px;
        }

        .container {
            padding: 30px;
            max-width: 1000px;
            margin: auto;
        }

        .box {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 20px;
            margin-bottom: 20px;
        }

        .box h2 {
            font-size: 20px;
            color: #2c3e50;
            margin-bottom: 10px;
        }

        .box ul {
            padding-left: 20px;
        }

        .box ul li {
            margin-bottom: 6px;
            line-height: 1.6;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="box">
        <h2>Chức năng từng thành phần</h2>
        <ul>
            <li><strong>Client (Người dùng):</strong> Gửi yêu cầu từ trình duyệt web và nhận phản hồi.</li>
            <li><strong>Web Server:</strong> Nhận và chuyển yêu cầu từ client đến Web Container.</li>
            <li><strong>Web Container:</strong> Quản lý các servlet, xử lý request và response.</li>
            <li><strong>Request Object:</strong> Chứa dữ liệu từ phía client gửi đến.</li>
            <li><strong>Response Object:</strong> Chứa dữ liệu sẽ trả về cho client.</li>
            <li><strong>Servlet (Java):</strong> Xử lý logic nghiệp vụ, truy vấn dữ liệu, tạo phản hồi.</li>
            <li><strong>JSP, CSS, HTML:</strong> Tạo giao diện người dùng.</li>
            <li><strong>SQL (Cơ sở dữ liệu):</strong> Lưu trữ và truy vấn dữ liệu.</li>
        </ul>
    </div>

    <div class="box">
        <h2>Cách các thành phần tương tác</h2>
        <p>
            Khi người dùng gửi một yêu cầu từ trình duyệt (<strong>client request</strong>), yêu cầu được gửi đến <strong>Web Server</strong>. Web Server chuyển yêu cầu vào <strong>Web Container</strong>, nơi tạo ra một đối tượng <strong>Request</strong> để chứa dữ liệu từ client.
            Web Container sau đó chuyển đối tượng này đến <strong>Servlet</strong> để xử lý logic bằng Java. Servlet có thể truy cập <strong>cơ sở dữ liệu (SQL)</strong> để lấy hoặc cập nhật thông tin.
            Sau khi xử lý xong, Servlet tạo ra một đối tượng <strong>Response</strong> chứa kết quả (thường là <strong>JSP/HTML/CSS</strong>) và gửi ngược lại qua Web Container đến Web Server, từ đó trả về cho trình duyệt của người dùng.
        </p>
    </div>
</div>
</body>
</html>
