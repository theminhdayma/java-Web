<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Upload File to Cloud</title>
</head>
<body>
<h2>Upload File lên Cloud</h2>

<form:form modelAttribute="uploadFile" method="post" action="uploadFile" enctype="multipart/form-data">
    <label>Mô tả:</label><br/>
    <form:textarea path="description" rows="4" cols="40"/><br/><br/>

    <label>Chọn file:</label><br/>
    <form:input path="file" type="file"/><br/><br/>

    <input type="submit" value="Tải lên"/>
</form:form>

</body>
</html>
