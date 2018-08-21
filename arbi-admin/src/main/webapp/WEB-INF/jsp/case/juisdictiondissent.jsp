<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
	<link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>
                    <div class="z-right-box z-bg-fff min-height450">

	                    <div class="case-main">

							<p class="case-main-nocase">
								<span class="leftspan" onclick="thisJuisdic();">本请求管辖权异议</span>
								<span class="rightspan" onclick="counterclaimJuisdic();">反请求管辖权异议</span></p>

	                    	<!-- 仲裁申请 -->
							<c:if test="${not empty arbitrationCaseJurisDis.arbiCaseJurisDisVO}">
	                           	
	                           	<p class="juis-clerk">查看双方仲裁申请提交资料<i class="anticon icon-right"></i></p>
	                           	
	                           	<div class="unCasecheck mgt87">
		                           	<h4 class="h4-title">管辖权异议申请书</h4>
	                                <div class="case-main-text">
	                                    <p style="margin-top: 24px;">
											珠海仲裁委员会：
	                                    </p>
	                                    <p style="margin-top: 24px;">
											针对贵会受理的${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseNo}，我方提出管辖权异议如下：
	                                    </p>
	                                    <p style="color: #151515;font-size: 16px;margin-top: 20px;">请求</p>
	                                    <p>${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestItem}</p>
	                                    <p style="color: #151515;font-size: 16px;margin-top: 20px;">事实与理由</p>
	                                    <p>
	                                    	${arbitrationCaseJurisDis.arbiCaseJurisDisVO.reason}
	                                    </p>
	                                    <p style="margin-top: 20px;">此致</p>
	                                    <p>珠海仲裁委员会</p>
	                                    <p style="text-align: right">申请人：<span>${arbitrationCaseJurisDis.arbiCaseJurisDisVO.applyName}</span></p>
	                                    <p style="text-align: right"><fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.createTime}" pattern="yyyy年MM月dd日"/></p>
	                                </div>
                                </div>

								<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.duties == '2'}">

									<%--未组庭--%>
									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark=='0'}">
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.primiss == '0'}">
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '0' || arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '2'}">
												<button type="button" id="agree">同意模板</button>
												<button type="button" id="reject">拒绝模板</button>
											</c:if>
										</c:if>

									</c:if>

									<%--已组庭--%>
									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark=='1'}">
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '2' }">
											<button type="button" id="agree">同意模板</button>
											<button type="button" id="reject">拒绝模板</button>
										</c:if>
									</c:if>

								</c:if>

                               <!-- 同意模板 -->
                                <div class="decision" style="display:none" id="agreeDecision">
									<h4 class="h4-title">珠 海 仲 裁 委 员 会</h4>
									<h3>决 定 书</h3>
									<h4 class="h4-title">${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseNo}</h4>
									<p style="margin-top: 24px;">
										申请人：${arbitrationCaseJurisDis.caseDocHead.applicant.name}
									</p>
									<p style="margin-top: 24px;">
										住所：${arbitrationCaseJurisDis.caseDocHead.applicant.address}
									</p>
									<c:if test="${not empty arbitrationCaseJurisDis.caseDocHead.applicantAgent.name}">
										<p style="margin-top: 24px;">
											委托代理人：${arbitrationCaseJurisDis.caseDocHead.applicant.name}，职务：${arbitrationCaseJurisDis.caseDocHead.applicant.certDuties}。
										</p>
									</c:if>


									<p style="margin-top: 24px;">
										被申请人：${arbitrationCaseJurisDis.caseDocHead.beApplicant.name}
									</p>
									<p style="margin-top: 24px;">
										住所：${arbitrationCaseJurisDis.caseDocHead.beApplicant.address}
									</p>
									<c:if test="${not empty arbitrationCaseJurisDis.caseDocHead.beApplicantAgent.name}">
										<p style="margin-top: 24px;">
											委托代理人：${arbitrationCaseJurisDis.caseDocHead.beApplicantAgent.name}，职务：${arbitrationCaseJurisDis.caseDocHead.beApplicantAgent.certDuties}。
										</p>
									</c:if>
									<P>
										珠海仲裁委员会（以下简称本会）根据申请人${arbitrationCaseJurisDis.caseDocHead.applicant.name}（以下简称申请人）与被申请人${arbitrationCaseJurisDis.caseDocHead.beApplicant.name}（以下简称被申请人）于
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signAbriProtocolMode=='0'}">
											<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signTime}"	pattern="yyyy年MM月dd日" />签订的${arbitrationCaseJurisDis.arbiCaseJurisDisVO.protocolName}中的仲裁条款
										</c:if>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signAbriProtocolMode=='1'}">
											<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signTime}"	pattern="yyyy年MM月dd日" />签订的仲裁协议
										</c:if>
										和申请人的仲裁申请，于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseAcceptanceTime}"	pattern="yyyy年MM月dd日" />受理了申请人关于${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseTypeId}的仲裁申请。
									</P>

									<!--已组庭-->
									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==1}">
										<p>
											本会按照《仲裁规则》的规定，组成由${arbitrationCaseJurisDis.arbiCaseJurisDisVO.arbitratorName}担任仲裁员的独任仲裁庭，
											并于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalNoticeCreateTime}"	pattern="yyyy年MM月dd日" />向双方当事人送达了组庭通知书。
										</p>
									</c:if>

									<p>
											<%--本请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
											申请人向本会提出如下仲裁请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.arbClaim}
										</c:if>

											<%--反请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
											被申请人向本会提出如下仲裁反请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.arbClaim}
										</c:if>
									</p>

									<c:if test="${not empty arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeRequest && not empty arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeTime}">
										<p>
												<%--本请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
												申请人又于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeTime}"	pattern="yyyy年MM月dd日" />向本会提交书面变更仲裁请求申请书，
												变更仲裁请求为：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeRequest}
											</c:if>

												<%--反请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
												被申请人又于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeTime}"	pattern="yyyy年MM月dd日" />向本会提交书面变更仲裁反请求申请书，
												变更仲裁反请求为：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeRequest}
											</c:if>
										</p>
									</c:if>

									<p>
											<%--本请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
											被申请人于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.createTime}"	pattern="yyyy年MM月dd日" />向本会提交了管辖权异议申请书，
											请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestItem}。
											其理由是：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.reason}。
										</c:if>

											<%--反请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
											申请人于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.createTime}"	pattern="yyyy年MM月dd日" />向本会提交了管辖权异议申请书，
											请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestItem}。
											其理由是：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.reason}。
										</c:if>

									</p>

									<c:if test="${not empty arbitrationCaseJurisDis.arbiCaseJurisDisVO.feedBack}">


										<p>

												<%--本请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
												申请人提出如下回应意见：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.feedBack}。
											</c:if>

												<%--反请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
												被申请人提出如下回应意见：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.feedBack}。
											</c:if>

										</p>
									</c:if>

									<p>
									<p style="color: #151515;font-size: 16px;margin-top: 20px;">仲裁委员会（仲裁庭）决定</p>
									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==0}">
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.primiss == '0'}">
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '0' || arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '2'}">
												<p>
													<textarea class="textarea-say" id="rejectFinalDecision" placeholder="最多可以输入500个字符">${arbitrationCaseJurisDis.documentContentVO.opinion}</textarea>
												</p>
											</c:if>
										</c:if>
									</c:if>

									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==1}">
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '2'}">
											<p>
												<textarea class="textarea-say" id="rejectFinalDecision" placeholder="最多可以输入500个字符">${arbitrationCaseJurisDis.documentContentVO.opinion}</textarea>
											</p>
										</c:if>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus != '2'}">
											<p>
													${arbitrationCaseJurisDis.documentContentVO.opinion}
											</p>
										</c:if>
									</c:if>

									</p>

									<p>
									<p style="text-align: right">珠海仲裁委员会</p>
									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==1}">
										<p style="text-align: right">仲裁员：${arbitratorAvoid.avoidVO.arbitratorName}</p>
									</c:if>
									<p style="text-align: right">秘书：${arbitratorAvoid.avoidVO.secretaryName}</p>
									<p style="text-align: right"><fmt:formatDate value="${arbitrationCaseJurisDis.documentContentVO.issusTime}"	pattern="yyyy年MM月dd日" /></p>
									</p>
                                </div>
                                <!-- 同意模板 -->
	                            
	                            
	                            <!-- 拒绝模板 -->
	                            <div class="decision" style="display:none" id="rejectDecision">
									<h4 class="h4-title">珠 海 仲 裁 委 员 会</h4>
									<h3>决 定 书</h3>
									<h4 class="h4-title">${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseNo}</h4>
									<p style="margin-top: 24px;">
										申请人：${arbitrationCaseJurisDis.caseDocHead.applicant.name}
									</p>
									<p style="margin-top: 24px;">
										住所：${arbitrationCaseJurisDis.caseDocHead.applicant.address}
									</p>
									<c:if test="${not empty arbitrationCaseJurisDis.caseDocHead.applicantAgent.name}">
										<p style="margin-top: 24px;">
											委托代理人：${arbitrationCaseJurisDis.caseDocHead.applicant.name}，职务：${arbitrationCaseJurisDis.caseDocHead.applicant.certDuties}。
										</p>
									</c:if>


									<p style="margin-top: 24px;">
										被申请人：${arbitrationCaseJurisDis.caseDocHead.beApplicant.name}
									</p>
									<p style="margin-top: 24px;">
										住所：${arbitrationCaseJurisDis.caseDocHead.beApplicant.address}
									</p>
									<c:if test="${not empty arbitrationCaseJurisDis.caseDocHead.beApplicantAgent.name}">
										<p style="margin-top: 24px;">
											委托代理人：${arbitrationCaseJurisDis.caseDocHead.beApplicantAgent.name}，职务：${arbitrationCaseJurisDis.caseDocHead.beApplicantAgent.certDuties}。
										</p>
									</c:if>
									<P>
										珠海仲裁委员会（以下简称本会）根据申请人${arbitrationCaseJurisDis.caseDocHead.applicant.name}（以下简称申请人）与被申请人${arbitrationCaseJurisDis.caseDocHead.beApplicant.name}（以下简称被申请人）于
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signAbriProtocolMode=='0'}">
											<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signTime}"	pattern="yyyy年MM月dd日" />签订的${arbitrationCaseJurisDis.arbiCaseJurisDisVO.protocolName}中的仲裁条款
										</c:if>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signAbriProtocolMode=='1'}">
											<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.signTime}"	pattern="yyyy年MM月dd日" />签订的仲裁协议
										</c:if>
										和申请人的仲裁申请，于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseAcceptanceTime}"	pattern="yyyy年MM月dd日" />受理了申请人关于${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseTypeId}的仲裁申请。
									</P>

									<!--已组庭-->
									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==1}">
										<p>
											本会按照《仲裁规则》的规定，组成由${arbitrationCaseJurisDis.arbiCaseJurisDisVO.arbitratorName}担任仲裁员的独任仲裁庭，
											并于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalNoticeCreateTime}"	pattern="yyyy年MM月dd日" />向双方当事人送达了组庭通知书。
										</p>
									</c:if>

									<p>
										<%--本请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
											申请人向本会提出如下仲裁请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.arbClaim}
										</c:if>

										<%--反请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
											被申请人向本会提出如下仲裁反请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.arbClaim}
										</c:if>
									</p>

									<c:if test="${not empty arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeRequest && not empty arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeTime}">
										<p>
											<%--本请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
												申请人又于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeTime}"	pattern="yyyy年MM月dd日" />向本会提交书面变更仲裁请求申请书，
												变更仲裁请求为：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeRequest}
											</c:if>

											<%--反请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
												被申请人又于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeTime}"	pattern="yyyy年MM月dd日" />向本会提交书面变更仲裁反请求申请书，
												变更仲裁反请求为：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseChangeRequest}
											</c:if>
										</p>
									</c:if>

									<p>
										<%--本请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
											被申请人于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.createTime}"	pattern="yyyy年MM月dd日" />向本会提交了管辖权异议申请书，
											请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestItem}。
											其理由是：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.reason}。
										</c:if>

										<%--反请求--%>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
											申请人于<fmt:formatDate value="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.createTime}"	pattern="yyyy年MM月dd日" />向本会提交了管辖权异议申请书，
											请求：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestItem}。
											其理由是：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.reason}。
										</c:if>

									</p>

									<c:if test="${not empty arbitrationCaseJurisDis.arbiCaseJurisDisVO.feedBack}">


										<p>

											<%--本请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==0}">
												申请人提出如下回应意见：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.feedBack}。
											</c:if>

											<%--反请求--%>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType==1}">
												被申请人提出如下回应意见：${arbitrationCaseJurisDis.arbiCaseJurisDisVO.feedBack}。
											</c:if>

										</p>
									</c:if>

									<p>
										<p style="color: #151515;font-size: 16px;margin-top: 20px;">仲裁委员会（仲裁庭）决定</p>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==0}">
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.primiss == '0'}">
												<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '0' || arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '2'}">
													<p>
														<textarea class="textarea-say" id="rejectFinalDecision" placeholder="最多可以输入500个字符">${arbitrationCaseJurisDis.documentContentVO.opinion}</textarea>
													</p>
												</c:if>
											</c:if>
										</c:if>

										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==1}">
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus == '2'}">
												<p>
													<textarea class="textarea-say" id="rejectFinalDecision" placeholder="最多可以输入500个字符">${arbitrationCaseJurisDis.documentContentVO.opinion}</textarea>
												</p>
											</c:if>
											<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseApproveStatus != '2'}">
												<p>
														${arbitrationCaseJurisDis.documentContentVO.opinion}
												</p>
											</c:if>
										</c:if>

									</p>

									<p>
										<p style="text-align: right">珠海仲裁委员会</p>
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.tribunalMark==1}">
											<p style="text-align: right">仲裁员：${arbitratorAvoid.avoidVO.arbitratorName}</p>
										</c:if>
										<p style="text-align: right">秘书：${arbitratorAvoid.avoidVO.secretaryName}</p>
										<p style="text-align: right"><fmt:formatDate value="${arbitrationCaseJurisDis.documentContentVO.issusTime}"	pattern="yyyy年MM月dd日" /></p>
									</p>
                                </div>
	                            <!-- 拒绝模板 -->
	                            
	                            <!--审批记录-->
	                            <div class="approvel-record mgt80">
	                                <p class="approvel-record-title">审批记录</p>
	                                <ul>
	                                    <li class="first-li">
	                                        <p class="clearfix"><span class="left">涉案金额：${arbitrationCaseJurisDis.caseRequestInfoVO.caseAmount}元</span><span class="right">仲裁费用：${arbitrationCaseJurisDis.caseRequestInfoVO.totalAmount}元</span></p>
	                                    </li>
	                                    
	                                    <c:if test="${arbitrationCaseJurisDis.approveRecordVOList!=null }">
												<c:forEach items="${arbitrationCaseJurisDis.approveRecordVOList }"
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
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.duties=='2'}">
											<div class="approvel-record mgt80">
												<p class="approvel-record-title">初审意见：</p>
												<textarea class="textarea-say" style="width:900px" id="approveSuggest" placeholder="最多可以输入500个字符"></textarea>
											</div>
										</c:if>

										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.duties!='2'}">
											<div class="approvel-record mgt80">
												<p class="approvel-record-title">复审意见：</p>
												<textarea class="textarea-say" style="width:900px" id="approveSuggest" placeholder="最多可以输入500个字符"></textarea>
											</div>
										</c:if>
	                                </ul>
	                                <c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.duties=='2'}">
	                                	<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.isApplyAvoid=='1'}">
	                                		<button class="changepsd-btn border-475">申请回避</button>
	                                	</c:if>
	                                </c:if>

	                                <c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.duties=='4'}">
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.primiss=='0'}">
	                                		<button class="changepsd-btn border-475" id="rejectApprove">驳回</button>
										</c:if>
	                                </c:if>

									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.duties=='4'}">
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.primiss=='0'}">
											<button class="changepsd-btn border-475" id="getThrough">通过</button>
										</c:if>
									</c:if>

									<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.duties!='4'}">
										<c:if test="${arbitrationCaseJurisDis.arbiCaseJurisDisVO.primiss=='0'}">
											<button class="changepsd-btn border-475" id="leadApprove">呈领导审批</button>
										</c:if>
									</c:if>

	                            </div>
	                            
	                            </c:if>
	                            
	                        </div>
                        
                        
                    </div>

