<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-29
  Time: 오후 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <fmt:setLocale value='<%= application.getAttribute("lang") %>'/>
  <fmt:setBundle basename="message" var="message" />
  <title><fmt:message key="index" bundle="${message}" /></title>
</head>
  <body>
  <a href="/user/login.do"> <fmt:message key="login" bundle="${message}" />  </a> <br/>
  <a href="/user/register.do"> <fmt:message key="register" bundle="${message}" /></a> <br/>
  <a href="/post/listView.do"> <fmt:message key="posts" bundle="${message}"/> </a> <br/>
  <a href="/lang/change.do"> <fmt:message key="changeLanguage" bundle="${message}"/> </a> <br/>
  </body>
</html>
