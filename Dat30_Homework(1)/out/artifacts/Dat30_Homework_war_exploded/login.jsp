<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2018/1/3
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<%@include file="login.html"%>
</body>
<script type="text/javascript">
    <%
        String username = (String) session.getAttribute("username");
        if(username!=null){
    %>
    $('#username').val("<%=username%>");
    <%
    }
    %>


</script>
</html>
