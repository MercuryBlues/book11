//跳转修改页面
$("#update").bind("click",function(){
	var userId=$("#userId").val();
	location.href="/getUserByid2.action?id="+userId;
});
//删除
$("#del").bind("click",function(){
	var userId=$("#userId").val();
		if(confirm("确认删除？")){
			location.href="/deleteUserByid.action?id="+userId;
		}
});
//重置密码
$("#repassword").bind("click",function(){
	var userId=$("#userId").val();
	if(confirm("确认重置密码？")){
	}
});
