<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Form Góp Ý</h2>

<c:if test="${not empty errors}">
  <ul style="color:red;">
    <c:forEach var="err" items="${errors}">
      <li>${err}</li>
    </c:forEach>
  </ul>
</c:if>

<form:form action="submitForm" modelAttribute="feedback" method="post">
  Họ và tên: <form:input path="name"/><br/>
  Số điện thoại: <form:input path="phone"/><br/>
  Địa chỉ: <form:input path="address"/><br/>
  Nội dung góp ý: <form:textarea path="content"/><br/>
  <input type="submit" value="Gửi góp ý"/>
</form:form>