<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" href="${appCtx}/static/css/common.css">
<link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css">
<div class="zhong-left z-bg-fff">
    <p class="z-op">仲裁信息</p>
    <div class="left-top">
        <p>案号:<span> ${caseDetail.arbiInfo.caseNo}</span></p>
        <p>立案时间:<span><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${caseDetail.arbiInfo.registerTime}"/></span></p>
    </div>
    <div class="z-info z-border">
        <div>
            <p>立案秘书: <span>${caseDetail.arbiInfo.caseSecretaryName}</span></p>
            <c:if test="${!empty caseDetail.arbiInfo.caseMinisterName}">
            	<p>立案部长: <span>${caseDetail.arbiInfo.caseMinisterName}</span></p>
            </c:if>
            <c:if test="${!empty caseDetail.arbiInfo.deputyDirectorName}">
            	<p>副主任: <span>${caseDetail.arbiInfo.deputyDirectorName}</span>
            </c:if>
            <c:if test="${!empty caseDetail.arbiInfo.directorName}">
            	<p>主任: <span>${caseDetail.arbiInfo.directorName}</span></p>
            </c:if>
        </div>
    </div>
    <c:if test="${!empty caseDetail.arbiInfo.arbiSecretaryName}">
	    <div class="z-info">
	        <div>
	        	<c:if test="${!empty caseDetail.arbiInfo.arbiSecretaryName}">
	            	<p>立案秘书: <span>${caseDetail.arbiInfo.arbiSecretaryName}</span></p>
	            </c:if>
	            <c:if test="${!empty caseDetail.arbiInfo.arbiMinisterName}">
	            	<p>立案部长: <span>${caseDetail.arbiInfo.arbiMinisterName}</span></p>
	            </c:if>
	            <c:if test="${!empty caseDetail.arbiInfo.deputyDirectorName}">
	            	<p>副主任: <span>${caseDetail.arbiInfo.deputyDirectorName}</span>
	            </c:if>
            	<c:if test="${!empty caseDetail.arbiInfo.directorName}">
            		<p>主任: <span>${caseDetail.arbiInfo.directorName}</span></p>
            	</c:if>
	        </div>
	    </div>
    </c:if>


	<p class="z-op mgt10">案件审批信息</p>
	<div class="z-info z-border" id="caseApproveInfo">
		<div>
			<c:forEach items="${caseDetail.caseApproveVoList}" var = "approveType">
				<%-- <c:if test="${approveType.primiss==0}"> --%>
				<p><span class="span-click" onclick="approve('${approveType.isMyOperation}','${approveType.approveType}','${approveType.caseId}',this);">${approveType.approveTypeName}</span></p>
				<%-- </c:if> --%>
			</c:forEach>
		</div>
	</div>
</div>

