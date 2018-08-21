<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
	<link rel="stylesheet" href="${appCtx}/static/css/delegate.css"/>
<p class="delegate-p">
	<span>本账号已授权代管的权限：</span>
</p>
<div class="delegate-already">
	<c:forEach items="${ownDelegateList}" var="dl">
		<p >${dl.remark}</p>
	</c:forEach>
</div>
<div class="change-delegate">

	<p class="change-delegate-p1">
		<span>将以上勾选的权限授予</span>
		<span>${delegateDuties} ${delegateName}</span>
		<span>代管</span>
	</p>
	<p class="mgtb30">
		<span>期限为</span>
		<span>${startDate}</span>至
		<span>${endDate}</span>
	</p>
	<div>
		<button class="avoidanceapply">管理授权</button>
	</div>