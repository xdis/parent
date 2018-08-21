<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<%@include file="../base/taglibs.jsp" %>
    
    <link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/userIndex.css"/>

    <link rel="stylesheet" href="${appCtx}/static/js/plugin/page/css/reset.css" />
	<link rel="stylesheet" href="${appCtx}/static/js/plugin/page/css/pagination.css" />

<style>
	.hover_s{
		color: #D3D3D3;
	}
</style>

                <div class="zhong-right z-bg-fff min-height450" style="padding: 35px;">
                    <ul class="message-center" id="ul0">
	                    <c:if test="${messageList != null }">
		                    <c:forEach items="${messageList.list }" var="message" varStatus="vs">
		                        <c:if test="${message.status == 1}">
			                        <li class="hover_s">
			                        	<p style="font-size: 10px;">
			                        		<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${message.createTime }"/>
			                        	</p>
			                        	<br>
			                            <p>
			                                <span style="font-size: 15px;">&emsp;&emsp;【${message.title }】${message.messageBody }</span>
			                                <span id="btn${vs.count }" onclick="btn(${vs.count })" messageId=${message.id } class="lightblue right detail">查看详情</span>
			                            </p>
			                        </li>
		                        </c:if>
		                        <c:if test="${message.status == 0}">
			                        <li>
			                        	<p style="font-size: 10px;">
			                        		<img class="img" style="width: 10px;padding:3px 0;" src="${appCtx}/static/img/u1180.png">&emsp;
			                        		<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${message.createTime }"/>
			                        	</p>
			                        	<br>
			                            <p>
			                                <span style="font-size: 15px;">&emsp;&emsp;【${message.title }】${message.messageBody }</span>
			                                <span id="btn${vs.count }" onclick="btn(${vs.count })" messageId=${message.id } class="lightblue right detail">查看详情</span>
			                            </p>
			                        </li>
		                        </c:if>
		                    </c:forEach>
	                    </c:if>
                    </ul>
                </div>
                
                <!-- 分页导航条 -->
                <div class="pages">
			    	<div class="pmain">
				        <div id="Pagination" class="flickr"></div>
				        <div class="searchPage">
				          <span class="page-sum">共<strong class="allPage">${messageList.pages}</strong>页</span>
				          <span class="page-go">到第<input type="text" value="${messageList.pageNum}">页</span>
				          <a href="javascript:;" class="page-btn">确定</a>
				        </div>
			        </div>
			    </div>
			    
<script type="text/javascript" src="${appCtx}/static/js/plugin/page/lib/jquery.min.js"></script>
<script type="text/javascript" src="${appCtx}/static/js/plugin/page/jquery.pagination.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
	    $("#Pagination").pagination("${messageList.pages}",{
			current_page:'${messageList.pageNum*1-1}', //当前页码,页码编号从0开始
			//load_first_page:true,//插件加载时是否回调当前页码
	        callback:function(current_page){
	            //回调函数,当前页码为current_page，页码编号从0开始
	            console.log(current_page)
	            <%--var parmList = "?pageNum="+(current_page+1)+"&pageSize=${messageList.pageSize}";--%>
	            <%--location.href = "${appCtx}/numberCount/myNews"+parmList;--%>
                Request.loadMain({url:"numberCount/myNews",params:'pageNum='+(current_page+1)+'&pageSize=${messageList.pageSize}'});
	        }
		});
	});

	//获取消息详情
	function btn(i){
		var id = $("#btn"+i).attr("messageId");
        Request.loadMain({url:"numberCount/"+id+"/get"});
	}
	
</script>
