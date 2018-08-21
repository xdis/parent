<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/filingAduit.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/layer.css"/>
    <link rel="stylesheet" href="${appCtx}/static/vendor/layer/mobile/need/layer.css">
    <%--引入的css文件--%>
<div class="zhong-left z-bg-fff">
	<p class="z-op">仲裁信息</p>
	<div class="left-top">
		<p>案号:<span> ${initiateAuditBusiExecute.arbiInfo.caseNo}</span></p>
		<p>立案时间:<span><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${initiateAuditBusiExecute.arbiInfo.registerTime}"/></span></p>
	</div>
	<div class="z-info z-border">
		<div>
			<p>立案秘书: <span>${initiateAuditBusiExecute.arbiInfo.caseSecretaryName}</span></p>
			<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.caseMinisterName}">
				<p>立案部长: <span>${initiateAuditBusiExecute.arbiInfo.caseMinisterName}</span></p>
			</c:if>
			<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.deputyDirectorName}">
			<p>副主任: <span>${initiateAuditBusiExecute.arbiInfo.deputyDirectorName}</span>
				</c:if>
				<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.directorName}">
			<p>主任: <span>${initiateAuditBusiExecute.arbiInfo.directorName}</span></p>
			</c:if>
		</div>
	</div>
	<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.arbiSecretaryName}">
		<div class="z-info">
			<div>
				<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.arbiSecretaryName}">
					<p>立案秘书: <span>${initiateAuditBusiExecute.arbiInfo.arbiSecretaryName}</span></p>
				</c:if>
				<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.arbiMinisterName}">
					<p>立案部长: <span>${initiateAuditBusiExecute.arbiInfo.arbiMinisterName}</span></p>
				</c:if>
				<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.deputyDirectorName}">
				<p>副主任: <span>${initiateAuditBusiExecute.arbiInfo.deputyDirectorName}</span>
					</c:if>
					<c:if test="${!empty initiateAuditBusiExecute.arbiInfo.directorName}">
				<p>主任: <span>${initiateAuditBusiExecute.arbiInfo.directorName}</span></p>
				</c:if>
			</div>
		</div>
	</c:if>


	<p class="z-op mgt10">案件审批信息</p>
	<div class="z-info z-border" id="caseApproveInfo">
		<div>
			<c:forEach items="${initiateAuditBusiExecute.caseApproveVoList}" var = "approveType">
				<%-- <c:if test="${approveType.primiss==0}"> --%>

				<p><span class="span-click <c:if test="${approveType.approveType=='INITIATE_APPROVAL'}">bg475</c:if>" onclick="approve('${approveType.isMyOperation}','${approveType.approveType}','${approveType.caseId}',this);">${approveType.approveTypeName}</span></p>
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

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress<1}">
					<div class="time-show left">
						<p class="">
							<i class="">1</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">立案</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.registerCaseDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress==1}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">1</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">立案</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.registerCaseDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress>1}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">1</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">立案</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.registerCaseDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>



			</li>

			<li class="clearfix">

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress<2}">
					<div class="time-show left">
						<p class="">
							<i class="">2</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">答辩</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress==2}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">2</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">答辩</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress>2}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">1</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">答辩</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>

			<li class="clearfix">
				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress<3}">
					<div class="time-show left">
						<p class="">
							<i class="">3</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">审理</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.trialDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress==3}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">3</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">审理</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.trialDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress>3}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">3</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">审理</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.trialDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>

			<li class="clearfix">
				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress<4}">
					<div class="time-show left">
						<p class="">
							<i class="">4</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">裁决</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.arbitratorDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress==4}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">4</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">裁决</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.arbitratorDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress>4}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">4</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">裁决</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.arbitratorDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>


			<li class="clearfix">

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress<5}">
					<div class="time-show left">
						<p class="">
							<i class="">5</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">结案</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.completeDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress==5}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">5</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">结案</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.completeDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right"></div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress>5}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">5</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">结案</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.completeDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
					<div class="one-line right bg475"></div>
				</c:if>
			</li>

			<li class="clearfix">
				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress<6}">
					<div class="time-show left">
						<p class="">
							<i class="">6</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">补正</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.offsetDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress==6}">
					<div class="time-show left">
						<p class="p-pro-done bg475">
							<i class="">6</i>
							<i class="icon anticon p-i-hide z-icon">&#xe632;</i>
						</p>
						<div class="show-text">补正</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.offsetDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</span>
					</div>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.caseProgressInfo.currentProgress>6}">
					<div class="time-show left">
						<p class="p-pro-done">
							<i class="p-i-hide">6</i>
							<i class="icon anticon  z-icon">&#xe632;</i>
						</p>
						<div class="show-text">补正</div>
						<span>
							<fmt:parseDate value="${initiateAuditBusiExecute.caseProgressInfo.offsetDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
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
					<p>本请求</p>
					<p>本请求答辩</p>
					<p>变更请求</p>
					<p>变更请求答辩</p>
					<p>举证</p>
					<p>和解</p>
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
		<h3>立案审批表</h3>
		<div class="case-main-text">
			<p>
				<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.caseNO}</span>
			</p>
			<p>
				<span>申请人及代理人基本信息</span>
			</p>
			<p>
				<span>申 请 人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantName}</span>
			</p>
			<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantType=='0'}"> <!--自然人  -->
				<span>,</span>
				<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantSex==0?'男':'女'}</span>
				<span>,</span>
				<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantEthnic}</span>
				<span><fmt:parseDate value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantBirthday}" pattern="yyyyMMdd" var="test" /> <fmt:formatDate value="${test}" pattern="yyyy年MM月dd日" />出生 </span>
				<span>,</span>	
				身份证号:<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantCardId}</span>
			</c:if>
			<p>
				<span>住所：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantAddress}</span>
			</p>

			<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantType=='1'}"> <!--法人  -->
				<p>
					<span>法定代表人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantCertName}</span>
					<span>职务：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantCertDuties}</span>
				</p>
			</c:if>
			
			<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantAttorney!=null}">
				<p>
					<span>代理人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantAttorney}，${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantAttorneyJob}</span>
				</p>
			</c:if>
			
			<p>
				<span>被申请人基本信息</span>
			</p>
			
			<p>
				<span>被申请人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantName}</span>
			</p>
			
			<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantType=='0'}"> <!-- 自然人 -->
				<span>,</span>
				<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantSex==0?'男':'女'}</span>
				<span>,</span>
				<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantEthnic}</span>
				<span>,</span>
				<span><fmt:parseDate value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantBirthday}" pattern="yyyyMMdd" var="test" /> <fmt:formatDate value="${test}" pattern="yyyy年MM月dd日" /> 出生</span>
				<span>,</span>	
				身份证号:<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantCardId}</span>
			</c:if>	
					
			<p>
				<span>住所：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantAddress}</span>
			</p>
			
			<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantType=='1'}">
				<!-- 法人 -->
				<p>
					<span>法定代表人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantCertName}</span><span>职务：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantCertDuties}</span>
				</p>
			</c:if>
			<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantAttorney!=null}">
				<p>
					<span>委托代理人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantAttorney}，${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantAttorneyJob}</span>
				</p>
			</c:if>
		</div>
		<div class="case-main-contain">
			<p>案由</p>
			<p>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.caseType}</p>
		</div>
		<div class="case-main-contain">
			<p>仲裁条款</p>
			<p>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.protocolName}</p>
		</div>
		<div class="case-main-contain">
			<p>申请时间</p>
			<p><fmt:formatDate pattern="yyyy年MM月dd日" value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.registerTime}" /></p>
		</div>
		<div class="case-main-contain">
			<p>是否涉外</p>
			<p>否</p>
		</div>
		<div class="case-main-contain">
			<p>争议金额</p>
			<p>${initiateAuditBusiExecute.caseRequestInfoVO.caseAmount}</p>
		</div>
		<div class="case-main-contain">
			<p>受理费</p>
			<p>${initiateAuditBusiExecute.caseRequestInfoVO.caseAdmissibleAmount}</p>
		</div>
		<div class="case-main-contain">
			<p>处理费</p>
			<p>${initiateAuditBusiExecute.caseRequestInfoVO.caseHandlingAmount}</p>
		</div>
		<div class="case-main-contain">
			<p>行为费</p>
			<p>${initiateAuditBusiExecute.caseRequestInfoVO.behaviorCharges}</p>
		</div>
		<div class="case-main-contain">
			<p>减免费</p>
			<p>无</p>
		</div>
		<div class="case-main-contain">
			<p>合计</p>
			<p>${initiateAuditBusiExecute.caseRequestInfoVO.totalAmount}</p>
		</div>
		<div class="case-main-contain">
			<p>缓缴金额</p>
			<p>无</p>
		</div>
		<div class="case-main-contain">
			<p>缓缴金额</p>
			<p>无</p>
		</div>
		
		<c:if test="${!empty initiateAuditBusiExecute.approveRecordList }">
				<!--审批记录-->
			<div class="approvel-record mgt80">
				<ul>		
					<c:forEach items="${initiateAuditBusiExecute.approveRecordList }"
						var="approveRecordList">
						<c:if test="${approveRecordList.duties=='0'}">
							<li>
								<p>经办人意见:${approveRecordList.approveSuggest }</p>
								<p>
									经办时间:<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									经办人:${approveRecordList.approveName}
								</p>
							</li>
						</c:if>
						
						<c:if test="${approveRecordList.duties=='1'}">
							<li>
								<p>部门负责人意见:${approveRecordList.approveSuggest }</p>
							</li>
						</c:if>
						
						<c:if test="${approveRecordList.duties=='5'||approveRecordList.duties=='4'}">
							<li>
								<p>分管副主任/主任意见:${approveRecordList.approveSuggest }</p>
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		
			<div class="approvel-record mgt80">
				<p class="approvel-record-title">${initiateAuditBusiExecute.duties=='1'?'部门负责人意见':'分管副主任/主任意见'}</p>
				<textarea id="approveSuggest" class="first-comments"
					placeholder="最多可输入500个字符" style="width:900px"></textarea>
			</div>
		
		</c:if>
		
	</div>
	
	<div class="bottom-button">
		<c:if test="${initiateAuditBusiExecute.duties=='4'||initiateAuditBusiExecute.duties=='5'}">
			<c:if test="${initiateAuditBusiExecute.duties==initiateAuditBusiExecute.approveDuties}"> <!-- 副主任 -->
				<button id="reject" onclick="leaderApply('驳回')" class="avoidanceapply bg475 mgt100">驳回</button>
				<button id="through" onclick="leaderApply('通过')" class="avoidanceapply mgt100">通过</button>
			</c:if>
			<c:if test="${initiateAuditBusiExecute.approveDuties=='5'}"> <!--审批表副主任  -->
				<c:if test="${initiateAuditBusiExecute.duties=='4'}"> <!-- 判断是否为主任 -->
					<button id="reject" onclick="leaderApply('驳回')" class="avoidanceapply bg475 mgt100">驳回</button>
					<button id="through" onclick="leaderApply('通过')" class="avoidanceapply mgt100">通过</button>
				</c:if>
			</c:if>
		</c:if>
					
		<c:if test="${initiateAuditBusiExecute.duties=='1'}"> <!-- 立案部长呈领导审批 -->
			<c:if test="${initiateAuditBusiExecute.duties==initiateAuditBusiExecute.approveDuties}">
				<button id="through" onclick="leaderApply('呈领导审批')" class="avoidanceapply mgt100">呈领导审批</button>
			</c:if>
		</c:if>
	</div>
