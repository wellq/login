<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/16
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>更新页面</h3>
    <form method="post" action="UpdateServlet">
        <input type="hidden" name="id" value="${user.id}"><br>
        姓名:<input type="text" name="name" value="${user.name}"><br>
        性别:<input type="text" name="sex" value="${user.sex}"><br>
        年龄:<input type="text" name="age" value="${user.age}"><br>
        电话:<input type="text" name="phone" value="${user.phone}"><br>
        住址:<input type="text" name="address" value="${user.address}"><br>
        <input type="submit" value="修改">
    </form>
</center>
</body>
</html>
