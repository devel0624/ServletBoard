<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-30
  Time: 오후 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value='<%= application.getAttribute("lang") %>'/>
    <fmt:setBundle basename="message" var="message" />
    <title> <fmt:message key="profile" bundle="${message}" /> </title>
</head>
<body>
<fmt:message key="profile" bundle="${message}" /> : ${user.profileFileName}<br />
<fmt:message key="name" bundle="${message}" /> : ${user.name}<br />
<a href="/user/logout.do"> <fmt:message key="logout" bundle="${message}"/></a> <br/>
<a href="/user/delete.do?id=${user.id}"> <fmt:message key="withdrawal" bundle="${message}"/></a> <br/>
<a href="/index.jsp"> <fmt:message key="home" bundle="${message}"/> </a> <br/>

</body>
</html>
