<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
</head>
<body class="frame-bd">
<input type="hidden" name="power" value="${power}">
	<ul class="left-menu">
		<div name="id"><li><a href="/BookList.action" target="mainFrame" name=""><img
				src="images/btn_bill.gif" /></a>
		</li></div>

		<!--<li><a href="providerList.html" target="mainFrame"><img
				src="images/btn_suppliers.gif" />
		</a>
		</li>-->
		<li><a href="/BookList2.action" target="mainFrame" name=""><img
				src="images/btn_jieyue.gif" />
		</a>
		</li>
		<div name="id">
        <li><a href="/UserList.action" target="mainFrame" name="userlist"><img
				src="images/btn_users.gif" />
		</a>
		</li>
		</div>
		<li><a href="updatePwd1.jsp" target="mainFrame" name="update"><img
				src="images/btn_password.gif" />
		</a>
		</li>
		<li><a href="#" onclick="out()"><img
				src="images/btn_exit.gif" />
		</a>
		</li>
	</ul>
<script type="text/javascript">
	$(function () {
		console.log($("input[name=power]").val())
		if ($("input[name=power]").val()=="普通用户"){
			$("div[name=id]").prop("style","display: none")
		}
	})
    function out() {
        top.location="/outSystem.action"
    }
</script>
</body>
</html>
