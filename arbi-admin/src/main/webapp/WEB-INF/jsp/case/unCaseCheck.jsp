<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
<link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>

    <div class="z-right-box z-bg-fff">
        <div class="case-main">
            <p class="case-main-nocase"><span class="leftspan">本请求撤案</span><span id="counterclaim-withdraw-case">反请求撤案</span></p>
            <div class="unCasecheck mgt87">
            	<h4 class="h4-title">撤回仲裁<c:if test="${withdrawCaseVO.requestType== '1'}">反请求</c:if>申请书</h4>
            	<p> 珠海仲裁委员会：</p>
           		<p>针对贵会受理的<span>${withdrawCaseVO.caseBaseInfo.caseNo}案，我方请求撤回仲裁<c:if test="${withdrawCaseVO.requestType== '1'}">反请求.</c:if><c:if test="${withdrawCaseVO.requestType== '0'}">申请。</c:if></span></p>
           		<p>理由是${withdrawCaseVO.withdrawRecord.fact}。</p>
           		<div>
	           		<p>此致</p>
	           		<p>珠海仲裁委员会</p>
           		</div>
           		<div>
	           		<p>${withdrawCaseVO.caseBaseInfo.applicantName}</p>
	           		<p><fmt:formatDate value="${withdrawCaseVO.withdrawRecord.createTime}" pattern="yyyy年MM月dd日"/></p>
           		</div>
           	</div>
           	<h5>审核</h5>
           	<div>
				<button onclick="avoidanceapply()">申请回避</button>
				<button onclick="disagree()">拟不同意</button>         	
				<button onclick="agree()">出撤案决定书</button>
           	</div>
           	<div class="withdraw-decision">
                <h4 class="h4-title">珠 海 仲 裁 委 员 会</h4>
                <h4 class="h4-title">决 定 书</h4>
                <div class="case-main-text">
                	<p>${withdrawCaseVO.caseBaseInfo.caseNo}</p>
                    <p><span>申  请  人：</span><span>${withdrawCaseVO.caseBaseInfo.applicantName}</span></p>
                    <c:if test="${!empty withdrawCaseVO.caseBaseInfo.applicantAttorney}">
                    	<p><span>委托代理人：</span><span>${withdrawCaseVO.caseBaseInfo.applicantAttorney}，${withdrawCaseVO.caseBaseInfo.applicantAttorneyJob}</span></p>
                    </c:if>
                    <p><span>被申请人：</span><span>${withdrawCaseVO.caseBaseInfo.beApplicantName}</span></p>
                    <c:if test="${!empty withdrawCaseVO.caseBaseInfo.beApplicantAttorney}">
                    	<p><span>委托代理人：</span><span>${withdrawCaseVO.caseBaseInfo.beApplicantAttorney}，${withdrawCaseVO.caseBaseInfo.beApplicantAttorneyJob}</span></p>
                    </c:if>
                </div>
            </div>
            <div class="write-content clearfix">
                <p>
                	珠海仲裁委员会（以下简称本会）于<fmt:formatDate value="${withdrawCaseVO.caseAcceptTime}" pattern="yyyy年MM月dd日"/>
                	受理了申请人${withdrawCaseVO.caseBaseInfo.applicantName}与被申请人${withdrawCaseVO.caseBaseInfo.beApplicantName}
                	关于${withdrawCaseVO.caseBaseInfo.caseType}一案。
                </p>
                <p>
                	<!-- 仲裁员选择类型 -->
                	<c:choose>
	                	<c:when test="${withdrawCaseVO.arbitratorAcceptType == '0'}">
	                		双方当事人未在规定期限内共同选定或共同委托本会主任指定独任仲裁员，根据《中华人民共和国仲裁法》（以下简称《仲裁法》）第三十二条、《仲裁规则》第  条的规定，
	                		本会主任指定${withdrawCaseVO.trinualNotice.arbitratorName}为本案独任仲裁员，仲裁庭于<fmt:formatDate value="${withdrawCaseVO.trinualNotice.createTime}" pattern="yyyy年MM月dd日"/>成立。本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。
	                	</c:when>
	                	<c:otherwise>
	                		在本会《仲裁规则》规定期限内，双方共同选定仲裁员${withdrawCaseVO.trinualNotice.arbitratorName}组成独任仲裁庭，仲裁庭于<fmt:formatDate value="${withdrawCaseVO.trinualNotice.createTime}" pattern="yyyy年MM月dd日"/>成立。
	                		本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。
	                	</c:otherwise>
                	</c:choose>
                </p>	
                
               	<!-- 撤案类型(当事人撤案/双方撤案) -->
               	<c:choose>
               		<c:when test="${withdrawCaseVO.withdrawCaseType == '0'}">
               			<p>申请人于<fmt:formatDate value="${withdrawCaseVO.withdrawRecord.createTime}" pattern="yyyy年MM月dd日"/>向本会提交了撤回仲裁申请书。</p>
               			<p>本会认为，申请人自愿向本会撤回仲裁申请，系其对权利的自行处分，不违反法律规定，本会予以准许。依照《中华人民共和国仲裁法》第五十六条之规定，决定如下：</p>
               			<p>同意申请人撤回仲裁申请，结束本案仲裁程序。</p>
               		</c:when>
               		<c:otherwise>
               			<c:choose>
               				<c:when test="${withdrawCaseVO.requestType == '0'}">
               					<p>申请人与被申请人分别于
               						<fmt:formatDate value="${withdrawCaseVO.withdrawRecord.createTime}" pattern="yyyy年MM月dd日"/>、
               						<fmt:formatDate value="${withdrawCaseVO.oppositeWithdrawRecordCreateTime}" pattern="yyyy年MM月dd日"/>
               							向本会提交了撤回仲裁申请书和撤回仲裁反请求申请书。
               					</p>
               				</c:when>
               				<c:otherwise>
               					<p>申请人与被申请人分别于
               						<fmt:formatDate value="${withdrawCaseVO.oppositeWithdrawRecordCreateTime}" pattern="yyyy年MM月dd日"/>、
               						<fmt:formatDate value="${withdrawCaseVO.withdrawRecord.createTime}" pattern="yyyy年MM月dd日"/>
               							向本会提交了撤回仲裁申请书和撤回仲裁反请求申请书。
               					</p>
               				</c:otherwise>
               			</c:choose>
               			<p>本会认为，双方当事人自愿向本会撤回仲裁申请，系双方当事人对权利的自行处分，不违反法律规定，本会予以准许。依照《中华人民共和国仲裁法》第五十六条之规定，决定如下：</p>
               			<p>同意双方当事人撤回仲裁申请，结束本案仲裁程序。</p>
               		</c:otherwise>
               	</c:choose>
               	
               	<!-- 是否有退费，是否有反请求 -->
               	<c:choose>
               		<c:when test="${withdrawCaseVO.couterclaimArbiFee == null}">
               			<c:choose>
               				<c:when test="${withdrawCaseVO.requestRefund == 0 || withdrawCaseVO.requestRefund == null}">
               					<p>本案仲裁费用${withdrawCaseVO.requestArbiFee}元（该笔费用已由申请人预交）由申请人承担。</p>
               				</c:when>
               				<c:otherwise>
               					<p>本案仲裁费用xxx元（由系统在缴费通知中抓取，包括本请求仲裁费用、变更仲裁请求费用）（该笔费用已由申请人预交）由申请人承担xxx元，余款xxx元，由本会退回给申请人。</p>
               				</c:otherwise>
               			</c:choose>
               		</c:when>
               		<c:otherwise>
               			<c:choose>
               				<c:when test="${withdrawCaseVO.requestRefund == 0 || withdrawCaseVO.requestRefund == null}">
               					本案本请求仲裁费用xxx元（由系统在缴费通知中抓取，包括本请求仲裁费用、变更仲裁请求费用）（该笔费用已由申请人预交）由申请人承担，本案反请求仲裁费用xxx元（由系统在缴费通知中抓取反请求仲裁费用）（该笔费用已由被申请人预交）由被申请人承担。
               				</c:when>
               				<c:otherwise>
               					本案本请求仲裁费用xxx元（由系统在缴费通知中抓取，包括本请求仲裁费用、变更仲裁请求费用）（该笔费用已由申请人预交）由申请人承担xxx元，余款xxx元，由本会退回给申请人。本案反请求仲裁费用xxx元（由系统在缴费通知中抓取反请求仲裁费用）（该笔费用已由被申请人预交）由被申请人承担xxx元，余款xxx元，由本会退回给被申请人。
               				</c:otherwise>
               			</c:choose>
               		</c:otherwise>
               	</c:choose>
                
                <p>珠海仲裁委员会</p>
                <c:if test="withdrawCaseVO.caseApprove.tribunalMark=='1'">
                	<p>仲裁员：${withdrawCaseVO.caseDocContent.arbitratorName}</p>
                </c:if>
                <p></p><!-- 发送时间 -->
                <p>秘书：${withdrawCaseVO.caseDocContent.arbiSecretaryName}</p>
                
            </div>
            <c:choose>
            	<c:when test="${withdrawCaseVO.currentDuties=='2' && withdrawCaseVO.caseApprove.tribunalMark=='0'}">
            		 <div class="approvel-record mgt80">
            		 	<p>审批</p>
            		 	<c:if test="${fn:length(withdrawCaseVO.caseApproveSuggests) > 0}">
            		 		<p class="approvel-record-title">审批记录</p>
			                <ul>
			                	<c:forEach var="approve" items="${withdrawCaseVO.caseApproveSuggests}">
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
            		 	</c:if>
            		 	<div class="bottom-button">
		                	<button id="btn1" onclick="avoidanceapply()" class="avoidanceapply bg475 mgt100">申请回避</button>
		                	<c:choose>
		                		<c:when test="${withdrawCaseVO.caseApprove.tribunalMark == '0'}">
		                			<button id="btn3" onclick="submit()" class="submit  bg475 mgt100">提交</button>
		                		</c:when>
		                		<c:otherwise>
					                <button id="btn3" onclick="approve()" class="submit  bg475 mgt100">呈领导审批</button>
		                		</c:otherwise>
		                	</c:choose>
		                </div>
            		 </div>
            	</c:when>
            	<c:otherwise>
            		<!--审批记录-->
		            <div class="approvel-record mgt80">
	                	<p>审批</p>
	                	<c:if test="${fn length(withdrawCaseVO.caseApproveSuggests) > 0}">
	                		<div>
	                			<p class="approvel-record-title">审批记录</p>
				                <ul>
				                	<c:forEach var="approve" items="${withdrawCaseVO.caseApproveSuggests}">
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
		                		<c:when test="${withdrawCaseVO.currentDuties=='2'}">
					                <button id="btn1" onclick="avoidanceapply()" class="avoidanceapply bg475 mgt100">申请回避</button>
	                				<button id="btn3" onclick="approve()" class="submit mgt100  ">呈领导审批</button>
		                		</c:when>
		                		<c:otherwise>
		                			<c:choose>
			                		<c:when test="${withdrawCaseVO.caseApprove.tribunalMark=='0'}">
			                			<button id="btn1" onclick="suggest()" class="advise bg475 mgt100">驳回</button>
			                		</c:when>
			                		<c:otherwise>
					                	<button id="btn1" onclick="suggest()" class="advise bg475 mgt100">反馈修改意见</button>
			                		</c:otherwise>
			                	</c:choose>
				                <button id="btn2" onclick="pass()" class="pass bg475 mgt100">通过</button>
		                		</c:otherwise>
		                	</c:choose>
		                </div>
		            </div>
            	</c:otherwise>
            </c:choose>
        </div>

    </div>

