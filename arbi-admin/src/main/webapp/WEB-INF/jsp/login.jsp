<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ include file="base/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn" ng-app="app">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="renderer" content="webkit">
	<title>仲裁委登陆</title>

	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
	<link rel="stylesheet" href="${appCtx}/static/css/login.css" />
	<style type="text/css">
		#loginBtn{
			cursor: pointer;
		}
	</style>
</head>

<body class="login-body">
<img class="login-logo" src="${appCtx}/static/img/loginlogo.png" />
<form class="login-form">
	<h3>仲裁委内部登录窗口</h3>
	<label>
		<i class="icon anticon icon-lock"></i>
		<input type="text" id="account" placeholder="请输入用户名或手机号">
	</label>
	<label>
		<i class="icon anticon icon-user"></i>
		<input type="password" id="password" placeholder="请输入密码">
	</label>
	<button class="login-button" type="button" id="loginBtn">登陆</button>
</form>
<footer class="login-footer">
	<span>版权所有@ 珠海仲裁委员会  |  未经书面协议授权禁止下载或建立镜像</span>
	<span>联系我们  |  新闻公告  |  友情链接</span>
	<span> 粤ICP备13053290号  |  粤公网安备11010502025090</span>
</footer>
</body>

</html>
<script type="text/javascript">
<!--
	$(function(){
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
				login();
		     }
		}
		$("#loginBtn").click(login);
	});
function login(){
	var account = $("#account").val();
	var password = $("#password").val();
	if(account==""){
		layer.msg("请填写帐号!");
		return;
	}
	if(password==""){
		layer.msg("请输入密码!");
		return;
	}
	$.ajax({
		headers: {
			Authorization:"Basic YnJvd3Nlcjo="
	    },
		url:"/uaa/oauth/token",
		type : "post",
		data : "scope=ui&username="+account+"&password="+password+"&grant_type=password&user_type=ARBITRATION_COMMITTEE",
		success:function(data){
			if(data.access_token){
				location = "${appCtx}/index?access_token="+data.access_token;
			}else{
				layer.msg("登录失败!");	
			}
		},
		error : function(){
			layer.msg("帐号或者密码错误!");
		}
	});
}
//-->	
</script>