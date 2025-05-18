<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Upload Avatar</title>
</head>
<body>
<h2>Upload Ảnh Đại Diện</h2>
<form:form modelAttribute="userProfile" method="post" action="uploadAvatar" enctype="multipart/form-data">
    <label>Username:</label>
    <form:input path="username"/><br/><br/>

    <label>Avatar:</label>
    <form:input path="avatar" type="file"/><br/><br/>

    <input type="submit" value="Upload"/>
</form:form>
</body>
</html>