<script type="text/javascript">
	var requestType = '${withdrawCaseVO.requestType}';
	var approveId = '${withdrawCaseVO.caseApprove.id}';
	var issueType = "${withdrawCaseVO.docIssueType}";
	
	//初始化
	$(function(){
		if(requestType == "1"){
			$('.z-right-box .case-main-nocase span').eq(1).addClass('rightspan');
		}else{
			$('.z-right-box .case-main-nocase span').eq(0).addClass('leftspan');
		}
		
		
		if(!issueType || issueType == "0"){
			issueType=0;
			$('#disagreeTemplate').removeAttr("checked");
			$('#agreeTemplate').attr("checked","true");
		}else{
			issueType=1;
			$('#disagreeTemplate').attr("checked","true");
			$('#agreeTemplate').removeAttr("checked");
		}
	});
	
	//本请求/反请求
	var withdrawType = requestType == '0' ? "withdrawArbitrationRequest" : "withdrawArbitrationCounterclaim";
	
	// 本请求/反请求撤案点击
	var requestWithdrawCase = $('.z-right-box .case-main-nocase span:first');
	var counterclaimWithdrawCase = $('.z-right-box .case-main-nocase span:last');
	
	requestWithdrawCase.click(function(){
		$(this).addClass('leftspan');
		counterclaimWithdrawCase.removeClass('rightspan');
		requestType = '0';
	});
	counterclaimWithdrawCase.click(function(){
		$(this).addClass('rightspan');
		requestWithdrawCase.removeClass('leftspan');
		requestType = '1';
	});
	
	//模板选择
	$('#agreeTemplate').click(function(){
		$('#disagreeTemplate').removeAttr("checked");
		issueType = 0;
	});
	$('#disagreeTemplate').click(function(){
		$('#agreeTemplate').removeAttr("checked");
		issueType = 1;
	});
	
	//秘书提交内容
	function submit(){
		layer.open({
			title : false,
			content : '撤案决定书呈上级领导审批，确认提交？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes :function(index){
				var params = {
					"approveId"      : approveId,
					"bodyText"       : $('#textBody').val(),
					"finalDecision"  : $('#finalDecision').val(),
					"issueType"      : issueType
				}
				$.ajax({
					url:"${appCtx}/case/"+withdrawType+"/reviewContent",
					method:"POST",
					data:params,
					success : function(data) {

						var retCode = data.head.retCode;
						var msg = data.head.msg;

						if (retCode == '0000') {
							window.location.href = '${appCtx}/case/caseinfo/list';
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
			
		});
	}
	
	//呈领导审批
	function approve(){
		var cont = '<p>您的审批意见是<span>通过</span></p><p>决定书将提交到上级领导审批，确认提交？</p>';
		layer.open({
			title : false,
			content : cont,
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes :function(index){
				var params = {
					"approveId"      : approveId,
					"approveSuggest" : $('#approveSuggest').val()
				}
				$.ajax({
					url:"${appCtx}/case/"+withdrawType+"/reviewContent",
					method:"POST",
					data:params,
					success : function(data) {

						var retCode = data.head.retCode;
						var msg = data.head.msg;

						if (retCode == '0000') {
							window.location.href = '${appCtx}/case/caseinfo/list';
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
			
		});
	}
	
	//驳回
	function suggest(){
		var cont;
		if('${withdrawCaseVO.caseApprove.tribunalMark}'=='0'){
			cont = '<p>您选择的是驳回</p><p>决定书将返回给秘书修改？</p>';
		}else{
			cont = '<p>您的审批意见是通过</p><p>决定书盖章后将直接发送到当事人，确认提交？</p>';
		}
		layer.open({
			title : false,
			content : cont,
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes :function(index){
				var params = {
					"opinionStatus"  : "1",
					"approveId"      : approveId,
					'issueType'      : issueType,
					"approveSuggest" : $('#approveSuggest').val()
				}
				$.ajax({
					url:"${appCtx}/case/"+withdrawType+"/reviewContent",
					method:"POST",
					data:params,
					success : function(data) {

						var retCode = data.head.retCode;
						var msg = data.head.msg;

						if (retCode == '0000') {
							window.location.href = '${appCtx}/case/caseinfo/list';
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
			
		});
	}
	
	//通过
	function pass(){
		layer.open({
			title : false,
			content : '撤案决定书呈上级领导审批，确认提交？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes :function(index){
				var params = {
					"opinionStatus"  : "0",
					"approveId"      : approveId,
					'issueType'      : issueType,
					"approveSuggest" : $('#approveSuggest').val()
				}
				$.ajax({
					url:"${appCtx}/case/"+withdrawType+"/reviewContent",
					method:"POST",
					data:params,
					success : function(data) {

						var retCode = data.head.reCode;
						var msg = data.head.msg;

						if (retCode == '0000') {
							window.location.href = '${appCtx}/case/caseinfo/list';
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
			
		});
	}
</script>