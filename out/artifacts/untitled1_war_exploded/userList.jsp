<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>超市账单管理系统-用户管理</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js">
        $(function () {
            $("input[type=submit]").click(function () {
                location.href = "/userServlet?flag=search";
            })
        })
    </script>
</head>
<body>
<div class="menu">
    <table>
        <tbody>
        <tr>
            <td>
                <form method="post" action="/UserList.action">
                    <input name="method" value="query" class="input-text" type="hidden"> 用户名：<input name="name"
                                                                                                    class="input-text"
                                                                                                    type="text"
                                                                                                    value="${searchName}">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input value="查询" type="submit">
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="main">

    <div class="optitle clearfix">
        <em><input value="添加用户" class="input-button" onclick="window.location='userAdd.jsp'" type="button">
        </em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29">
                    <div class="STYLE1" align="center">编号</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">用户名</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">用户账号</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">性别</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">出生日期</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">电话</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">权限</div>
                </td>
            </tr>
            <c:forEach var="user" items="${pageInfo.list}">
                <tr>
                    <td height="23"><span class="STYLE1">${user.id}</span>
                    </td>
                    <td><span class="STYLE1"> ${user.name} </span>
                    </td>
                    <td><span class="STYLE1"><a href="/getUserByid.action?id=${user.id}"> ${user.loginName}</a>
						</span>
                    </td>
                    <td><span class="STYLE1">
                            ${user.sex}
                    </span>
                    </td>
                    <td><span class="STYLE1"> ${user.birth}</span>
                    </td>
                    <td><span class="STYLE1">${user.tel}</span>
                    </td>
                    <td><span class="STYLE1">
                            ${user.power}
                    </span>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div align="center">当前页是第<span>${pageInfo.pageNum}</span>页&nbsp; 一共<span>${pageInfo.pages}</span>页
            <c:if test="${pageInfo.isFirstPage==false}">
                <a href="/UserList.action?page=${pageInfo.prePage}&name=${searchName}" >上一页</a></c:if>

            <c:if test="${pageInfo.isFirstPage==true}">上一页</c:if>
            <c:if test="${pageInfo.isLastPage==false}">
                <a href="/UserList.action?page=${pageInfo.nextPage}&name=${searchName}"> 下一页</a></c:if>

            <c:if test="${pageInfo.isLastPage==true}">下一页</c:if>
        </div>
    </div>
</div>
</body>
</html>