<script  type="text/javascript">
	var issueType;
	$(function(){
		issueType='${arbitrationCaseJurisDis.documentContentVO.issueType}';
		
		if(issueType){
			if(issueType=='0'){
				removeAgreeClass();
			}else{
				removeRejectClass();
			}
		}
	});
	
	

	//同意模板
	$("#agree").click(function(){
		issueType=0;
		removeAgreeClass();	
	})
	
	
	//拒绝模板
	$("#reject").click(function(){
		issueType=1;
		removeRejectClass();
	})
	
	//删除同意模板style
	function removeAgreeClass(){
		$("#agreeDecision").removeAttr("style");
		$("#rejectDecision").css('display','none'); 
	}
	
	//删除拒绝模板style
	function removeRejectClass(){
		$("#rejectDecision").removeAttr("style");
		$("#agreeDecision").css('display','none'); 
	}


    //呈领导审批
    $("#leadApprove").click(function(){
        var finalDecision='';
        if(issueType=='0'){
            finalDecision=$("#agreeFinalDecision").val();
        }else{
            finalDecision=$("#rejectFinalDecision").val();
        }
        examine(issueType,finalDecision,null);
    })

	//通过
	$("#getThrough").click(function(){
		var finalDecision='';
		if(issueType=='0'){
			finalDecision=$("#agreeFinalDecision").val();
		}else{
			finalDecision=$("#rejectFinalDecision").val();
		}
		examine(issueType,finalDecision,'0');
	})
	
	//驳回
	$("#rejectApprove").click(function(){
		var finalDecision='';
		if(issueType=='0'){
			finalDecision=$("#agreeFinalDecision").val();
		}else{
			finalDecision=$("#rejectFinalDecision").val();
		}
		examine(issueType,finalDecision,'1');
	})

	//审核
	function examine(issueType,finalDecision,opinionStatus){
		$.ajax({
			type:'post',  
            url:'${appCtx}/case/jurisdis/examine',  
            dataType:'json',
            data:{
            		docId:'${arbitrationCaseJurisDis.documentContentVO.docId}',
            		docContentId:'${arbitrationCaseJurisDis.documentContentVO.docContentId}',
	            	caseId:'${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseId}',
	            	requestId:'${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestId}',
	            	finalDecision:finalDecision,
	            	approveSuggest:$("#approveSuggest").val(),
	            	opinionStatus:opinionStatus,
                	issueType:issueType,
	            	approveId:'${arbitrationCaseJurisDis.arbiCaseJurisDisVO.approveId}',
	            	caseJurisDisId:'${arbitrationCaseJurisDis.arbiCaseJurisDisVO.jurisDisId}',
                	caseNo:'${arbitrationCaseJurisDis.arbiCaseJurisDisVO.caseNo}',
                	requestType:'${arbitrationCaseJurisDis.arbiCaseJurisDisVO.requestType}'
            	},  
            success:function(json){  
                if(json.head.retCode == '0000'){  
                    //成功 
                    location.reload();
                }else{  
                    //出错  
                	layer.alert(json.head.msg, {
                        skin: 'layui-layer-lan' //样式类名
                        ,closeBtn: 0
                    });  
                }  
            }  
		});
	}
</script>