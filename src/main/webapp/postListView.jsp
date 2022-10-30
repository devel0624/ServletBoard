<%@ page import="com.nhnacademey.board.domain.repository.PostRepository" %>
<%@ page import="com.nhnacademey.board.domain.post.Post" %><%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-31
  Time: 오전 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <fmt:setLocale value='<%= application.getAttribute("lang") %>'/>
    <fmt:setBundle basename="message" var="message" />
    <title> <fmt:message key="posts" bundle="${message}" /> </title>
</head>
<body>
<fmt:message key="number" bundle="${message}" /> <fmt:message key="title" bundle="${message}" /> <br/>
<%
    PostRepository postRepository = (PostRepository) pageContext.getServletContext().getAttribute("postRepository");

  for(int i = 0; i < postRepository.getPosts().size(); i++){
      Post post = postRepository.getPost(i+1);
      String href = "<a href=/post/view.do?id=" + post.getId() + ">" + post.getTitle() + "</a>";
      String postNum;
      if(post.getId() < 10){
          postNum = "0" + post.getId();
      }else {
          postNum = "" + post.getId();
      }
%>
    <%= "&nbsp"%>
    <%=postNum%>
    <%=href%>
    <%= "<br/>" %>
<%}%>
<br/>
<a href="/post/register.do">  <fmt:message key="postRegist" bundle="${message}"/> </a> <br/>
<a href="/"> <fmt:message key="home" bundle="${message}"/> </a> <br/>

</body>
</html>
