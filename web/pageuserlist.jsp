<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function doDelete(id) {
            var flag = confirm("确认删除?");
            if (flag) {
                location.href="DeleteServlet?id=" + id;
            }
        }
    </script>
</head>
<body>
<center>
    <form action="FindServlet" method="post">
        <table border="1" width="800px">
            <tr >
                <td colspan="7">
                    姓名: <input type="text" name="uname">&nbsp;&nbsp;
                    姓别: <input type="text" name="usex">&nbsp;&nbsp;
                    <input type="submit" value="查询" >&nbsp;&nbsp;
                    <a href="addUser.jsp">添加</a>
                </td>
            </tr>
            <tr align="center">
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>电话</td>
                <td>住址</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${page.lists}" var="user">
                <tr align="center">
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.sex}</td>
                    <td>${user.age}</td>
                    <td>${user.phone}</td>
                    <td>${user.address}</td>
                    <td>
                        <a href="EditServlet?id=${user.id}">更新</a>
                        <a href="#" onclick="doDelete(${user.id})" >删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7">
                    第${page.currPage} / ${page.totalPage}页 &nbsp;&nbsp;
                    每页显示 &nbsp; ${page.pageSize}条 &nbsp;&nbsp;
                    总记录数 &nbsp;${page.totalCount} &nbsp;&nbsp;

                    <c:if test="${page.currPage != 1}">
                        <a href="UserPageServlet?currPage=1">首页</a>
                    |   <a href="UserPageServlet?currPage=${page.currPage - 1} >上一页</a>
                    </c:if>

                    <c:forEach begin="1" end="${page.totalPage }" var="i">
			  			<c:if test="${page.currPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${page.currPage != i }">
			  				<a href="UserPageServlet?currPage=${i }"> ${i } </a>
			  			</c:if>
			  		</c:forEach>

                    <c:if test="${page.currPage != page.totalPage}">
                      <a href="UserPageServlet?currPage=${page.currPage + 1}">下一页</a>
                    | <a href="UserPageServlet?currPage=${page.totalPage} ">尾页</a>
                    </c:if>
                </td>
            </tr>

        </table>
    </form>
</center>
</body>
</html>
