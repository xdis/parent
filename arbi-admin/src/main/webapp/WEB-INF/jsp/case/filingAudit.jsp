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
		<h3>仲裁申请书</h3>
		<div class="case-main-text">
			<p>
				<span>案件编号：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.caseNO}</span>
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
		</div>
		<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantType=='1'&&initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantType=='1'}"> <!-- 申请人和被申请人都是法定代表人 -->
			<div class="case-main-contain">
				<p>仲裁协议</p>
				<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.signAbriProtocolMode=='0'}">
					双方当事人于<fmt:formatDate pattern="yyyy年MM月dd日" value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.signTime}" />签订的《${initiateAuditBusiExecute.arbitratorCaseBaseInfo.protocolName}》中的仲裁条款
				</c:if>	
				<c:if test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.signAbriProtocolMode=='1'}">
					双方当事人于<fmt:formatDate pattern="yyyy年MM月dd日" value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.signTime}" />签订的仲裁协议。
				</c:if>
			</div>			
		</c:if>
			
		<div class="case-main-contain">
			<p>仲裁请求</p>
			<p>申请人的仲裁请求</p>
			<p>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.arbClaim}</p>
		</div>
		<div class="case-main-contain">
			<p>事实与理由</p>
			<p>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.fact}</p>
		</div>
		<div class="case-main-contain">
			<p>此致</p>
			<p>珠海仲裁委员会</p>
		</div>
		<div class="case-main-lastname">
			<p>
				申请人：<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantName}</span>
			</p>
			<p>
				<!-- 立案时间 -->
				<fmt:formatDate pattern="yyyy年MM月dd日" value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.registerTime}" />
			</p>
		</div>
		<div class="enclosure1 ">

			<c:if test="${!empty initiateAuditBusiExecute.evidenceList}">
				<b class="bg475 mgt80">附件：证据清单</b>
				<table class="table table-enclosure1 mgt20">
					<tbody>
						<!--表格头部开始-->
						<tr class="first-tr">
							<td class="index-td">证据序号</td>
							<td>证据材料</td>
							<td>证据目的</td>
							<td>证据来源</td>
							<td>文件名</td>
						</tr>


						<!--表格头部结束-->
						<!--表格主题开始(渲染数据部分开始)-->
  
						<c:forEach var="evidenceList" items="${initiateAuditBusiExecute.evidenceList}" varStatus="xh">
							<tr>
								<td>${xh.count}</td>
								<td>${evidenceList.evidenceMat}</td>
								<td>${evidenceList.purposeEvidence}</td>
								<td>${evidenceList.sourceEvidence}</td>
								<td>${evidenceList.docName}</td>
							</tr>
						</c:forEach>

						<!--表格主题结束(渲染数据部分结束)-->
					</tbody>
				</table>
				<p class="enclosure1-p">申请人证据</p>
				<ul class="enclosure1-ul mgt17 clearfix">
					<c:forEach var="evidenceList" items="${initiateAuditBusiExecute.evidenceList}" varStatus="xh">
						<li><img src="${evidenceList.fileId}">
						<!-- 图片地址文件ID -->
							<p class="mgt10">${xh.count}</p>
							<p>${evidenceList.docName}</p>
							<!-- 文件名 --></li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${initiateAuditBusiExecute.approveDuties=='0'}">
			<c:if	test="${initiateAuditBusiExecute.caseRequestInfoVO.caseAmount==null}">
				<!--涉案金额为空，则当前用户为秘书，并且尚未提交领导 -->

				<div class="approval-record-main">
					<h6>审 核</h6>
					<div class="approval-record-main-form">
						<label> 
						 	<span>案由</span> <input name="caseTypeId" id="caseTypeId" type="text"
							placeholder="请输入案由" value=""/>
						</label><br>
						<label> 
						 	<span>行为费</span> <input name="behaviorCharges" id="behaviorCharges" type="text"
							placeholder="请输入行为费" value=""/>
						</label><br>
						<label> <span>涉案金额</span> <input name="amount" id="amounts" type="text"
							placeholder="请输入金额" value=""/>
							<button class="calculation bg475" onclick="arbitrationFee()">计算</button>
						</label>
					    <label class="mgt20"> <span>仲裁费用</span> <span
							id="arbitrationFee"  class="detail-money"></span><span>元</span>
						</label>
					</div>
					<table class="table table-money">
						<tbody>
							<!--表格头部开始-->
							<tr class="first-tr">
								<td class="index-td">争议金额（元）</td>
								<td>仲裁案件受理费（元或比例）</td>
							</tr>
							<!--表格头部结束-->
							<!--表格主题开始(渲染数据部分开始)-->
							<tr>
								<td class="index-td">1000以下</td>
								<td>40-100</td>
							</tr>
							<tr>
								<td class="index-td">1001至50000</td>
								<td>按4%-5%交纳</td>
							</tr>
							<tr>
								<td class="index-td">50001至100000</td>
								<td>按3%-4%交纳</td>
							</tr>
							<tr>
								<td class="index-td">100001至200000</td>
								<td>按2%-3%交纳</td>
							</tr>
							<tr>
								<td class="index-td">200001至500000</td>
								<td>按1%-2%交纳</td>
							</tr>
							<tr>
								<td class="index-td">500001至1000000</td>
								<td>按0.5%-1%交纳</td>
							</tr>
							<tr>
								<td class="index-td">1000001以上</td>
								<td>按0.25%-0.5%交纳</td>
							</tr>
							<!--表格主题结束(渲染数据部分结束)-->
						</tbody>
					</table>
					<div class="approvel-record mgt80">
						<p class="approvel-record-title">初审意见</p>
						<textarea class="first-comments" id="approveSuggest" placeholder="最多可输入500个字符"></textarea>
					</div>
					<p class="detail-date"></p>
				</div>
			</c:if>
			</c:if>
			
			<div class="bottom-button">
					<c:if test="${initiateAuditBusiExecute.duties=='0'}">
						<c:if test="${initiateAuditBusiExecute.duties==initiateAuditBusiExecute.approveDuties}">
							<button id="cancel" onclick="cancel()" class="avoidanceapply bg475 mgt100">取消</button>
							<button id="btn6" onclick="btn()" class="avoidanceapply mgt100">呈领导审批</button>
						</c:if>
					</c:if>	
			</div>
		</div>
	</div>
