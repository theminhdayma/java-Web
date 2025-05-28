<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>
<p>${description}</p>

<form method="post" action="change-language">
    <label>${languageSelect}:</label>
    <select name="lang" onchange="this.form.submit()">
        <option value="en" ${selectedLang == 'en' ? 'selected' : ''}>English</option>
        <option value="vi" ${selectedLang == 'vi' ? 'selected' : ''}>Tiếng Việt</option>
    </select>
</form>
</body>
</html>
