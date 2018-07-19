<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>添加页面</h3>
    <form method="post" action="AddServlet">
       <%-- <input type="hidden" name="id" value="${user.id}"><br>--%>
        姓名:<input type="text" name="name" ><br>
        性别:<input type="text" name="sex" ><br>
        年龄:<input type="text" name="age" ><br>
        电话:<input type="text" name="phone" ><br>
        住址:<input type="text" name="address" ><br>
        <input type="submit" value="添加">
    </form>
</center>
</body>
</html>
