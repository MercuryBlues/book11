<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-账单管理</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js">
	</script>
</head>
<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="/BookList.action">
							<input name="method" value="query" class="input-text" type="hidden"> 
							书籍名称：<input name="name" class="input-text" type="text" value="${searchName}">
							作者：<input name="author" class="input-text" type="text" value="${searchAuthor}">
							是否借出：<input type="radio" name="lend" value="是">是
						<input type="radio" name="lend" value="否">否-
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加图书" class="input-button" onclick="window.location='billAdd.jsp'" type="button">
			</em>
			<div class="title">图书管理</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">图书编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">书籍名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">作者</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">出版社</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">是否借出</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">图书管理</div>
						</td>
						
						<td width="100"><div class="STYLE1" align="center">借阅人</div>
						</td>
					</tr>
					<c:forEach items="${pageInfo.list}" var="book">
					<tr>
						<td height="23"><span class="STYLE1">${book.id}</span></td>
						<td><span class="STYLE1" ><a href="/getBookByid.action?id=${book.id}" style="color:red" >${book.name}</a></span></td>
						<td><span class="STYLE1"> ${book.author}</span></td>
						<td><span class="STYLE1"> ${book.publisher}</span></td>
						<td><span class="STYLE1"> ${book.lend}</span></td>
						<td collapse=2>
							<a href="/deleteBook.action?name=${searchName}&id=${book.id}"><em><input value="删除" class="input-button" onclick="" type="button"></em></a>
							<a href="/selectById.action?id=${book.id}"><em><input value="修改" class="input-button" name="modify" onclick="modify()" type="button"></em></a>
						</td>
						<td><span class="STYLE1">${book.lendName}</span></td>
						</c:forEach>
				</tbody>
			</table>
			<div align="center">当前页是第<span>${pageInfo.pageNum}</span>页&nbsp; 一共<span>${pageInfo.pages}</span>页
				<c:if test="${pageInfo.isFirstPage==false}">
					<a href="/BookList.action?page=${pageInfo.prePage}" >上一页</a></c:if>

				<c:if test="${pageInfo.isFirstPage==true}">上一页</c:if>
				<c:if test="${pageInfo.isLastPage==false}">
					<a href="/BookList.action?page=${pageInfo.nextPage}"> 下一页</a></c:if>

				<c:if test="${pageInfo.isLastPage==true}">下一页</c:if>
			</div>
		</div>
	</div>
<%--<script>--%>
<%--		function modify() {--%>
<%--			var id =$(this).parent().val();--%>
<%--			console.log(id)--%>
<%--			location.href="bookServlet?flag=selectById&id=";--%>
<%--		}--%>
<%--</script>--%>
</body></html>