<%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-31
  Time: 오전 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
제목 : ${post.getTitle()}<br />
작성시간 : ${post.getWriteTime()}<br />
작성자: ${post.getWriterUserId()}<br />
내용: ${post.getContent()}<br />
<a href="/post/delete.do?id=${post.getId()}"> 삭제</a> <br/>
<a href="/post/listView.do"> 글 목록으로</a> <br/>
<a href="/"> 홈화면으로</a> <br/>
</body>
</html>