<div>
	<div class="z-right-top z-bg-fff">
		<ul class="z-pro clearfix">
			<!-- 当前进度  1-立案,2-答辩,3-审理,4-裁决,5-结案,6-补正 (String)-->


			<li class="clearfix">

				<c:if test="${caseDetail.caseProgressInfo.currentProgress<1}">
					<div class="time-show left">
						<p class="">
							<i class="">1</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">立案</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.registerCaseDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress==1}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">1</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">立案</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.registerCaseDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress>1}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">1</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">立案</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.registerCaseDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>



			</li>

			<li class="clearfix">

				<c:if test="${caseDetail.caseProgressInfo.currentProgress<2}">
					<div class="time-show left">
						<p class="">
							<i class="">2</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">答辩</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress==2}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">2</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">答辩</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress>2}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">1</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">答辩</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>

			<li class="clearfix">
				<c:if test="${caseDetail.caseProgressInfo.currentProgress<3}">
					<div class="time-show left">
						<p class="">
							<i class="">3</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">审理</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.trialDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress==3}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">3</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">审理</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.trialDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress>3}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">3</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">审理</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.trialDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>

			<li class="clearfix">
				<c:if test="${caseDetail.caseProgressInfo.currentProgress<4}">
					<div class="time-show left">
						<p class="">
							<i class="">4</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">裁决</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.arbitratorDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress==4}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">4</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">裁决</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.arbitratorDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress>4}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">4</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">裁决</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.arbitratorDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>


			<li class="clearfix">

				<c:if test="${caseDetail.caseProgressInfo.currentProgress<5}">
					<div class="time-show left">
						<p class="">
							<i class="">5</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">结案</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.completeDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress==5}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">5</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">结案</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.completeDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress>5}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">5</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">结案</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.completeDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>

			<li class="clearfix">
				<c:if test="${caseDetail.caseProgressInfo.currentProgress<6}">
					<div class="time-show left">
						<p class="">
							<i class="">6</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">补正</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.offsetDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress==6}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">6</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">补正</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.offsetDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
				</c:if>

				<c:if test="${caseDetail.caseProgressInfo.currentProgress>6}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">6</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">补正</div>
						<span>
							<fmt:parseDate value="${caseDetail.caseProgressInfo.offsetDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
				</c:if>
			</li>
		</ul>
	</div>

	<div class="z-right-box z-bg-fff">
		<div class="nav-norap">
			<div class="nav">
				<i class="icon anticon icon-left" id="icon-left"></i>
					<div class="scroll-nav"id="scroll-nav" >
						<p class="bg475">本请求</p>
						<p>本请求答辩</p>
						<p>变更请求</p>
						<p>变更请求答辩</p>
						<p>举证</p>
						<p onclick="compromiseApply('${caseDetail.caseBaseInfo.caseId}',this);">和解</p>
						<p>反请求</p>
						<p>变更反请求</p>
						<p>反请求答辩</p>
						<p>变更反请求答辩</p>
						<p>辩论</p>
						<p>裁判</p>
						<p>补正</p>
						<p class="scroll-nav-line"></p>
					</div>
				<i class="icon anticon icon-right" id="icon-right"></i>
			</div>
		</div>


		<div class="case-main">
			<div class="case-main-progress">
				<h4 class="mgt40">案件进展</h4>
				<div class="case-main-progress-detail">
					<c:forEach var="progressList" items="${caseDetail.progressList}">
						<p class="bg475 mgt37">${progressList.approveType}</p>
						<ul>
							<c:forEach var="progressCont" items="${progressList.progressCont}">
								<li><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${progressCont.time}"/>&nbsp;&nbsp;${progressCont.mark}</li>
							</c:forEach>
						</ul>
					</c:forEach>
				</div>
			</div>
			<div class="bookshow mgt87">
				<h4>仲裁申请书</h4>
				<div class="case-main-text">
					<p><span>案件编号：</span><span>${caseDetail.caseBaseInfo.caseNO}</span></p>
					<p><span>申  请  人：</span><span>${caseDetail.caseBaseInfo.applicantName}</span></p>
					<p><span>住所：</span><span>${caseDetail.caseBaseInfo.applicantAddress}</span></p>
					<c:if test="${caseDetail.caseBaseInfo.applicantType=='1'}">
						<p><span>法定代表人：</span><span>${caseDetail.caseBaseInfo.applicantCertName}</span><span>职务：</span><span>${caseDetail.caseBaseInfo.applicantCertDuties}</span></p>
					</c:if>
					<c:if test="${!empty caseDetail.caseBaseInfo.applicantAttorney}">
						<p><span>委托代理人：</span><span>${caseDetail.caseBaseInfo.applicantAttorney}，${caseDetail.caseBaseInfo.applicantAttorneyJob}</span></p>
					</c:if>
					<p><span>被申请人：</span><span>${caseDetail.caseBaseInfo.beApplicantName}</span></p>
					<p><span>住      所：</span><span>${caseDetail.caseBaseInfo.beApplicantAddress}</span></p>
					<c:if test="${caseDetail.caseBaseInfo.beApplicantType=='1'}">
						<p><span>法定代表人：</span><span>${caseDetail.caseBaseInfo.beApplicantCertName}</span><span>职务：</span><span>${caseDetail.caseBaseInfo.beApplicantCertDuties}</span></p>
					</c:if>
					<c:if test="${!empty caseDetail.caseBaseInfo.beApplicantAttorney}">
						<p><span>委托代理人：</span><span>${caseDetail.caseBaseInfo.beApplicantAttorney}，${caseDetail.caseBaseInfo.beApplicantAttorneyJob}</span></p>
					</c:if>
				</div>
				<div class="case-main-contain">
					<p>仲裁请求</p>
					<p>申请人的仲裁请求</p>
					${caseDetail.caseBaseInfo.arbClaim}
				</div>
				<div class="case-main-contain">
					<p>事实与理由</p>
					${caseDetail.caseBaseInfo.fact}
				</div>
				<div class="case-main-contain">
					<p>此致</p>
					<p>珠海仲裁委员会 </p>
				</div>
				<div class="case-main-lastname">
					<p>申请人：${caseDetail.caseBaseInfo.applicantName}</p>
					<p><fmt:formatDate pattern="yyyy年MM月dd日" value="${caseDetail.caseBaseInfo.registerTime}"/></p>
				</div>
				<div class="case-main-contain">
					<p>申请时间</p>
					<p><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${caseDetail.caseBaseInfo.registerTime}"/></p>
				</div>
			</div>
			<div class="enclosure1 ">
				<table class="table table-enclosure1 mgt20">
					<tbody>
					<!--表格头部开始-->
					<tr class="first-tr">
						<td class="index-td">证据序号</td>
						<td>证据材料</td>
						<td>证明目的</td>
						<td>证据来源</td>
					</tr>
					<!--表格头部结束-->
					<!--表格主题开始(渲染数据部分开始)-->
					<c:forEach var="evidence" items="${caseDetail.evidences}" varStatus="status">
						<tr>
							<td>${status.index}</td>
							<td>${evidence.evidenceMat}</td>
							<td>${evidence.purposeEvidence}</td>
							<td>${evidence.sourceEvidence}</td>
						</tr>
					</c:forEach>
					<!--表格主题结束(渲染数据部分结束)-->
					</tbody>
				</table>
				<c:forEach var="evidence" items="${caseDetail.evidences}">
					<ul class="enclosure1-ul mgt32 clearfix">
						<p>${evidence.evidenceMat}</p>
						<li>
								<%-- ${evidence.fileId} --%><img src="img/default.png">
						</li>
						<li>
							<img src="img/default.png">
						</li>
					</ul>
				</c:forEach>

				<!--审批记录-->
				<div class="approvel-record mgt80">
					<p class="approvel-record-title">审批记录</p>
					<ul>
						<li class="first-li">
							<p class="clearfix"><span class="left">涉案金额：${caseDetail.caseAmount.caseAmount}元</span><span class="right">仲裁费用：${caseDetail.caseAmount.caseAdmissibleAmount+caseDetail.caseAmount.caseHandlingAmount}元</span></p>
						</li>
						<c:forEach var="approve" items="${caseDetail.approveRecords}">
							<li>
								<p>${approve.duties}${approve.approveName}审核意见：
									<span class="right"><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${approve.createTime}"/></span></p>
								<p class="pdl50">${approve.approveSuggest}</p>
							</li>
						</c:forEach>

					</ul>
				</div>
				<div class="bottom-button">
					<button class="avoidanceapply bg475 mgt100" onclick="javascript:history.back()">返回</button>
				</div>

			</div>
		</div>
	</div>
</div>