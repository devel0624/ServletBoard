<%@ page import="com.nhnacademey.board.domain.repository.PostRepository" %>
<%@ page import="com.nhnacademey.board.domain.post.Post" %><%--
  Created by IntelliJ IDEA.
  User: LSJ
  Date: 2022-10-31
  Time: 오전 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>POST</title>
</head>
<body>
번호 제목 <br/>
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
    <%= "<p>&nbsp"%>
    <%=postNum%>
    <%=href%>
    <%= "<br/>" %>
<%}%>
<br/>
<a href="/post/register.do"> 글 작성하기</a> <br/>
<a href="/index.jsp"> 홈화면으로</a> <br/>

</body>
</html>
