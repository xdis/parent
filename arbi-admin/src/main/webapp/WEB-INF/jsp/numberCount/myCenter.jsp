<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/filingAduit.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/layer.css"/>
    <link rel="stylesheet" href="${appCtx}/static/vendor/layer/mobile/need/layer.css">
<div class="zhong-right changepsd min-height450">

	<div class="changepsd-form">
	
		<label> 
			<span><i class="colorred">*</i>原密码</span>
			<input name="userPwd" id="oldpass" type="password" placeholder="请输入原始登录密码">
			<span id="oldpassTip" style="display: none; color: red;"></span>
		</label> 
		
		<label> 
			<span><i class="colorred">*</i>新密码</span>
			<input name="newUserPwd" id="newpass" type="password" placeholder="请输入新密码（6~8位数字和字母组合）">
			<span id="newpassTip" style="display: none; color: red;"></span>
		</label> 
		
		<label> 
			<span><i class="colorred">*</i>确认新密码</span>
			<input id="newpassAgain"  name="newpassAgain" type="password" placeholder="请再次输入新密码">
			<span id="newpassAgainTip" style="display: none; color: red;"></span>
		</label>
		
		
			<button class="changepsd-btn bg475" id="submit">保存修改</button>
	
			
	</div>

</div>

<script src="${appCtx}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${appCtx}/static/js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">


	$(document).ready(function() {

		var error = true;
		var errorpwd=true;
		var errornewpwd=true;
		$("#oldpass").blur(function() {

			var oldpass = $("#oldpass").val();
			if (oldpass == '') {
				showError('oldpass', '密码不能为空');
				error = true;
				return;
			} else {
				
				var patrn = /^(?=.*[0-9])(?=.*[a-zA-Z]).{6,8}$/;
				if (!patrn.exec(oldpass)) {
					showError('oldpass', '密码格式错误');
					error = true;
					return;
				} else {
					$("#oldpass").css({
						"border-color" : "green"
					});
					$("#oldpassTip").css({
						"display" : "none"
					});
					
					error=false

				}
			}

		});

		$("#newpass").blur(function() {
			var newpass = $("#newpass").val();
			if (newpass == '') {
				showError('newpass', '新密码不能为空');
				errorpwd = true;
				return;
			} else {
				var patrn = /^(?=.*[0-9])(?=.*[a-zA-Z]).{6,8}$/;
				if (!patrn.exec(newpass)) {
					showError('newpass', '新密码格式错误');
					errorpwd = true;
					return;
				} else {
					$("#newpass").css({
						"border-color" : "green"
					});
					$("#newpassTip").css({
						"display" : "none"
					});
					errorpwd = false;
				}
			}
		});

		$("#newpassAgain").blur(function() {
			var newpass = $("#newpass").val();
			if (newpass == '') {
				showError('newpass', '新密码不能为空');
				errornewpwd = true;
				return;
			}
			
			var newpassAgain = $("#newpassAgain").val();
			
			if (newpassAgain == '') {
				showError('newpassAgain', '确认新密码不能为空');
				errornewpwd = true;
				return;
			}

			var patrn = /^(?=.*[0-9])(?=.*[a-zA-Z]).{6,8}$/;
			if (!patrn.exec(newpassAgain)) {
				showError('newpassAgain', '确认新密码格式错误');
				errornewpwd = true;
				return;
			} else {

				if (newpassAgain != newpass) {
					showError('newpassAgain', '与输入的新密码不一致');
					errornewpwd = true;
					return;
				} else {
					$("#newpassAgain").css({
						"border-color" : "green"
					});
					$("#newpassAgainTip").css({
						"display" : "none"
					});
					if(!errorpwd){
						
						errornewpwd = false;
						return;
					}
					errornewpwd = true;
					return;
					
				}
			}

		});

		$("#submit").click(function(event) {
			alert(error+"--"+errornewpwd+"--"+errorpwd)
			if (!error&&!errornewpwd&&!errorpwd) {
				alert("aaaa")
				var userPwd = $("#oldpass").val();
				var newUserPwd = $("#newpass").val();
				alert(userPwd)
				$.ajax({
					type : 'post',
					url : '${appCtx}/numberCount/changeThePassword',
					dataType : 'json',
					data : {
						'userPwd' : userPwd,
						'newUserPwd':newUserPwd
						
					},
					success : function(json) {
						if (json.head.retCode == '0000') {
							layer.msg('修改成功', {icon: 1});
						} else {
							//出错  
							layer.alert(json.head.msg, {
								skin : 'layui-layer-lan' //样式类名
								,
								closeBtn : 0
							});
						}
					}
				})
			}

		});
	});

	function showError(formSpan, errorText) {
		$("#" + formSpan).css({
			"border-color" : "red"
		});
		$("#" + formSpan + "Tip").empty();
		$("#" + formSpan + "Tip").append(errorText);
		;
		$("#" + formSpan + "Tip").css({
			"display" : "inline"
		});
	}

	function showtrue(formSpan, errorText) {
		$("#" + formSpan).css({
			"border-color" : "green"
		});
		$("#" + formSpan + "Tip").empty();
		$("#" + formSpan + "Tip").append(errorText);
		;
		$("#" + formSpan + "Tip").css({
			"display" : "inline"
		});
	}
</script>


