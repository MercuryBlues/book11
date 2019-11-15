<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody><tr>
						<td class="field">用户编号：${user.id}</td>
						<td><input type="hidden" id="userId" value="${user.id}"></td>
					</tr>
					<tr>
						<td>头像</td>
						<td><img src="/pic/${user.headpath}"/></td>

						<td>/pic/${user.headpath}</td>
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td>${user.name}</td>
					</tr>
					<tr>
						<td class="field">用户账号：</td>
						<td>${user.loginName}</td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>
								${user.sex}
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>${user.birth}
						</td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td>${user.tel}
						</td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td>
							${user.home}
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>

						<td>
							${user.power}
						</td>
					</tr>
				</tbody></table>
			</div>
			<div class="buttons">
				<input type="button" id="update" value="修改" class="input-button">
				<input type="button" id="del" value="删除" class="input-button"> 
				<a href="/modifyPs2.action?id=${user.id}"><input type="button" id="repassword" value="重置密码" class="input-button"> </a>
				<input type="button" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
	<script type="text/javascript" src="js/user/view.js">
	</script>


</body></html>