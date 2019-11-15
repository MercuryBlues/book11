<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" action="/updateuser.action" enctype="multipart/form-data">
		<input type="hidden" name="method" value="update">
		<div class="content">
			<font color="red"></font><table class="box">
			<tbody><tr>
					<td class="field" name="id">用户编号：${user.id}</td>
					<td><input type="hidden" name="id" value="${user.id}"></td>
				</tr>
			<tr>
				<td>头像</td>
				<td><img src="/pic/value=${user.headpath}"><input type="file" name="pictureFile"></td>
			</tr>
			<tr>
					<td class="field">用户名：</td>
					<td><input type="text" name="name" class="text" id="name" value="${user.name}"> <font color="red">*</font><font color="red" id="name_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户性别：</td>
					<td><select name="sex" id="gender">
						    <option value="男" checked="">男</option>
						    <option value="女">女</option>
						 </select></td>
				</tr>
				<tr>
					<td class="field">出生日期：</td>
					<td><input type="text" name="birth" class="text" id="birthDate" value="${user.birth}"> <font color="red">*</font><font color="red" id="birthDate_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="tel" class="text" id="phone" value="${user.tel}"> <font color="red">*</font><font color="red" id="phone_span"></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><input name="home" id="address" class="text" value="${user.home}"></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="power" value="管理员">管理员<input type="radio" name="power" value="普通用户" checked="true">普通用户
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="update" id="update" value="修改" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
<script type="text/javascript" src="js/user/update.js"></script>


</body></html>