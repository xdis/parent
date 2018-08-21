<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../base/taglibs.jsp"%>
<%
    String path = request.getContextPath();
%>
<base href="<%=path%>/">
<title>仲裁委后台管理-添加仲裁员</title>
<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
<link rel="stylesheet" href="${appCtx}/static/css/numberCount.css"/>
<link rel="stylesheet" href="${appCtx}/static/css/userIndex.css"/>

<div class="zhong-right z-bg-fff changepsd min-height450" style="padding: 0 20px;">
    <h3>创建账号</h3>
    <form class="changepsd-form">
        <label>
            <span><i class="colorred">*</i>账号</span><input id="account" type="text" placeholder="请输入账号">
            <span id="accountErrorInfo" style="color:red;width:150px;"></span>
        </label>
        <label>
            <span><i class="colorred">*</i>姓名</span><input id="userName" type="text" placeholder="请输入姓名">
            <span id="userNameErrorInfo" style="color:red;width:150px;"></span>
        </label>
        <label>
            <span style="width: 96px;"><i class="colorred">*</i>角色</span>
            <select class="role-select" id="duties">
                <option value="">请选择用户角色</option>
                <option value="0">立案部秘书</option>
                <option value="1">立案部部长</option>
                <option value="2">仲裁部秘书</option>
                <option value="3">仲裁部部长</option>
                <option value="5">副主任</option>
                <option value="4">主任</option>
            </select>
            <span id="dutiesErrorInfo" style="color:red;width:150px;"></span>
        </label>
        <label>
            <span><i class="colorred">*</i>手机号</span><input id="phone" type="text" placeholder="请输入手机号码">
            <span id="phoneErrorInfo" style="color:red;width:150px;"></span>
        </label>
        <label>
            <span><i class="colorred">*</i>密码</span><input id="pwd" type="password" placeholder="请输入密码">
            <span id="pwdErrorInfo" style="color:red;width:150px;"></span>
        </label>
        <label>
            <span><i class="colorred">*</i>确认密码</span><input id="confirmPwd" type="password" placeholder="请再次输入密码">
            <p class="colorred changepsd-form-tips">账号初始密码为手机号码后6位数字</p>
            <span id="confirmPwdErrorInfo" style="color:red;width:150px;"></span>
        </label>
        <input readonly="readonly" id="confirm" value="确认" class="seek-btn bg475" style="margin: 40px 20px 10px 10px;">
        <input readonly="readonly" id="cancel" value="取消" class="seek-btn bg475" style="margin: 40px 20px 10px 0;">

    </form>
</div>


<script src="${appCtx}/static/vendor/jquery-2.1.1.min.js"></script>
<script src="${appCtx}/static/vendor/laydate/laydate.js"></script>
<script src="${appCtx}/static/js/jquery-form.js" type="text/javascript"></script>

<script type="text/javascript">
    $("#phone").blur(function(){
        var phone =$("#phone").val();
        var sub=phone.substring(phone.length,phone.length-6);
        $("#pwd").val(sub);
        $("#confirmPwd").val(sub);
    })

    //添加仲裁员
    $(function(){
        $("#confirm").click(function(){
            var account = $("#account").val();
            var userName = $("#userName").val();
            var duties = $("#duties").val();
            var phone = $("#phone").val();
            var pwd = $("#pwd").val();
            var confirmPwd = $("#confirmPwd").val();

            if(account==""){
                $("#accountErrorInfo").html("账号不能为空！");
                return;
            }else{
                $("#accountErrorInfo").html("");
            }

            if(userName==""){
                $("#userNameErrorInfo").html("姓名不能为空！");
                return;
            }else{
                $("#userNameErrorInfo").html("");
            }

            if(duties==""){
                $("#dutiesErrorInfo").html("请选择角色！");
                return;
            }else{
                $("#dutiesErrorInfo").html("");
            }

            var reg = /^1[0-9]{10}$/;
            if(phone==""){
                $("#phoneErrorInfo").html("手机号不能为空！");
                return;
            }else if(!reg.test(phone)){
                $("#phoneErrorInfo").html("手机号格式输入有误！");
                return;
            }else{
                $("#phoneErrorInfo").html("");
            }

            if(pwd==""){
                $("#pwdErrorInfo").html("请输入密码！");
                return;
            }else if(pwd.length>6){
                $("#pwdErrorInfo").html("密码只能输入6位！");
                return;
            }else{
                $("#pwdErrorInfo").html("");
            }

            if(confirmPwd==""){
                $("#confirmPwdErrorInfo").html("请再次输入密码！");
                return;
            }else if(confirmPwd.length>6){
                $("#confirmPwdErrorInfo").html("密码只能输入6位！");
                return;
            }else{
                $("#confirmPwdErrorInfo").html("");
            }

            if(pwd!=confirmPwd){
                $("#confirmPwdErrorInfo").html("两次密码不一致！");
                return;
            }else{
                $("#confirmPwdErrorInfo").html("");
            }

            $.ajax({
                url : "${appCtx}/userManager/addArbiAccount",
                type : "POST",
                data : {
                    'account':account,
                    'userName':userName,
                    'duties':duties,
                    'phone':phone,
                    'pwd':pwd,
                    'confirmPwd':confirmPwd
                },
                success : function(data) {
                    var retCode = data.head.retCode;
                    var msg = data.head.msg;
                    if (retCode == '0000') {
                        Request.loadMain({url:"userManager",max:true});
                    } else {
                        layer.msg("添加失败");
                    }
                },
                error : function(data) {
                    layer.alert('系统异常！',{icon : 2});
                }
            });
        })
    })

    //取消
    $("#cancel").click(function(){
        Request.loadMain({url:"userManager",max:true});
    })

</script>
