<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>图书管理</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js">
        // $("input[name=lend]").click(function () {
        // 	var id=$(this).parentNode.parentNode.parentNode.children[1].innerHTML;
        // 	console.log(id);
        // 	location.href="bookServlet?flag=selectById&id="+id;
        // })
    </script>
</head>
<body>

<div class="menu">

    <table>
        <tbody>
        <tr>
            <td>
                <form method="post" action="/BookList2.action">
                    <input name="method" value="query" class="input-text" type="hidden">
                    书籍名称：<input name="name" class="input-text" type="text" value="${searchName}">
                    作者：<input name="author" class="input-text" type="text" value="${searchAuthor}">
                    是否借出：<input type="radio" name="lend" value="是">是<input type="radio" name="lend" value="否">否
                    <input value="查 询" type="submit">
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="main">

    <div class="optitle clearfix">

        <div class="title">借阅管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29">
                    <div class="STYLE1" align="center">图书编号</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">书籍名称</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">作者</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">出版社</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">是否借出</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">图书管理</div>
                </td>
            </tr>
            <c:forEach items="${pageInfo.list}" var="book">
                <tr>
                    <td height="23"><span class="STYLE1">${book.id}</span></td>
                    <td><span class="STYLE1">${book.name}</span></td>
                    <td><span class="STYLE1"> ${book.author}</span></td>
                    <td><span class="STYLE1">${book.publisher}</span></td>
                    <td><span class="STYLE1" id="lend">${book.lend}</span></td>
                    <td><a href="/lend.action?bookId=${book.id}"><em>
                        <c:if test="${book.lend=='否'}"><input name="jieyue" type="button" value="借阅"
                                                              class="input-button"></c:if>
                        <c:if test="${book.lend=='是'}"><input type="button" value="借阅" class="input-button-disabled"
                                                              disabled></c:if>
                    </em></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div align="center">当前页是第<span>${pageInfo.pageNum}</span>页&nbsp; 一共<span>${pageInfo.pages}</span>页
            <c:if test="${pageInfo.isFirstPage==false}">
                <a href="/BookList2.action?page=${pageInfo.prePage}&name=${searchName}">上一页</a></c:if>

            <c:if test="${pageInfo.isFirstPage==true}">上一页</c:if>
            <c:if test="${pageInfo.isLastPage==false}">
                <a href="/BookList2.action?page=${pageInfo.nextPage}&name=${searchName}"> 下一页</a></c:if>

            <c:if test="${pageInfo.isLastPage==true}">下一页</c:if>
        </div>
    </div>
</div>
<script type="text/javascript">
</script>
</body>
</html>