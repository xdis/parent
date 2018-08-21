<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/peoplecompromise.css"/>


              <div class="z-right-box z-bg-fff">
                <div class="case-main">
                    <c:if test="${not empty comproiseApplyVO}">

                          <div class="compromise-list">
                                <p class="compromise-list-p">
                                  <i class="com-i"></i>
                                  <span class="com-time"><fmt:formatDate value="${comproiseApplyVO.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                  <span class="com-content">申请人${comproiseApplyVO.propName} 申请和解</span>
                                </p>

                                <p class="compromise-list-p">
                                  <i class="com-i"></i>
                                  <span class="com-time"><fmt:formatDate value="${comproiseApplyVO.otherOperatingTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                  <span class="com-content">被申请人${comproiseApplyVO.defeName}
                                        <c:if test="${comproiseApplyVO.defeOpinion=='0'}">
                                            同意和解
                                        </c:if>

                                        <c:if test="${comproiseApplyVO.defeOpinion=='1'}">
                                            拒绝和解
                                        </c:if>
                                  </span>
                                </p>

                                <c:if test="${!empty comproiseApplyVO.managerOpinion}">
                                    <p class="compromise-list-p">
                                      <i class="com-i"></i>
                                      <span class="com-time"><fmt:formatDate value="${comproiseApplyVO.managerOperatingTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                      <span class="com-content">
                                            仲裁秘书
                                                ${comproiseApplyVO.managerName}
                                            <c:if test="${comproiseApplyVO.managerOpinion=='0'}">
                                                同意和解
                                            </c:if>

                                            <c:if test="${comproiseApplyVO.managerOpinion=='1'}">
                                                拒绝和解
                                            </c:if>
                                      </span>
                                    </p>
                                </c:if>
                          </div>
                          <div class="con-btn" style="margin-top: 60px;" >
                              <c:if test="${empty comproiseApplyVO.managerOpinion && comproiseApplyVO.auditType=='0'}">
                                <c:if test="${comproiseApplyVO.isApplyAvoid==1}">
                                  <button class="seek-btn border-475" onclick="applyApprove();">申请回避</button>
                                </c:if>
                                  <button class="seek-btn border-475 mgl60" id="refuse">拒绝</button>
                                  <button class="seek-btn bg475 mgl60" id="agree">同意</button>
                              </c:if>
                          </div>

                    </c:if>
                </div>
					<!-- 和解沟通记录 -->                  
	                  <div class="case-main" id="case-main">
                        </div>
                        
                        
                        <!-- 调解申请记录 -->
                        <div class="case-main" id="protocolRecord">
                        </div>
                        
              </div>
          <div class="textarea" style="display: none">
              <textarea style="margin: 0px; width:399px; height: 159px;"></textarea>
              <button id="submit">提交</button>
              <button id="cancel">取消</button>
          </div>
          
          <div class="agreeApply" style="display: none">
              <input type="text" id="startTime" placeholder="请输入开始时间" />
              <button id="applySubmit">提交</button>
              <button id="applyCancel">取消</button>
          </div>
