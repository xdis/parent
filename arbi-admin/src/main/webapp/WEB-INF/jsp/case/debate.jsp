<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../base/taglibs.jsp"%>
    
	<title>辩论</title>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css" />
    <link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css" />
    <link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>

			<div class="case-main">
				<div class="unCasecheck">
				    <h4 class="h4-title">辩论记录</h4>
				</div>
				
				<!-- 辩论记录：-->
				<div class="commitrecord mgt50">
				    <div class="commitrecord-contain  mgt10">
				       <!--<p><i class="anticon icon-up"></i>展开</p>-->
			           <span style="cursor:pointer;" class="click-icon"><i class="anticon icon-down"></i><span id="show-more"> 展开</span></span>
			           	<c:forEach items="${argueRecordList}" var="argueRecord">
			           		<c:if test="${argueRecord.sendType==0}">
				           		<div class="say-right clearfix">
					               <p>申请人	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${argueRecord.createTime}"/></p>
					               <div class="say-right-contain">${argueRecord.content }</div>
					            </div>
				            </c:if>
				            
			           		<c:if test="${argueRecord.sendType==1}">
				           		<div class="say-left">
					               <p>被申请人	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${argueRecord.createTime}"/></p>
					               <div class="say-left-contain">${argueRecord.content }</div>
					            </div>
				            </c:if>
				            
				            <c:if test="${argueRecord.sendType==2}">
				           		<div class="say-left">
					               <p>仲裁员	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${argueRecord.createTime}"/></p>
					               <div class="say-left-contain">${argueRecord.content }</div>
					            </div>
				            </c:if>
			           	</c:forEach>
			       	</div>
			   	</div>
			</div>
			
<script src="${appCtx}/static/vendor/jquery-2.1.1.min.js"></script>
<script>
	$('#show-more').on('click',function (e) {
	    var _this= $(e.targrt);
	    console.log(1);
	    console.log($(this).html());
	    console.log($(this).prev());
	    if($(this).html()==" 展开"){
	        $('.commitrecord-contain').animate({'height':'550px'});
	        $(this).html(' 收起');
	        $(this).prev().addClass('icon-up').removeClass('icon-down');
	    }else{
	        $('.commitrecord-contain').animate({'height':'220px'});
	        $(this).html(' 展开');
	        $(this).prev().addClass('icon-down').removeClass('icon-up');
	    }
	})
</script>