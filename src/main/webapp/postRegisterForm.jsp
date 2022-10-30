<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-31
  Time: 오전 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/post/register.do">
  제목: <input type="text" name="title" /><br/>
  내용<br/>
  <textarea name="content"></textarea><br/>
    <input type="submit"/><br/>

</form>
</body>
</html>
