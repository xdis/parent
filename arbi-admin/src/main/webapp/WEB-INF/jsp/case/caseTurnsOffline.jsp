<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%
	String path = request.getContextPath();
%>
<base href="<%=path%>/">
    
    <title>案件转线下申请</title>
    <link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/numberCount.css"/>
    <link rel="stylesheet" href="static/css/userIndex.css"/>

           <div class="zhong-right z-bg-fff min-height450" style="padding: 35px;">
           	   <h3>案件转线下申请</h3>
           	   <div>
	           	   <span>原因：</span>
	               <label class="label">
	                   <textarea id="btn1" class="role-describe" style="width: 769px;height: 88px;" placeholder=""></textarea>
	               </label>
               </div>
               <button onclick="btn1()" class="seek-btn bg475">取消</button>
               <button onclick="btn2()" class="seek-btn bg475">提交</button>
           </div>
           
<script type="text/javascript">
	function btn2() {
		layer.open({
			title : false,
			content : '案件转线下申请呈上级领导审批，确认提交？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
				var caseId = "${caseId}";
				var cause = $("#btn1").val();
				$.ajax({
					url : "${appCtx}/case/turns/offline/applyfor",
					type : "POST",
					dataType : 'json',
					data : {
						'caseId' : caseId,
						'cause' : cause
					},
					success : function(data) {
						var retCode = data.head.retCode;
						var msg = data.head.msg;
						if (retCode == '0000') {
							//成功 
							location.reload();
						} else {
							//出错  
							layer.alert(msg, {
								skin : 'layui-layer-lan', //样式类名
								closeBtn : 0
							});
						}
					}
				})
			}
		})
	}
</script>
