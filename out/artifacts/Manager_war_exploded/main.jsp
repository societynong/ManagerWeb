<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/14
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    Welcome,<%
        String uname = (String) session.getAttribute("uname");
        if(uname == null)
            response.sendRedirect("/mg/login");
        else
            out.write((String)session.getAttribute("uname"));%> to login.
</body>
</html>
