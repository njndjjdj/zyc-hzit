<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2024/8/7
  Time: 上午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>pageContext作用域:当前页</h1>
<%
    ArrayList<String> books = (ArrayList<String>) pageContext.getAttribute("books");
    out.println(books);
%>
<h1>request作用域:本次请求</h1>
<%
    books = (ArrayList<String>) request.getAttribute("books");
    out.println(books);
%>
<h1>session作用域:当前浏览器</h1>
<%
    books = (ArrayList<String>) session.getAttribute("books");
    String id = session.getId();
    out.println("id:" + id + "<br>");
    out.println(books);
%>
<h1>application作用域:当前浏览器</h1>
<%
    books = (ArrayList<String>) application.getAttribute("books");
    out.println(books);
%>
</body>
</html>
