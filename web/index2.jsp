<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
<%--    <script type="text/javascript">
        function check() {
            var name = document.getElementById("username");
            var passwd = document.getElementById("password");
            alert(name)
            if ("aaa" == name && "zzz" == passwd) {
                window.alert("登录成功！！")
                //location.href="success.jsp";
            }
            else {
                window.alert("登录失败！！")
            }
        }

    </script>--%>
</head>
<body>
    <form method="post" action="/LoginServlet">
        name:<input type="text" id="username" name="name"><br>
        passwd:<input type="password" id="password" name="passwd" ><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
