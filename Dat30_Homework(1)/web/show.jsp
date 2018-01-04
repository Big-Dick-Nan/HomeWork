<%@ page import="java.util.List" %>
<%@ page import="com.lixiaonan.bean.Book" %>
<%@ page import="com.lixiaonan.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    if(user!=null){
        session.setAttribute("username",user.getUsername());
%>
<table border="1" style="text-align: center"></table>
<%
    }else {
        response.sendRedirect("http://localhost:8080/login.jsp");
    }
%>
${requestScope.book}

</body>
    <script type="text/javascript">
        $.getJSON("http://localhost:8080/show",
            function (data, status) {
                if(status=="success"){

                    if(data!=null){
                        $('table')
                            .append($('<tr>')
                                .append($('<th>').text("书名"))
                                .append($('<th>').text("作者"))
                                .append($('<th>').text("价格")));
                        $.each(data,function (index,obj){
                            $('table')
                                .append($('<tr>')
                                    .append($('<td>').text(obj['bookname']))
                                    .append($('<td>').text(obj['author']))
                                    .append($('<td>').text(obj['price'])));
                        })
                    }
                }
            })
</script>
</html>

