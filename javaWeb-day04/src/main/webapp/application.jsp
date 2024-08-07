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
<%
    ArrayList<String> books = new ArrayList<String>();
    books.add("Book 1");
    books.add("Book 2");
    application.setAttribute("books", books);
    // 转发
    // application.getRequestDispatcher("/list.jsp").forward(request,response);
    // 重定向
    response.sendRedirect("./list.jsp");
%>
</body>
</html>
