<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-30
  Time: 오후 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
프로필 : ${user.profileFileName}<br />
이름: ${user.name}<br />
<a href="/index.jsp"> 홈화면으로</a> <br/>
<a href="/user/logout.do"> 로그아웃</a> <br/>
</body>
</html>
