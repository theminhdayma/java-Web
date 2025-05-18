<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Upload Tài Liệu</title>
</head>
<body>
<h2>Upload Tài Liệu PDF</h2>

<form:form modelAttribute="document" method="post" action="uploadDocument" enctype="multipart/form-data">
    <label>Tiêu đề:</label>
    <form:input path="title" /><br/><br/>

    <label>Mô tả:</label>
    <form:textarea path="description" rows="4" cols="50" /><br/><br/>

    <label>Tệp PDF:</label>
    <form:input path="fileName" type="file" /><br/><br/>

    <input type="submit" value="Tải lên" />
</form:form>
</body>
</html>
