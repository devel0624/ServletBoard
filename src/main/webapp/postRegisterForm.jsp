<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-31
  Time: 오전 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value='<%= application.getAttribute("lang") %>'/>
    <fmt:setBundle basename="message" var="message" />
    <title> <fmt:message key="postRegist" bundle="${message}" /> </title>
<body>
<form method="post" action="/post/register.do">
    <fmt:message key="title" bundle="${message}" /> : <input type="text" name="title" /><br/>
    <fmt:message key="content" bundle="${message}" /><br/>
  <textarea name="content"></textarea><br/>
    <input type="submit" value="<fmt:message key="submit" bundle="${message}" />"/>  <br/>
    <a href="/"> <fmt:message key="home" bundle="${message}"/> </a> <br/>
</form>
</body>
</html>
