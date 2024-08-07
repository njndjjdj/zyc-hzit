<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2024/8/7
  Time: 上午10:05
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
    pageContext.setAttribute("books", books);
    // 转发
    // request.getRequestDispatcher("./list.jsp").forward(request, response);
    // pageContext: 作用域代表数据只在当前页面有效，不管是转发还是重定向在另一个页面都取不到数据！
    // 重定向
    response.sendRedirect("./list.jsp");
%>
</body>
</html>