<script>
	$(function(){
		var arbiSecretariesName;
		
		laydate({
	        elem: '#startTime',
	        format: 'YYYY-MM-DD hh:mm:ss', // 分隔符可以任意定义，该例子表示只显示年月
	        festival: true, //显示节日
	        istime: false, //显示时间选项 
	        choose: function(datas){ //选择日期完毕的回调
	            //console.log('得到：'+datas);
	        }
	    });
		
		 laydate.skin('molv');
		//拒绝和解
		$("#refuse").click(function(){
			$.ajax({
				type:'post',  
                url:'${appCtx}/compromise/apply/refuse',  
                dataType:'json',  
                data:{applyId:'${comproiseApplyVO.applyId}'},  
                success:function(json){  
                    if(json.head.retCode == '0000'){  
                        //成功 
                        location.reload();
                    }else{  
                        //出错  
                    	layer.alert(json.head.msg, {
                            skin: 'layui-layer-lan' //样式类名
                            ,closeBtn: 0
                        });  
                    }  
                }  
			});
		});
		
		
		//取消
		$("#cancel").click(function(){
			layer.closeAll();	
		});
		
		//同意和解弹出遮罩层
		$("#agree").click(function(){
			layer.open({
				title:"请选择和解时间",
				type: 1,
				skin: 'layui-layer-rim', //加上边框
				area: ['420px', '240px'], //宽高
				offset:'60px',
				content: $(".agreeApply")
			});
		});
		
		//同意申请
		$("#applySubmit").click(function(){
			$.ajax({
				type:'post',  
                url:'${appCtx}/compromise/apply/agree',  
                dataType:'json',  
                data:{
	                	applyId:'${comproiseApplyVO.applyId}',
	                	startTime:$("#startTime").val(),
	                	caseId:'${comproiseApplyVO.caseId}'
                	},  
                success:function(json){  
                    if(json.head.retCode == '0000'){  
                        //成功 
                        location.reload();
                    }else{  
                        //出错  
                    	layer.alert(json.head.msg, {
                            skin: 'layui-layer-lan' //样式类名
                            ,closeBtn: 0
                        });  
                    }  
                }  
			});
		})
		
		//取消申请
		$("#applyCancel").click(function(){
			layer.closeAll();
		})

			var isApplyAvoid='${comproiseApplyVO.isApplyAvoid}';
			//加载和解沟通记录
			$.ajax({
				type:'post',
	            url:'${appCtx}/compromise/record/${comproiseApplyVO.caseId}',
	            dataType:'json',
	            async:false,
	            success:function(json){
	                if(json.head.retCode == '0000'){
	                    //成功
	                    //location.reload();
	                    var data=json.body;
	                    if(data){
	                    	var html='';
		                    html+='<h3>和解沟通记录</h3><div  class="z-room"><div id="chatroom" class="text-room">';
		                    $.each(data,function(i,o){

		                    	//发送方是申请人
		                    	if(o.senderType=='0'){

		                    		var propName='';
		                    		if(o.propAgentName){
		                    			propName='委托代理人  '+o.propAgentName;
		                    		}else{
		                    			propName='申请人  '+o.propName;
		                    		}

		                    		html+='<div class="z-text-box"> <p class="z-text-p">'
		                    				+'<span>'+propName+' </span>'
		                    				+'<span>'+o.createTime+'</span></p>'
		                    				+'<div class="z-text">'
		                    				+o.content+' </div></div>';

		                    	}else if(o.senderType=='1'){//发送方是被申请人

		                    		var defeName='';
		                    		if(o.propAgentName){
		                    			defeName='委托代理人  '+o.defeAgentName;
		                    		}else{
		                    			defeName='被申请人  '+o.defeName;
		                    		}

		                    		html+='<div class="z-text-box"> <p class="z-text-p">'
		                    				+'<span>'+defeName+' </span>'
		                    				+'<span>'+o.createTime+'</span></p>'
		                    				+'<div class="z-text">'
		                    				+o.content+' </div></div>';


		                    	}else{//发送人是仲裁秘书

		                    		arbiSecretariesName='仲裁秘书  '+o.arbiSecretariesName;
		                    		html+='<div class="z-text-box"> <p class="z-text-p">'
		                    				+'<span>'+arbiSecretariesName+' </span>'
		                    				+'<span>'+o.createTime+'</span></p>'
		                    				+'<div class="z-text">'
		                    				+o.content+' </div></div>';

		                    	}


		                    	if(o.auditType=='0'){
                                    html+='</div><div class="z-textarea" id="z-textarea">'
                                        +'<textarea></textarea>'
                                        +'<button onclick="sendRecord();">发送</button>'
                                        +'</div></div>';
                                }else{
                                    html+='</div><div class="z-textarea" id="z-textarea">'
                                        +'<textarea></textarea>'
                                        +'</div></div>';
                                }

		                    });
                            if(isApplyAvoid==1){
		                    	html+='<button class="z-shenback" onclick="applyApprove();">申请回避</button>';
		                    }
		                    $("#case-main").html(html);
	                    }

	                }
	            },
                error:function(){
                    //出错
                    layer.alert('系统异常', {
                        skin: 'layui-layer-lan' //样式类名
                        ,closeBtn: 0
                    });
                }
			});


			//加载调解申请
			 $.ajax({
				type:'post',  
	            url:'${appCtx}/case/protocolRecord/${comproiseApplyVO.caseId}',
	            dataType:'json',  
	            async:false,
	            success:function(json){  
	                if(json.head.retCode == '0000'){  
	                    //成功 
	                    //location.reload();
	                    console.log(json.body);
	                    var data=json.body;
	                    if(data){
	                    	
	                    	$("#z-textarea").remove();
	                    	var html='';
		                    html+='<h3>当事人已请求出具调解书</h3><div  class="z-room"><div id="chatroom" class="text-room">';
		                    html+='<div class="z-text-box">'
                				+'<div class="z-text">'
                				+data.protocolContent+' </div></div></div></div>';
		                    
		                    
		                    if(isApplyAvoid==1){
		                    	html+='<button class="z-shenback" onclick="applyApprove();">申请回避</button>';
		                    }
		                    
		                    $("#protocolRecord").html(html);
	                    }
	                    
	                }
	            },
                error:function(){
                    //出错
                    layer.alert('系统异常', {
                        skin: 'layui-layer-lan' //样式类名
                        ,closeBtn: 0
                    });
                }
			}); 
	});
	
	
	//弹出回避遮罩层
	 function applyApprove(){
		 layer.open({
				title:"请陈述回避理由",
				type: 1,
				skin: 'layui-layer-rim', //加上边框
				area: ['420px', '240px'], //宽高
				offset:'60px',
				content: $(".textarea")
			});
	 }
	
	
	//发送和解申请
	function sendRecord(){
		$.ajax({
			type:'post',  
            url:'${appCtx}/compromise/record/sender',  
            dataType:'json',  
            data:{
            		caseId:'${comproiseApplyVO.caseId}',
            		content:$("#record").val(),
            		senderType:"2"//2- 仲裁秘书
            	},  
            success:function(json){  
                if(json.head.retCode == '0000'){  
                    //成功 
                    location.reload();
                }else{  
                    //出错  
                	layer.alert(json.head.msg, {
                        skin: 'layui-layer-lan' //样式类名
                        ,closeBtn: 0
                    });  
                }  
            }  
		}); 
	}
</script>