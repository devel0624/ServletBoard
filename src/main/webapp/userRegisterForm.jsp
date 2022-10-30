<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-30
  Time: 오후 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value='<%= application.getAttribute("lang") %>'/>
    <fmt:setBundle basename="message" var="message" />
    <title> <fmt:message key="register" bundle="${message}" /> </title>
</head>
<body>

<form method="post" action="/user/register.do">
    <fmt:message key="name" bundle="${message}" />: <input type="text" name="name" /><br/>
    <fmt:message key="id" bundle="${message}" />: <input type="text" name="id" /><br/>
    <fmt:message key="pw" bundle="${message}" />: <input type="text" name="pw" /><br/>
    <input type="submit" value="<fmt:message key="submit" bundle="${message}" />"/>  <br/>
    <a href="/index.jsp"> <fmt:message key="home" bundle="${message}"/> </a> <br/></form>

</body>
</html>
