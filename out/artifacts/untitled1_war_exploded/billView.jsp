<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js">

</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">圖書管理&gt;&gt;</div>
	</div>
		<div class="content">
			<table class="box">
			  <tbody><tr>
					<td class="field">圖書编号：</td>
					<td>${book.id}<input type="hidden" id="billId" value="${book.id}"></td>
				</tr>
			   <tr>
					<td class="field">书籍名称：</td>
					<td>${book.name}</td>
				</tr>
				 <tr>
					<td class="field">作者：</td>
					<td>${book.author}</td>
				</tr>
			   <tr>
					<td class="field">出版社：</td>
					<td>${book.publisher}</td>
				</tr>
				 <tr>
					<td class="field">是否借出：</td>
						<td>
							 ${book.lend}
						</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="button" name="update" id="update" value="修改" class="input-button">
			<input type="button" name="del" id="del" value="删除" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>
</div>
<script type="text/javascript" src="js/bill/view.js"></script>


</body></html>