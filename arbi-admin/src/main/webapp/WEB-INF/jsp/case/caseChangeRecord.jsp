<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
	<link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>

			<div class="z-right-box z-bg-fff min-height450" id="caseChangeRecord">
				<div class="case-main">
				   <p class="case-main-nocase">
					   <span class="leftspan" >变更仲裁请求审核</span>
					   <span onclick="changeCounterclaim('${caseChangeRecordVO.caseId}');">变更仲裁反请求审核</span></p>

					<!-- 变更仲裁请求 -->
					<c:if test="${not empty caseChangeRecordVO}">

						<p class="juis-clerk">查看双方仲裁申请提交资料<i class="anticon icon-right"></i></p>

						<div class="unCasecheck mgt87">
							<h4 class="h4-title">变更仲裁请求申请</h4>
							<div class="case-main-text">
								<p style="margin-top: 24px;">
									申请人：${caseChangeRecordVO.propName}，
									住所：${caseChangeRecordVO.propAddress}。
									<c:if test="${not empty caseChangeRecordVO.propCertName}">
										<p>
											法定代表人：${caseChangeRecordVO.propCertName}，职务：${caseChangeRecordVO.propCertDuties}
										</p>
									</c:if>
								</p>

								<p style="margin-top: 24px;">
									被申请人：${caseChangeRecordVO.defePropName}，
									住所：${caseChangeRecordVO.defeAddress}。
									<c:if test="${not empty caseChangeRecordVO.defeCertName}">
										<p>
											法定代表人：${caseChangeRecordVO.defeCertName}，职务：${caseChangeRecordVO.defeCertDuties}
										</p>
									</c:if>
								</p>

								<p style="color: #151515;font-size: 16px;margin-top: 20px;">请求事项</p>
								<p>${caseChangeRecordVO.changeRequest}</p>
								<p style="color: #151515;font-size: 16px;margin-top: 20px;">事实与理由</p>
								<p>
									${caseChangeRecordVO.factReason}
								</p>
								<p style="margin-top: 20px;">此致</p>
								<p>珠海仲裁委员会</p>
								<p style="text-align: right">申请人：<span>${caseChangeRecordVO.applyName}</span></p>
								<p style="text-align: right"><fmt:formatDate value="${caseChangeRecordVO.createTime}" pattern="yyyy年MM月dd日"/></p>
							</div>
						</div>


							<c:if test="${caseChangeRecordVO.duties=='2' && not empty caseChangeRecordVO.markAmount}">
								<!--涉案金额为空，则当前用户为秘书，并且尚未提交领导 -->

								<div class="approval-record-main">
									<h6>审 核</h6>
									<div class="approval-record-main-form">
										<label> <span>涉案金额</span> <input name="amount" id="amounts" type="text"
											placeholder="请输入金额" value=""/>
											<button class="calculation bg475" id="calc">计算</button>
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
								</div>
							</c:if>


							<!--审批记录-->
							<div class="approvel-record mgt80">
								<p class="approvel-record-title">审批记录</p>
								<ul>
									<c:if test="${not empty caseChangeRecordVO.markAmount}">
										<li class="first-li">
											<p class="clearfix">
												<span class="left">标的金额：${caseChangeRecordVO.markAmount}元</span>
												<span class="right" id="caseAdmissibleAmount">受理费：${caseChangeRecordVO.caseAdmissibleAmount}元</span>
												<span class="right" id="caseHandlingAmount">处理费：${caseChangeRecordVO.caseHandlingAmount}元</span>
												<span class="right" id="totalAmount">合计：${caseChangeRecordVO.caseAdmissibleAmount+caseChangeRecordVO.caseHandlingAmount}元</span>
											</p>
										</li>
									</c:if>


									<c:if test="${caseChangeRecordVO.approveRecordVOList!=null }">
										<c:forEach items="${caseChangeRecordVO.approveRecordVOList }"
											var="approveRecordVOList">
											<c:if test="${approveRecordVOList.duties=='2'}">
												<li>
													<p></p> ${fn:substring(approveRecordVOList.approveName, 0, 1)}仲裁秘书初审意见：
													<p class="pdl50">${approveRecordVOList.approveSuggest }</p>
												</li>
											</c:if>

											<c:if test="${approveRecordVOList.duties=='3'}">
												<li>
													<p>
														<fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
															value="${approveRecordVOList.createTime}" />
													</p> ${fn:substring(approveRecordVOList.approveName, 0, 1)}仲裁部长复审意见：
													<p class="pdl50">${approveRecordVOList.approveSuggest }</p>
												</li>
											</c:if>

											<c:if test="${approveRecordVOList.duties=='5'}">
												<li>
													<p>
														<fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
															value="${approveRecordVOList.createTime}" />
													</p> ${fn:substring(approveRecordVOList.approveName, 0, 1)}副主任复审意见：
													<p class="pdl50">${approveRecordVOList.approveSuggest }</p>
												</li>
											</c:if>

											<c:if test="${approveRecordVOList.duties=='4'}">
												<li>
													<p>
														<fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
															value="${approveRecordVOList.createTime}" />
													</p> ${fn:substring(approveRecordVOList.approveName, 0, 1)}主任复审意见：
													<p class="pdl50">${approveRecordVOList.approveSuggest }</p>
												</li>
											</c:if>
										</c:forEach>
									</c:if>


								</ul>
							</div>
								<c:if test="${caseChangeRecordVO.duties=='4' || caseChangeRecordVO.duties=='5'}">
									<div class="approvel-record mgt80">
										<p class="approvel-record-title">审批意见</p>
										<textarea id="approveSuggest" class="first-comments"
											placeholder="最多可输入500个字符" style="width:900px"></textarea>
									</div>
								</c:if>

								<c:if test="${caseChangeRecordVO.duties=='2' || caseChangeRecordVO.duties=='3'}">
									<c:if test="${caseChangeRecordVO.primiss=='0'}">
										<c:if test="${caseChangeRecordVO.approveRecordVOList!=null && (caseChangeRecordVO.approveRecordVOList[0].approveStatus=='0' ||caseChangeRecordVO.approveRecordVOList[0].approveStatus=='2' ) }">
											<div class="approvel-record mgt80">
												<p class="approvel-record-title">审批意见</p>
												<textarea id="approveSuggest" class="first-comments"
														  placeholder="最多可输入500个字符" style="width:900px"></textarea>
											</div>
										</c:if>
									</c:if>
								</c:if>

								<c:if test="${caseChangeRecordVO.duties=='4'||caseChangeRecordVO.duties=='5'}">
									<button id="btn3" onclick="leaderApply('驳回');" class="avoidanceapply bg475 mgt100">驳回</button>
									<button id="btn5" onclick="leaderApply('通过');" class="avoidanceapply mgt100">通过</button>
								</c:if>


								<c:if test="${caseChangeRecordVO.duties=='2' || caseChangeRecordVO.duties=='3'}"> <!-- 立案部长呈领导审批 -->
									<c:if test="${caseChangeRecordVO.primiss=='0'}">
										<button id="btn1" onclick="cancel();" class="avoidanceapply bg475 mgt100">取消</button>
										<button id="btn2" onclick="leaderApply('审批');" class="avoidanceapply mgt100">呈领导审批</button>
									</c:if>
								</c:if>
						</c:if>
					</div>
			</div>
            <script src="${appCtx}/static/js/rateCalculation.js"></script>
			<script  type="text/javascript">
			
				var amounts='';
				var caseAdmissibleAmount='';
				var handling='';
			
				//计算受理费
				$("#calc").click(function(){
					var amounts=$("#amounts").val();
					var caseAdmissibleAmount=caseAdmissibleAmount(amounts);
					var handling=handling();
					var total=parseFloat(caseAdmissibleAmount)+parseFloat(handling);
					$("#arbitrationFee").text(total);
				});
				
				//取消
				function cancel() {
					layer.open({
						title : false,
						content : '返回到案件首页？',
						btn : [ '确定', '取消' ],
						offset : [ '200', '500' ],
						yes : function() {
							Request.loadMain({url:"case/caseinfo/"});
							}
						})
					}
				
				//呈领导审批
				function leaderApply(message){
					var opinionStatus='';
					var content='';
					if(message=='通过'){
						opinionStatus='0';
						content='系统将发送受理通知书到当事人，确认提交？';
					}else if(message=='驳回'){
						opinionStatus='1';
						content='系统将发送不受理通知书到申请方，确认提交？';
					}else{
						content='是否确认呈领导审批？';
					}
					layer.open({
						title : false,
						content : content,
						btn : [ '确定', '取消' ],
						offset : [ '200', '500' ],
						yes : function() {
							var approveId = "${caseChangeRecordVO.approveId}";
							var caseId = "${caseChangeRecordVO.caseId}";
							var caseChangeRecordId = "${caseChangeRecordVO.caseChangeRecordId}";
							var approveSuggest = $(" #approveSuggest").val();

							$.ajax({
								url : "${appCtx}/case/changeRecord/audit/"+caseChangeRecordId,
								type : "POST",
								data : {
									'approveId' : approveId,
									'approveSuggest' : approveSuggest,
									'caseId' : caseId,
									'opinionStatus':opinionStatus,
									'amounts':amounts,
									'arbitrationAmount':$("#arbitrationFee").text(),
									'counterclaimFlag':'${caseChangeRecordVO.counterclaimFlag}',
									'caseAdmissibleAmount':caseAdmissibleAmount,
									'caseHandlingAmount':handling
								},

								success : function(data) {

									var retCode = data.head.retCode;
									var msg = data.head.msg;

									if (retCode == '0000') {
										Request.loadMain({url:"initate/audit/"+caseId});
									} else {
										layer.msg(retCode + ":" + msg, {
											icon : 5
										});
									}

								},
								error : function(data) {
									layer.alert('错误', {
										icon : 6
									});
								}
							});

							layer.close(index);

						}

					})
				}
			</script>