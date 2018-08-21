<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../base/taglibs.jsp"%>

	<title>调解书审核</title>
	
    <div class="z-right-box z-bg-fff">
        <div class="case-main">
            <h4>珠 海 仲 裁 委 员 会 </h4>
            <h3>调 解 书</h3>
            <div class="case-main-text">
            
            	<!-- 申请人类型为自然人 -->
                <c:if test="${conciliationBook.caseDocumentsVO.propType==1 }">
	                <p style="margin-top: 24px;">
	                   	 申请人：${conciliationBook.caseDocumentsVO.propName}，
	                   	 性别：
	                    <c:if test="${conciliationBook.caseDocumentsVO.propSex==0}">
	                       	 男，
	                    </c:if>
	                    <c:if test="${conciliationBook.caseDocumentsVO.propSex==1}">
	                    	女，
	                    </c:if>
					                    民族：${conciliationBook.caseDocumentsVO.propEthnic}，
					      ${fn:substring(conciliationBook.caseDocumentsVO.propBirthday, 0, 4)}年
					      ${fn:substring(conciliationBook.caseDocumentsVO.propBirthday, 4, 6)}月
					      ${fn:substring(conciliationBook.caseDocumentsVO.propBirthday, 6, 8)}日出生，
					                    身份证号码：${conciliationBook.caseDocumentsVO.propCardId}，
					                    住所：${conciliationBook.caseDocumentsVO.propAddress}，
	                    <%-- <c:if test="${not empty conciliationBook.caseDocumentsVO.propCertName}">
	                        <p>
	                        	法定代表人：${conciliationBook.caseDocumentsVO.propCertName }，职务：${conciliationBook.caseDocumentsVO.propCertDuties }
	                        </p>
	                    </c:if> --%>
	                </p>
                </c:if>
                
                <!-- 申请人有代理人 -->
                <c:if test="${not empty conciliationBook.caseAgentVO}">
                    <p>
                    	委托代理人（律师代理）：${conciliationBook.caseAgentVO.name }，${conciliationBook.caseAgentVO.vocation }
                    </p>
                </c:if>
                
                <!-- 被申请人类型为自然人 -->
                <c:if test="${conciliationBook.caseDocumentsVO.deptType==1 }">
	                <p style="margin-top: 24px;">
	                   	 被申请人：${conciliationBook.caseDocumentsVO.depeName }，
	                   	 性别：
	                    <c:if test="${conciliationBook.caseDocumentsVO.depeSex==0}">
	                    	男，
	                    </c:if>
	                    <c:if test="${conciliationBook.caseDocumentsVO.depeSex==1}">
	                    	女，
	                    </c:if>
					                    民族：${conciliationBook.caseDocumentsVO.depeEthnic}，
					                    身份证号码：${conciliationBook.caseDocumentsVO.depeCardId}，
					                    住所：${conciliationBook.caseDocumentsVO.depeAddress}，
	                    <%-- <c:if test="${not empty conciliationBook.caseDocumentsVO.depeCertName}">
	                        <p>
	                            	法定代表人：${conciliationBook.caseDocumentsVO.depeCertName }，职务：${conciliationBook.caseDocumentsVO.depeCertDuties }
	                        </p>
	                    </c:if> --%>
	                </p>
                </c:if>
                
                <c:if test="${not empty conciliationBook.caseAgentsVO.name}">
                    <p>
                      	委托代理人（律师代理）：${conciliationBook.caseAgentsVO.name }，${conciliationBook.caseAgentsVO.vocation }
                    </p>
                </c:if>
                
            </div>
            
            <p>
               	 珠海仲裁委员会（以下简称本会）根据申请人${conciliationBook.caseDocumentsVO.propName}
               	 与被申请人${conciliationBook.caseDocumentsVO.depeName}于
               	<fmt:formatDate value="${conciliationBook.caseInfo.signTime}" pattern="yyyy年MM月dd日"/>
               	 签订的《${conciliationBook.caseInfo.protocolName}》中的仲裁条款和申请人的仲裁申请，于
               	<fmt:formatDate value="${conciliationBook.caseInfo.caseAcceptanceTime}" pattern="yyyy年MM月dd日"/>
               	受理了申请人关于${conciliationBook.caseInfo.caseTypeId}的仲裁申请。
            	根据《珠海仲裁委员会互联网金融仲裁规则》（以下简称《仲裁规则》）第  条的规定，本会向被申请人送达了仲裁受理通知书、仲裁申请书副本、仲裁规则、仲裁员名册等材料。
	            <%--是双方选定仲裁员--%>
	            <c:if test="${conciliationBook.caseDocumentsVO.caseArbiType==1}">
	            	在本会《仲裁规则》规定期限内，双方共同选定仲裁员${conciliationBook.caseDocumentsVO.arbitratorName}
	            	组成独任仲裁庭，仲裁庭于<fmt:formatDate value="${conciliationBook.caseInfo.acceptTime}" pattern="yyyy年MM月dd日"/>
	            	成立。本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。
	            </c:if>
            </p>
            
            <h4>一、仲裁请求</h4>
            <div class="case-main-contain">
                <p>
                	申请人向本会提出如下仲裁请求：${conciliationBook.caseDocumentsVO.arbClaim }
                </p>
            </div>
            
            <div class="case-main-contain">
                <p>
                	其事实和理由是：
                	${conciliationBook.caseDocumentsVO.fact }
                	${conciliationBook.caseDocumentsVO.reason }
                </p>
            </div>
            <div class="case-main-contain">
                <p>
                	仲裁过程中，申请人、被申请人自愿达成如下和解协议：${conciliationBook.caseProtocolRecordVO.protocolContent}
                </p>
            </div>
            <div class="case-main-contain">
                <p>
                	根据《中华人民共和国仲裁法》第四条、第七条、第四十九条、第五十二条，仲裁庭认为，上述和解协议是申请人与被申请人的真实意思表示，没有违反法律、行政法规的强制性规定，仲裁庭予以确认。
                	本案已预收仲裁费用${conciliationBook.caseDocumentsVO.caseAdmissibleAmount+conciliationBook.caseDocumentsVO.caseHandlingAmount}元，本会不予退回。
					本调解书自双方当事人签收之日起发生法律效力。
                </p>
            </div>
            <div class="case-main-contain">
                ${conciliationBook.caseDocumentsVO.finalDecision }
            </div>
            <div class="case-main-contain">
                <p>此致</p>
                <p>珠海仲裁委员会 </p>
            </div>
            <div class="case-main-lastname">
                <p>仲裁员：${conciliationBook.caseDocumentsVO.arbitratorName }</p>
                <p>${conciliationBook.caseDocumentsVO.issusTime }</p>
                <p>秘书：${conciliationBook.caseDocumentsVO.secretaryName }</p>
            </div>

            <div class="enclosure1 ">
                <!--当前用户为副主任或者主任 -->
                <c:if test="${conciliationBook.managerInfo.duties=='4'||conciliationBook.managerInfo.duties=='5'}">
                    <!--审批记录-->
                    <div class="approvel-record mgt80">
                        <p class="approvel-record-title">审批记录</p>
                        <ul>
                            <c:if test="${!empty conciliationBook.approveRecordList }">
                                <c:forEach items="${conciliationBook.approveRecordList }"
                                    	var="approveRecordList">
                                    <c:if test="${approveRecordList.duties=='2'}">
                                        <li>
                                            <p>
                                                <fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
                                                    value="${approveRecordList.createTime}" />
                                            </p>
                                            ${fn:substring(approveRecordList.approveName, 0, 1)}秘书初审意见：
                                            <p class="pdl50">${approveRecordList.approveSuggest }</p>
                                        </li>
                                    </c:if>

                                    <c:if test="${approveRecordList.duties=='3'}">
                                        <li>
                                            <p>
                                                <fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
                                                    value="${approveRecordList.createTime}" />
                                            </p>
                                            ${fn:substring(approveRecordList.approveName, 0, 1)}部长复审意见：
                                            <p class="pdl50">${approveRecordList.approveSuggest }</p>
                                        </li>
                                    </c:if>

                                    <c:if test="${approveRecordList.duties=='5'}">
                                        <li>
                                            <p>
                                                <fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
                                                    value="${approveRecordList.createTime}" />
                                            </p>
                                            ${fn:substring(approveRecordList.approveName, 0, 1)}副主任复审意见：
                                            <p class="pdl50">${approveRecordList.approveSuggest }</p>
                                        </li>
                                    </c:if>

                                    <c:if test="${approveRecordList.duties=='4'}">
                                        <li>
                                            <p>
                                                <fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
                                                    value="${approveRecordList.createTime}" />
                                            </p>
                                            ${fn:substring(approveRecordList.approveName, 0, 1)}主任复审意见：
                                            <p class="pdl50">${approveRecordList.approveSuggest }</p>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </ul>
                    </div>
                </c:if>
                
                <div class="approvel-record mgt80">
                    <p class="approvel-record-title">审批意见</p>
                    <textarea class="textarea-say"
                        placeholder="最多可输入500个字符" style="width:900px"></textarea>
                </div>

                <div class="bottom-button">
                    <c:if test="${conciliationBook.managerInfo.duties=='3' || conciliationBook.managerInfo.duties=='4' || conciliationBook.managerInfo.duties=='5'}">
                        <c:if test="${conciliationBook.managerInfo.duties==conciliationBook.approveDuties}">
	                        <button id="btn3" onclick="btn3()" class="avoidanceapply bg475 mgt100">反馈修改意见</button>
	                        <button id="btn5" onclick="btn5()" class="avoidanceapply mgt100">通过</button>
                    	</c:if>
                    </c:if>

                    <c:if test="${conciliationBook.managerInfo.duties=='2'}">
                    	<c:if test="${conciliationBook.managerInfo.duties==conciliationBook.approveDuties}">
	                        <button id="btn1" onclick="btn1()" class="avoidanceapply bg475 mgt100">申请回避</button>
	                        <button id="btn6" onclick="btn6()" class="avoidanceapply mgt100">呈领导审批</button>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <script src="${appCtx}/static/vendor/jquery-2.1.1.min.js"></script>
	<script src="${appCtx}/static/vendor/layer/layer.js"></script>
	<script type="text/javascript">
		function btn1() { //秘书申请回避
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
		
		function btn6() { //秘书呈领导审批
			layer.open({
				title : false,
				content : '是否确认呈领导审批？',
				btn : [ '确定', '取消' ],
				offset : [ '200', '500' ],
				yes : function() {
					var approveId = "${conciliationBook.approveId}";
					var opinionStatus = "0";
					var caseId = "${conciliationBook.caseId}";
					var approveSuggest = $(".textarea-say").val();
					$.ajax({
						url : "${appCtx}/case/conciliation/audit",
						type : "POST",
						dataType : 'json',
						data : {
							'approveId' : approveId,
							'opinionStatus' : opinionStatus,
							'approveSuggest' : approveSuggest,
							'caseId' : caseId
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
		
		function btn3() {	//部长主任副主任驳回案件
			layer.open({
				title : false,
				content : '您选择的是反馈修改意见,调解书将返回给仲裁庭修改 ?',
				btn : [ '确定', '取消' ],
				offset : [ '200', '500' ],
				yes : function() {
					var approveId = "${conciliationBook.approveId}";
					var opinionStatus = "1";
					var caseId = "${conciliationBook.caseId}";
					var approveSuggest = $(".textarea-say").val();
					$.ajax({
						url : "${appCtx}/case/conciliation/audit",
						type : "POST",
						dataType : 'json',
						data : {
							'approveId' : approveId,
							'opinionStatus' : opinionStatus,
							'approveSuggest' : approveSuggest,
							'caseId' : caseId
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
		
		function btn5() { //部长主任副主任通过案件
			layer.open({
				title : false,
				content : '是否确认通过?',
				btn : [ '确定', '取消' ],
				offset : [ '200', '500' ],
				yes : function() {

					var approveId = "${conciliationBook.approveId}";
					var opinionStatus = "0";
					var caseId = "${conciliationBook.caseId}";
					var approveSuggest = $(".textarea-say").val();
					$.ajax({
						url : "${appCtx}/case/conciliation/audit",
						type : "POST",
						dataType : 'json',
						data : {
							'approveId' : approveId,
							'opinionStatus' : opinionStatus,
							'approveSuggest' : approveSuggest,
							'caseId' : caseId
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