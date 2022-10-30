<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-30
  Time: 오후 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Register</title>
</head>
<body>

<form method="post" action="/user/register.do">
    이름: <input type="text" name="name" /><br/>
    아이디: <input type="text" name="id" /><br/>
    비밀번호: <input type="text" name="pw" /><br/>
    <input type="submit"/>
</form>

</body>
</html>