</div>


<script src="${appCtx}/static/js/jquery-3.2.1.min.js"></script>
<script src="${appCtx}/static/vendor/layer/layer.js"></script>
<script src="${appCtx}/static/js/rateCalculation.js"></script>
<script type="text/javascript">

	function leaderApply(message) { //部长主任副主任审批
		var opinionStatus='';
		var content='';
		if(message=='通过'){
			opinionStatus='0';
			content='确认将发放受理通知书,确认通过?';
		}else if(message=='驳回'){
			opinionStatus='1';
			content='驳回将发放不受理通知书,确认驳回?';
		}else{
			opinionStatus='0';
			content='案件将提交到上级领导,确认提交?';
		}
		
		
		layer.open({
			title : false,
			content : content,
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
				var approveSuggest = $(" #approveSuggest").val();
				$.ajax({
					url : "${appCtx}/initate/audit/examine",
					type : "POST",
					dataType : 'json',
					data : {
						'approveId' : '${initiateAuditBusiExecute.approveId}',
						'opinionStatus' : opinionStatus,
						'approveSuggest' : approveSuggest,
						'caseId' : '${initiateAuditBusiExecute.caseId}'
					},
					success : function(json) {
						if (json.head.retCode == '0000') {
							//成功 
							location.reload();
						} else {
							//出错  
							layer.alert(json.head.msg, {
								skin : 'layui-layer-lan' //样式类名
								,
								closeBtn : 0
							});
						}
					}

				});

			}

		})

	}


</script>
