<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../base/taglibs.jsp"%>
<%
	String path = request.getContextPath();
%>
<base href="<%=path%>/">
	<title>仲裁委后台管理-添加仲裁员</title>
    <link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/numberCount.css"/>
    <link rel="stylesheet" href="static/css/userIndex.css"/>
                
                <div class="zhong-right z-bg-fff changepsd min-height450" style="padding: 20px;">
                    <h3>添加仲裁员</h3>
                    <form class="addreferee" id="form0" method="post" enctype="multipart/form-data">
                        <label class="label">
                            <span>姓名</span>
                            <input id="btn2" class="input" type="text" placeholder="请输入姓名" />
                        </label>
                        <label class="label">
                            <span>照片</span>
                            <a class="a-commit">
                            	 请选择照片
                                <input onchange="uploadPic()" name="uploadFile" id="file0" class="file" type="file" placeholder="请选择照片" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg"/>
                            </a>
                            <img src="" alt="" id="img0" style="width: 100px;height: 100px;">
                        </label>
                        <p class="colorred changepsd-form-tips">请上传jpg/png/jepg文件，文件大小不超过3M</p>
                        <label class="label">
                            <span>出生年月</span>
                            <input id="birthday" class="input form-control search-input createTime" type="text" placeholder="请选择出生年月" class="form-control search-input createTime"/>
                        </label>
                        <label class="label">
                            <span>职业</span>
                           	<input id="btn3" class="input" type="text" placeholder="请输入职业" />
                        </label>
                        <label>
                        	<span>专长</span>
                        	<input id="btn5" class="input" type="text" placeholder="如：合同法，公司法，民商法" />
                        </label>
                        <label class="label">
                            <span>居住地</span>
                            <select id="s_province"></select>
  							<select id="s_city"></select>
  							<span id="error" style="color:red;width:150px;"></span>
                        </label>
                        <label class="label">
                            <span>手机号</span>
                            <input id="btn4" class="input" type="text" placeholder="请输入手机号" maxlength="11" />
                            <span id="errorInfo" style="color:red;width:150px;"></span>
                        </label>
                        <p class="colorred changepsd-form-tips">账号初始密码为手机号码后6位数字</p>
                        <input readonly="readonly" id="btn1" value="确认" class="seek-btn bg475" style="margin: 40px 20px 10px 10px;">
                        <input readonly="readonly" value="取消" class="seek-btn bg475" style="margin: 40px 20px 10px 0;">

                    </form>
                </div>
    

<script src="static/vendor/jquery-2.1.1.min.js"></script>
<script src="static/vendor/laydate/laydate.js"></script>
<script class="resources library" src="static/js/area.js" type="text/javascript"></script>
<script src="static/js/jquery-form.js" type="text/javascript"></script> 

<script type="text/javascript">
	function uploadPic() {
		//校验图片
		//判断图片类型
	    var filepath = $("input[name='uploadFile']").val();
        var extStart = filepath.lastIndexOf(".");
        var ext = filepath.substring(extStart, filepath.length).toUpperCase();
        if (ext != ".PNG" && ext != ".JPG" && ext != ".JEPG") {
        	layer.alert('图片限于png,jepg,jpg格式！',{icon : 2});
            return false;
        } 
      	//判断上传文件大小   
        var size = $("#file0")[0].files[0].size; 
        if(size>3145728){
        	layer.alert("图片文件过大！",{icon : 2});   
	        return false;   
        } 
		
	   	// 上传设置  
	    var options = {  
              // 规定把请求发送到那个URL  
              url: "${appCtx}/arbitrator/info/uploads",  
              // 请求方式  
              type: "post",  
              // 服务器响应的数据类型  
              dataType: "json",  
              // 请求成功时执行的回调函数  
              success:function(data) {  
            	  	var retCode = data.head.retCode;
					var msg = data.head.msg;
					var body = data.body;
					if (retCode == '0000') {
						$("#file0").attr("headphoto",body);
						layer.alert('头像上传成功！',{icon : 1});
					}
              },
              error : function(data) {
					layer.alert('操作失败！',{icon : 2});
			  }
	      };
	      $("#form0").ajaxSubmit(options);
	  }

	//调用省市联动
	_init_area();
	
	//添加仲裁员
	$(function(){
		$("#btn1").click(function(){
			var name = $("#btn2").val();
			var headphoto = $("#file0").attr("headphoto");
	    	var birthday = $("#birthday").val();
	    	var vocation = $("#btn3").val();
	        var specialty = $("#btn5").val();
	        
	        if($("#s_province").val()=="--请选择省--" || $("#s_city").val()=="--请选择市--"){
	        	$("#error").html("不能为空！");
	        	return;
	        }else{
	        	var address = $("#s_province").val()+$("#s_city").val();
	        }
	    	
	    	var phone = $("#btn4").val();
	    	var reg = /^1[0-9]{10}$/;
	    	if(phone==""){
	    		$("#errorInfo").html("手机号不能为空！");
	    		return;
	    	}else if(!reg.test(phone)){
	    		$("#errorInfo").html("手机号格式输入有误！");
	    		return;
	    	}
	    	
	    	$.ajax({
				url : "${appCtx}/arbitrator/info/addreferee",
				type : "POST",
				data : {
					'name':name,
					'headphoto':headphoto,
	        		'birthday':birthday,
	        		'vocation':vocation,
	        		'specialty':specialty,
	        		'address':address,
	        		'phone':phone
				},
				success : function(data) {
					var retCode = data.head.retCode;
					var msg = data.head.msg;
					if (retCode == '0000') {
						location.href = "${appCtx}/arbitrator/administer";
					} else {
						layer.msg("用户已存在");
					}
				},
				error : function(data) {
					layer.alert('添加失败！',{icon : 2});
				}
			});
		})
	})

	$("#file0").change(function(){
	    var objUrl = getObjectURL(this.files[0]) ;
	    if (objUrl) {
	        $("#img0").attr("src", objUrl) 
	    }
	});
	//建立一個可存取到該file的url
	function getObjectURL(file) {
	    var url = null ;
	    if (window.createObjectURL!=undefined) { // basic
	        url = window.createObjectURL(file) ;
	    } else if (window.URL!=undefined) { // mozilla(firefox)
	        url = window.URL.createObjectURL(file) ;
	    } else if (window.webkitURL!=undefined) { // webkit or chrome
	        url = window.webkitURL.createObjectURL(file) ;
	    }
	    return url ;
	}
	
	laydate({
	    elem: '#birthday',
	    format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
	    festival: true, //显示节日
	    choose: function(datas){ //选择日期完毕的回调
	        //console.log('得到：'+datas);
	    }
	}); 
    
</script>