</div>


<script src="${appCtx}/static/js/jquery-3.2.1.min.js"></script>
<script src="${appCtx}/static/vendor/layer/layer.js"></script>
<script src="${appCtx}/static/js/rateCalculation.js"></script>
<script type="text/javascript">

	function cancel() {
		layer.open({
			title : false,
			content : '返回到案件首页？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
				Request.loadMain({
					url : "case/caseinfo/"
				});
			}
		})
	}

	function btn() { //秘书呈领导审批
		layer.open({
			title : false,
			content : '秘书是否确认呈领导审批？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
				var approveSuggest = $(" #approveSuggest").val();
				var amounts = $("#amounts").val(); //涉案金额
				var arbitrationFee = $("#arbitrationFee").text(); //仲裁费
				var handling = 500; //处理费固定暂时默认为500
				var caseTypeId = $("#caseTypeId").val();  //案由
				var behaviorCharges=$("#behaviorCharges").val(); //行为费
				$.ajax({
					url : "${appCtx}/initate/audit/examine",
					type : "POST",
					dataType : 'json',
					data : {
						'approveId' : '${initiateAuditBusiExecute.approveId}',
						'opinionStatus' : '0',
						'approveSuggest' : approveSuggest,
						'caseId' : '${initiateAuditBusiExecute.caseId}',
						'amounts' : amounts,
						'arbitrationFee' : arbitrationFee,
						'handling' : handling,
						'caseTypeId':caseTypeId,
						'behaviorCharges':behaviorCharges
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
