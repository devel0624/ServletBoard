<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-31
  Time: 오전 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value='<%= application.getAttribute("lang") %>'/>
    <fmt:setBundle basename="message" var="message" />
    <title> ${post.getTitle()} </title>
</head>
<body>
<fmt:message key="title" bundle="${message}"/> : ${post.getTitle()}<br />
<fmt:message key="writeTime" bundle="${message}"/> : ${post.getWriteTime()}<br />
<fmt:message key="writer" bundle="${message}"/> : ${post.getWriterUserId()}<br />
<fmt:message key="content" bundle="${message}"/> : ${post.getContent()}<br />
<a href="/post/delete.do?id=${post.getId()}"> <fmt:message key="delete" bundle="${message}"/></a> <br/>
<a href="/post/listView.do"> <fmt:message key="posts" bundle="${message}"/> </a> <br/>
<a href="/"> <fmt:message key="home" bundle="${message}"/> </a> <br/>
</body>
</html>
