<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Tạo Dự Án</title>
</head>
<body>
<h2>Tạo Dự Án Mới</h2>

<form:form modelAttribute="project" method="post" action="createProject" enctype="multipart/form-data">
    <label>Tên dự án:</label><br>
    <form:input path="name"/><br><br>

    <label>Mô tả:</label><br>
    <form:textarea path="description"/><br><br>

    <label>Chọn tài liệu (nhiều file):</label><br>
    <input type="file" name="documents" multiple/><br><br>

    <input type="submit" value="Tạo Dự Án"/>
</form:form>
</body>
</html>
