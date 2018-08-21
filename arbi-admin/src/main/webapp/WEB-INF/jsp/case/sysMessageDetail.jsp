<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>

<link rel="stylesheet" href="${appCtx}/static/css/numberCount.css"/>
<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
<link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css"/>
<link rel="stylesheet" href="${appCtx}/static/css/userIndex.css"/>

<div class="zhong-right z-bg-fff min-height450" style="padding: 35px;">
    <h3>${messageRecordDetail.title}</h3>
    <ul class="mymessage">
        <li><span>通知对象:</span><span>
            <c:if test="${messageRecordDetail.releaseType==0}">全部</c:if>
            <c:if test="${messageRecordDetail.releaseType==1}">申请人</c:if>
            <c:if test="${messageRecordDetail.releaseType==2}">被申请人</c:if>
            <c:if test="${messageRecordDetail.releaseType==3}">代理人</c:if>
            <c:if test="${messageRecordDetail.releaseType==4}">仲裁员</c:if>
        </span></li>
        <li><span>发布时间:</span><span><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${messageRecordDetail.createTime}"/></span></li>
        <li><span>正文:</span><span>${messageRecordDetail.messageBody}</span></li>
        <button class="empty-btn" style="margin: 36px auto 0;display: inherit;" onclick="back();">返回</button>
    </ul>
</div>
<script>
    function back(){
        Request.loadMain({url:"release/message/list"});
    }
</script>