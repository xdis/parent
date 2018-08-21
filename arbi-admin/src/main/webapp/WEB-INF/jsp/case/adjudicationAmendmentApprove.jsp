<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
<link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css" />
<link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>

<div class="case-main clearfix">

    <div class="center-center fl">
        <div class="unCasecheck mgt60">
        	<div>
	            <h4 class="h4-title">裁决书补正申请书</h4>
	            <div class="case-main-text clearfix">
	            	<p>珠海仲裁委员会：</p>
	                <p>关于贵会作出的${amendmentVO.caseBaseInfo.caseNo}裁决书，我方提出如下补正申请： </p>
	                <p>理由是：</p>
	                <p>${amendmentVO.adjudicationAmendentRecord.factReason}</p>
	                <p>此致</p>
	                <p>珠海仲裁委员会</p>
	                <p style="text-align: right">${amendmentVO.caseBaseInfo.applicantName}</p>
	                <p style="text-align: right">${amendmentVO.adjudicationAmendentRecord.createTime}</p>
	             </div>
             </div>
             <div>
	             <h4 class="h4-title">珠 海 仲 裁 委 员 会</h4>
	             <h3>补正裁决书</h3>
	             <p style="text-align: right">${amendmentVO.caseBaseInfo.caseNo}</p>
	             <p>申请人：${amendmentVO.caseBaseInfo.applicantName}</p>
	             <p>被申请人：${amendmentVO.caseBaseInfo.beApplicantName}</p>
	             <p>本会受理的${amendmentVO.caseBaseInfo.caseNo}案，已于${amendmentVO.caseNo}作出裁决，现查明该裁决书中存在$-{amendmentVO.???}的错误，应予补正。</p>
	             <br>
	             <p>依照《中华人民共和国仲裁法》第五十六条规定，裁决如下：</p>
	             <p>${amendmentVO.caseDocContent.finalDecision}</p>
	             <p>本裁决补正书为裁决书的一部分，自作出之日起发生法律效力。</p>
	             <br>
	             <p>（此页无正文）</p>
	             <p style="text-align: right">仲  裁  员：${amendmentVO.caseDocContent.arbitratorName}</p>
	             <p style="text-align: right">${amendmentVO.caseDocContent.createTime}</p>
	             <p style="text-align: right">秘     书：${amendmentVO.caseDocContent.arbiSecretaryName}</p>
             </div>
             <div>
                 <button class="mgt100 one-center">预览</button>
                 <button class="mgt20 one-center">保存草稿</button>
                 <button class="mgt20 one-center">出具裁决补正书</button>
             </div>
         </div>
     </div>

     <div class="center-right fr none">
         <h5>裁决补正记录</h5>
         <div class="pad16 commot-record-right">
         	<c:forEach items="${amendmentVO.adjudicationAmendentHistoryRecords}" var="historyAmendmentRecord" varStatus="status">
         		<c:choose>
         			<c:when test="${status.index%2 == 0}">
         				<div class="commit-left">
				            <p class="commit-left-time"><fmt:formatDate value="${historyAmendmentRecord.createTime}" pattern="yyyy-MM-dd"/> <c:if test="${historyAmendmentRecord.requestType == '1'}">被</c:if>申请方补正内容</p>
				            <p class="commit-left-text">${historyAmendmentRecord.content}</p>
				            <c:choose>
				            	<c:when test="${historyAmendmentRecord.status == '1'}">
				            		<img src="${appCtx}/static/img/agree.png">
				            	</c:when>
				            	<c:otherwise>
				            		<img src="${appCtx}/static/img/disagree.png">
				            	</c:otherwise>
				            </c:choose>
	             		</div>
         			</c:when>
         			<c:otherwise>
         				<div class="commit-right clearfix">
			                <p class="commit-left-time"><fmt:formatDate value="${historyAmendmentRecord.createTime}" pattern="yyyy-MM-dd"/> <c:if test="${historyAmendmentRecord.requestType == '1'}">被</c:if>申请方补正内容</p>
				            <p class="commit-left-text">${historyAmendmentRecord.content}</p>
				            <c:choose>
				            	<c:when test="${historyAmendmentRecord.status == '1'}">
				            		<img src="${appCtx}/static/img/agree.png">
				            	</c:when>
				            	<c:otherwise>
				            		<img src="${appCtx}/static/img/disagree.png">
				            	</c:otherwise>
				            </c:choose>
		            	</div>
         			</c:otherwise>
         		</c:choose>
         	</c:forEach>
         </div>
     </div>
     <!--审批记录-->
     <div class="approvel-record mgt80">
        <p>审批</p>
       	<c:if test="${fn:length(amendmentVO.caseApproveSuggests) > 0}">
       		<div>
		       	<p class="approvel-record-title">审批记录</p>
		        <ul>
		         	<c:forEach var="approve" items="${amendmentVO.caseApproveSuggests}">
		         		<li>
		                  <p>
		                  	<c:choose>
		                  		<c:when test="${approve.suggestUserDuties == '2'}">仲裁秘书</c:when>
		                  		<c:when test="${approve.suggestUserDuties == '3'}">仲裁部长</c:when>
		                  		<c:when test="${approve.suggestUserDuties == '4'}">主任</c:when>
		                  		<c:when test="${approve.suggestUserDuties == '5'}">副主任</c:when>
		                  	</c:choose>
		                  	${approve.approverName}审核意见：
		                  	<span class="right"><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${approve.createTime}"/></span>
		                  </p>
		                  <p class="pdl50">${approve.approveSuggest}</p>
		              </li>
		         	</c:forEach>
		        </ul>
		    </div>
        </c:if>
        <div>
            <p class="approvel-record-title">审批意见</p>
			<textarea class="first-comments" style="width:900px" id="approveSuggest" placeholder="最多可输入500个字符"></textarea>
			<p class="detail-date"></p>
        </div>
        <div class="bottom-button">
           	<c:choose>
         		<c:when test="${amendmentVO.currentDuties=='2'}">
            		<button id="btn1" onclick="avoidanceapply()" class="avoidanceapply bg475 mgt100">申请回避</button>
        			<button id="btn3" onclick="approve()" class="submit mgt100  ">呈领导审批</button>
         		</c:when>
         		<c:otherwise>
            		<button id="btn1" onclick="suggest()" class="advise bg475 mgt100">反馈修改意见</button>
           			<button id="btn2" onclick="pass()" class="pass bg475 mgt100">通过</button>
         		</c:otherwise>
         	</c:choose>
         </div>
     </div>
</div>
