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
		<h3>仲裁反请求申请书</h3>
		<div class="case-main-text">
			<p>
				<span>申 请 人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantName}</span>
				<c:if
					test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantType=='0'}">
					<!--自然人  -->
					<span>,</span>
					<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantSex==0?'男':'女'}</span>
					<span>,</span>
					<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantEthnic}</span>
					<span><fmt:parseDate value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantBirthday}" pattern="yyyyMMdd" var="test" /> <fmt:formatDate value="${test}" pattern="yyyy年MM月dd日" />出生 </span>
					<span>,</span>	
					身份证号:<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantCardId}</span>
				</c:if>
			</p>
			<p>
				<span>住所：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantAddress}</span>
			</p>
			<c:if
				test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantType=='1'}">
				<!--法人  -->
				<p>
					<span>法定代表人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantCertName}</span>
					<span>职务：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.applicantCertDuties}</span>
				</p>
			</c:if>
			
			<p>
				<span>被申请人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantName}</span>
				<c:if
					test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantType=='0'}">
					<!-- 自然人 -->
					<span>,</span>
					<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantSex==0?'男':'女'}</span>
					<span>,</span>
					<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantEthnic}</span>
					<span>,</span>
					<span><fmt:parseDate value="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantBirthday}" pattern="yyyyMMdd" var="test" /> <fmt:formatDate value="${test}" pattern="yyyy年MM月dd日" /> 出生</span>
					<span>,</span>	
					身份证号:<span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantCardId}</span>
				</c:if>
			</p>

			<p>
				<span>住所：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantAddress}</span>
			</p>

			<c:if
				test="${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantType=='1'}">
				<!-- 法人 -->
				<p>
					<span>法定代表人：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantCertName}</span><span>职务：</span><span>${initiateAuditBusiExecute.arbitratorCaseBaseInfo.beApplicantCertDuties}</span>
				</p>
			</c:if>

		</div>
		<div class="case-main-contain">
			<p>反请求事项</p>
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

			<c:if test="${initiateAuditBusiExecute.approveDuties=='2'}">
				<c:if
					test="${initiateAuditBusiExecute.caseRequestInfoVO.caseAmount==null}">
					<!--涉案金额为空，则当前用户为秘书，并且尚未提交领导 -->

					<div class="approval-record-main">
						<h6>审 核</h6>
						<span class="approval-record-main-form"> 
							<label> 
							 	<span>行为费</span> <input name="behaviorCharges" id="behaviorCharges" type="text"
								placeholder="请输入行为费" value=""/>
							</label><br>
							<label> 
								<span>涉案金额</span>
								<input name="amount" id="amounts" type="text" placeholder="请输入金额" value="" />
								<button class="calculation bg475" onclick="arbitrationFee()">计算</button>
							</label>
							<label class="mgt20"> 
								<span>仲裁费用</span> 
								<span id="arbitrationFee" class="detail-money"></span>
								<span>元</span>
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
						<textarea class="first-comments" id="approveSuggest" placeholder="最多可输入500个字符"></textarea>
						<p class="detail-date"></p>
					</div>
				</c:if>
			</c:if>

			<c:if test="${!empty initiateAuditBusiExecute.approveRecordList }">
				<!--审批记录-->
				<div class="approvel-record mgt80">
					<p class="approvel-record-title">审批记录</p>
					<ul>
						<c:if test="${initiateAuditBusiExecute.caseRequestInfoVO.caseAmount!=null}">
							<li class="first-li">
								<p class="clearfix">
									<input type="hidden" id="amounts" name="amounts" value="${initiateAuditBusiExecute.caseRequestInfoVO.caseAmount}">
									<span class="left" >标的金额：${initiateAuditBusiExecute.caseRequestInfoVO.caseAmount}元</span>
									<span class="right">受理费：${initiateAuditBusiExecute.caseRequestInfoVO.caseAdmissibleAmount}元</span>
									<span class="right">处理费：${initiateAuditBusiExecute.caseRequestInfoVO.caseHandlingAmount}元</span>
									<span class="right">合计：${initiateAuditBusiExecute.caseRequestInfoVO.totalAmount}元</span>
								</p>
							</li>
						</c:if>

						<c:forEach items="${initiateAuditBusiExecute.approveRecordList }" var="approveRecordList">
							<c:if test="${approveRecordList.duties=='2'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p> 
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}秘书初审意见：
										${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>

							<c:if test="${approveRecordList.duties=='3'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p> 
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}部长复审意见：
										${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>

							<c:if test="${approveRecordList.duties=='5'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p> 
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}副主任复审意见：
										${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>

							<c:if test="${approveRecordList.duties=='4'}">
								<li>
									<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordList.createTime}" />
									</p> 
									<p class="pdl50">
										${fn:substring(approveRecordList.approveName, 0, 1)}主任复审意见：
										${approveRecordList.approveSuggest }
									</p>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</div>

				<div class="approvel-record mgt80">
					<p class="approvel-record-title">审批意见</p>
					<textarea id="approveSuggest" class="first-comments" placeholder="最多可输入500个字符" style="width:900px"></textarea>
				</div>
			</c:if>

			<div class="bottom-button">
				<c:if
					test="${initiateAuditBusiExecute.duties=='4'||initiateAuditBusiExecute.duties=='5'}">
					<c:if test="${initiateAuditBusiExecute.duties==initiateAuditBusiExecute.approveDuties}"> <!-- 副主任 -->
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

				<c:if test="${initiateAuditBusiExecute.duties=='2'}">
					<c:if test="${initiateAuditBusiExecute.duties==initiateAuditBusiExecute.approveDuties}">
						<button id="btn1" onclick="avoid()"
							class="avoidanceapply bg475 mgt100">申请回避</button>
						<!-- 秘书呈领导审批，需要上传仲裁申请费 -->
						<button id="btn6" onclick="secretaryAudit()" class="avoidanceapply mgt100">呈领导审批</button>
					</c:if>
				</c:if>

				<c:if test="${initiateAuditBusiExecute.duties=='3'}">
					<c:if test="${initiateAuditBusiExecute.duties==initiateAuditBusiExecute.approveDuties}">
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
<script src="${appCtx}/static/js/rateCalculation.js"></script>
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

	

	function secretaryAudit() { // 秘书审批
		layer.open({
			title : false,
			content : '案件将提交到上级领导确认提交 ？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
				var opinionStatus = "0";
				var approveSuggest = $(" #approveSuggest").val();
				var amounts = $("#amounts").val(); //涉案金额
				var arbitrationFee = $("#arbitrationFee").text(); //仲裁费
				var handling = 500; //处理费固定暂时默认为500
				var behaviorCharges=$("#behaviorCharges").val(); //行为费
				$.ajax({
					url : "${appCtx}/case/processing/auditBeCounterclaim",
					type : "POST",
					dataType : 'json',
					data : {
						'approveId' : '${initiateAuditBusiExecute.approveId}',
						'opinionStatus' : opinionStatus,
						'approveSuggest' : approveSuggest,
						'caseId' : '${initiateAuditBusiExecute.caseId} ',
						'amounts' : amounts,
						'arbitrationFee' : arbitrationFee,
						'handling' : handling,
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
	
	
	function leaderApply(message) { //部长主任副主任通过案件
		
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
				var amounts = $("#amounts").val(); //涉案金额,用于计算缴费时间
				$.ajax({
					url : "${appCtx}/case/processing/auditBeCounterclaim",
					type : "POST",
					dataType : 'json',
					data : {
						'approveId' : '${initiateAuditBusiExecute.approveId}',
						'opinionStatus' : opinionStatus,
						'approveSuggest' : approveSuggest,
						'caseId' : '${initiateAuditBusiExecute.caseId}',
						'amounts':amounts
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