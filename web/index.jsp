<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logining</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body background="statics/images/login-bg.jpg"
        style=" background-repeat:no-repeat ;
        background-size:100% 100%;
        background-attachment: fixed;" >
<center>
    <div id="getpicture"
         style="margin-top:20px; height:20px; width: 100%; ">
        <marquee direction="right" scrolldelay="1" behavior="alternate">疏影横斜水清浅，暗香浮动月黄昏</marquee>
    </div>
    <%--<form method="post" action="${pageContext.request.contextPath}/login.action">--%>
    <div style="margin:20px 0;">
        <h2>Welcome</h2>
    </div>
    <div class="easyui-panel"  title="zwzfOASystem" style=" width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff" method="post" action="/LoginServlet">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="name" style="width:100%"
                       data-options="label:'用户:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-passwordbox" name="passwd" style="width:100%"
                       data-options="label:'密码:',required:true">
            </div>
            <div style="text-align:center;padding:5px 0 ">
                <button type=" submit" style="background-color:darkgreen; color: white;  width:180px; height: 30px ">登录</button>
            </div>
        </form>
    </div>
</center>
</body>
</html>
