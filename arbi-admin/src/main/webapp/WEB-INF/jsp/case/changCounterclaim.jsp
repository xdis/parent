<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/filingAduit.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/layer.css"/>
    <link rel="stylesheet" href="${appCtx}/static/vendor/layer/mobile/need/layer.css">
    <%--引入的css文件--%>

<div class="z-right-box z-bg-fff">
	
	
	<div class="case-main">
		<h3>变更仲裁反请求申请书</h3>
		<div class="case-main-text">
			<p>
				<span>申 请 人：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantName}</span>
				<c:if
					test="${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantType=='0'}"> <!--自然人  -->
					<span>,</span>
					<span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantSex==0?'男':'女'}</span>
					<span>,</span>
					<span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantEthnic}</span>
					<span>,</span>
					<span> <fmt:parseDate value="${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantBirthday}" pattern="yyyyMMdd" var="test" /> <fmt:formatDate value="${test}" pattern="yyyy年MM月dd日" /> 出生</span>
					<span>,</span>	
					身份证号:<span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantCardId}</span>
				</c:if>
			</p>
			<p>
				<span>住所：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantAddress}</span>
			</p>
			<c:if test="${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantType=='1'}"> <!--法人  -->
				<p>
					<span>法定代表人：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantCertName}</span>
					<span>职务：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantCertDuties}</span>
				</p>
			</c:if>
			<p>
				<span>被申请人：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantName}</span>
				<c:if test="${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantType=='0'}"> <!-- 自然人 -->
					<span>,</span>
					<span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantSex==0?'男':'女'}</span>
					<span>,</span>
					<span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantEthnic}</span>
					<span>,</span>
					<span> <fmt:parseDate value="${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantBirthday}" pattern="yyyyMMdd" var="test" /> <fmt:formatDate value="${test}" pattern="yyyy年MM月dd日" /> 出生</span>
					<span>,</span>	
					身份证号:<span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantCardId}</span>
				</c:if>
			</p>
			<p><span>住所：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantAddress}</span></p>

			<c:if test="${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantType=='1'}">	
				<p>
					<span>法定代表人：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantCertName}</span><span>职务：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantCertDuties}</span>
				</p>
			</c:if>

			<c:if test="${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantAttorney!=null}">
				<p>
					<span>委托代理人：</span><span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantAttorney}，${beCounterclaimAuditVO.arbitratorCaseBaseInfo.beApplicantAttorneyJob}</span>
				</p>
			</c:if>
		</div>

		<div class="case-main-contain">
			<p>申请事项</p>
			<p>${beCounterclaimAuditVO.changeRequestContentVO.changeRequest}</p>
		</div>
		<div class="case-main-contain">
			<p>事实与理由</p>
			<p>${beCounterclaimAuditVO.changeRequestContentVO.factReason}</p>
		</div>
		<div class="case-main-contain">
			<p>此致</p>
			<p>珠海仲裁委员会</p>
		</div>
		<div class="case-main-lastname">
			<p>
				申请人：<span>${beCounterclaimAuditVO.arbitratorCaseBaseInfo.applicantName}</span>
			</p>
			<p> <!-- 立案时间 -->
				<fmt:formatDate pattern="yyyy年MM月dd日" value="${beCounterclaimAuditVO.changeRequestContentVO.createTime}" />
			</p>
		</div>
		
		<div class="enclosure1 ">
			
			<c:if test="${beCounterclaimAuditVO.duties=='2' && beCounterclaimAuditVO.changeRequestContentVO.paymentShouldBe==null}">
				<!--涉案金额为空，则当前用户为秘书，并且尚未提交领导 -->
				<div class="approval-record-main">
					<h6>审 核</h6>
					<span class="approval-record-main-form"> 
					<label> 
						<span>标的金额：</span>
						<input name="amount" id="amounts" type="text" placeholder="请输入金额" value="" />
						<button class="calculation bg475" onclick="arbitrationFee(${beCounterclaimAuditVO.paymentShouldBeList},
						${beCounterclaimAuditVO.caseRequestInfoVO.caseAdmissibleAmount},${beCounterclaimAuditVO.caseRequestInfoVO.caseHandlingAmount})">计算</button>
					</label>
					<label>
					 	 <span>仲裁费速算：</span> 
					 	 <span>受理费</span> <span id="theFeeFor"></span><span>元</span>
					 	 <span>处理费</span><span id="handling"></span><span>元</span> 
					 	 <span>合计</span><span id="arbitrationFee"></span><span>元</span>
					</label>
					<label> 
						 <span id="arbitrationFee" class="detail-money"></span>
					</label> 
					<label> 
						<span>应补缴</span> <span id="payment"></span> <span id="prompting"></span>
					</label>
					</span>
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
					<span class="first-comments-span">初审意见</span>
					<textarea class="first-comments" id="approveSuggest"	placeholder="最多可输入500个字符"></textarea>
					<p class="detail-date"></p>
				</div>
			</c:if>


			<c:if test="${!empty beCounterclaimAuditVO.approveRecordList}">
				<!--涉案金额不为空，则当前用户为秘书，部长或者主任，并且为秘书时是提交已经提交领导审批领导 -->
				<!--审批记录-->
				<div class="approvel-record mgt80">
					<p class="approvel-record-title">审批记录</p>
					<ul>
						<c:if test="${beCounterclaimAuditVO.changeRequestContentVO.markAmount!=null}">
						<li class="first-li">
							<p class="clearfix">
								<span class="left">标的金额：${beCounterclaimAuditVO.changeRequestContentVO.markAmount}元</span>
								<span class="right">应补缴：${beCounterclaimAuditVO.changeRequestContentVO.paymentShouldBe}元</span>
							</p>
						</li>
						</c:if>
						<c:forEach items="${beCounterclaimAuditVO.approveRecordList }"
							var="approveRecordList">
							<c:if test="${approveRecordList.duties=='2'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p>
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}
										秘书初审意见：${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>

							<c:if test="${approveRecordList.duties=='3'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p> 
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}
										部长复审意见：${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>

							<c:if test="${approveRecordList.duties=='5'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p>
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}
										副主任复审意见：${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>

							<c:if test="${approveRecordList.duties=='4'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p> 
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}
										主任复审意见：${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</div>

				<span class="first-comments-span">审批意见</span>
				<textarea id="approveSuggest" class="first-comments" placeholder="最多可输入500个字符"></textarea>
			</c:if>

			<div class="bottom-button">
				<c:if test="${beCounterclaimAuditVO.duties=='4'||beCounterclaimAuditVO.duties=='5'}">
					<c:if test="${beCounterclaimAuditVO.duties==beCounterclaimAuditVO.approveDuties}">
						<button id="btn3" onclick="leaderApply('驳回')" class="avoidanceapply bg475 mgt100">驳回</button>
						<button id="btn5" onclick="leaderApply('通过')" class="avoidanceapply mgt100">通过</button>
					</c:if>
					<c:if test="${initiateAuditBusiExecute.approveDuties=='5'}"> <!-- 主任 -->
						<c:if test="${initiateAuditBusiExecute.duties=='4'}">
							<button id="btn3" onclick="leaderApply('驳回')" class="avoidanceapply bg475 mgt100">驳回</button>
							<button id="btn5" onclick="leaderApply('通过')" class="avoidanceapply mgt100">通过</button>
						</c:if>
					</c:if>
				</c:if>

				<c:if test="${beCounterclaimAuditVO.duties=='2'}">
					<c:if test="${beCounterclaimAuditVO.duties==beCounterclaimAuditVO.approveDuties}">
						<button id="btn1" onclick="avoid()" class="avoidanceapply bg475 mgt100">申请回避</button>
						<!-- 秘书呈领导审批，需要上传仲裁申请费 -->
						<button id="btn6" onclick="secretaryAudit()" class="avoidanceapply mgt100">呈领导审批</button>
					</c:if>
				</c:if>
				<c:if test="${beCounterclaimAuditVO.duties=='3'}">
					<c:if test="${beCounterclaimAuditVO.duties==beCounterclaimAuditVO.approveDuties}">
						<!-- 部长呈领导审批 -->
						<button id="btn2" onclick="leaderApply('呈领导审批')" class="avoidanceapply mgt100">呈领导审批</button>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
</div>

<script src="${appCtx}/static/js/jquery-3.2.1.min.js"></script>
<script src="${appCtx}/static/vendor/layer/layer.js"></script>
<script src="${appCtx}/static/js/changeCounterclaim.js"></script>
<script type="text/javascript">
	function avoid() { //秘书申请回避
		layer.open({
			title : false,
			content : '确认申请回避 ？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
	
				Request.loadMain({url:"case/caseinfo/"});
			}
	
		})
	
	}
	
	function secretaryAudit() { //秘书呈领导审批
		layer.open({
			title : false,
			content : '是否确认呈领导审批？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
				var approveSuggest = $(" #approveSuggest").val();
				var markAmount = $("#amounts").val();  //标的金额
				var paymentShouldBe = $("#payment").text();  //应补缴
				var theFeeFor=$("#theFeeFor").text();  //受理费
				var handling=$("#handling").text();   //处理费				
				$.ajax({
					url : "${appCtx}/case/processing/auditChangeCounterclaim",
					type : "POST",
					dataType : 'json',
					data : {
						'approveId' : '${beCounterclaimAuditVO.approveId}',
						'opinionStatus' : '0',
						'approveSuggest' : approveSuggest,
						'caseId' : '${beCounterclaimAuditVO.caseId}',
						'markAmount' : markAmount,
						'paymentShouldBe' : paymentShouldBe,
						'changeId':'${beCounterclaimAuditVO.changeRequestContentVO.changeId}',
						'theFeeFor':theFeeFor,
						'handling':handling
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
	
	
	function leaderApply(message) {  //部长主任副主任通过案件
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
					url : "${appCtx}/case/processing/auditChangeCounterclaim",
					type : "POST",
					dataType : 'json',
					data : {
						'approveId' : '${beCounterclaimAuditVO.approveId}',
						'opinionStatus' : opinionStatus,
						'approveSuggest' : approveSuggest,
						'caseId' : '${beCounterclaimAuditVO.caseId}',
						'changeId':'${beCounterclaimAuditVO.changeRequestContentVO.changeId}'
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
