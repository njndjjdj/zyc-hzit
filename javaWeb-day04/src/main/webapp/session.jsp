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
    <title>session作用域</title>
</head>
<body>

<%
    ArrayList<String> books = new ArrayList<String>();
    books.add("Book 1");
    books.add("Book 2");
    session.setAttribute("books", books);
    // 使用转发
    request.getRequestDispatcher("./list.jsp").forward(request, response);
    session.removeAttribute("books");
    // 使用重定向
    //response.sendRedirect("./list.jsp");
    /**
     * session作用域
     * 与浏览器是否关闭有关，因为浏览器的缓存cookie中存放的是session的id值，如果浏览器关闭或者更换浏览器
     * 都无法得到这个key，在服务端就找不到对应用户的session，但是如果session还在有效时间内，session仍然存在于服务端
     */
%>
</body>
</html>
