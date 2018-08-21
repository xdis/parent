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
		<h3>仲裁裁决书审批</h3>
		<h4 class="h4-title">株仲裁字${auditRulingBookVO.caseDocVO.docYearNumber}第${auditRulingBookVO.caseDocVO.docSerialNumber}号</h4>
		<div class="case-main-text">
			<p>
				<span>申 请 人：</span><span>${auditRulingBookVO.caseDocVO.propName}</span>
				<c:if
					test="${auditRulingBookVO.caseDocVO.propType=='0'}"> <!--个人 -->
					<span>,</span>
					<span>${auditRulingBookVO.caseDocVO.propSex==0?'男':'女'}</span>
					<span>,</span>
					<span>${auditRulingBookVO.caseDocVO.propEthnic}</span>
				</c:if>
			</p>
			<p>
				<span>住所：</span><span>${auditRulingBookVO.caseDocVO.propAddress}</span>
			</p>
			<c:if
				test="${auditRulingBookVO.caseDocVO.propType=='1'}"> <!--企业  -->
				<p>
					<span>法定代表人：</span><span>${auditRulingBookVO.caseDocVO.propCertName}</span>
					<span>职务：</span><span>${auditRulingBookVO.caseDocVO.propCertDuties}</span>
				</p>
			</c:if>
			<c:if
				test="${auditRulingBookVO.caseDocVO.propAgentName!=null}">
				<p>
					<span>委托代理人：</span><span>${auditRulingBookVO.caseDocVO.propAgentName}，${auditRulingBookVO.caseDocVO.propAgentDuties}</span>
				</p>
			</c:if>

			<p>
				<span>被申请人：</span><span>${auditRulingBookVO.caseDocVO.depeName}</span>
				<c:if
					test="${auditRulingBookVO.caseDocVO.deptType=='0'}"> <!-- 自然人 -->
					<span>,</span>
					<span>${auditRulingBookVO.caseDocVO.depeSex==0?'男':'女'}</span>
					<span>,</span>
					<span>${auditRulingBookVO.caseDocVO.depeEthnic}</span>
				</c:if>
			</p>

			<p>
				<span>住所：</span><span>${auditRulingBookVO.caseDocVO.depeAddress}</span>
			</p>

			<c:if
				test="${auditRulingBookVO.caseDocVO.deptType=='1'}">	<!-- 企业 -->
				<p>
					<span>法定代表人：</span><span>${auditRulingBookVO.caseDocVO.depeCertName}</span><span>职务：</span><span>${auditRulingBookVO.caseDocVO.depeCertDuties}</span>
				</p>
			</c:if>

			<c:if
				test="${auditRulingBookVO.caseDocVO.depeAgentName!=null}">
				<p>
					<span>委托代理人：</span><span>${auditRulingBookVO.caseDocVO.depeAgentName}，${auditRulingBookVO.caseDocVO.depeAgentDuties}</span>
				</p>
			</c:if>
		</div>
		<div class="case-main-contain">
			<p>正文</p>
			<p>${auditRulingBookVO.caseDocVO.bodyText}</p>

		</div>
		<div class="case-main-contain">
			<p>意见</p>
			<p>${auditRulingBookVO.caseDocVO.opinion}</p>
		</div>
		
		<div class="case-main-contain">
			<p>最终决定</p>
			<p>${auditRulingBookVO.caseDocVO.finalDecision}</p>
		</div>
		
		<div class="case-main-lastname">
			<p>
				仲裁员：<span>${auditRulingBookVO.caseDocVO.arbiName}</span>
			<p>
				<!-- 立案时间 -->
				<fmt:formatDate pattern="yyyy年MM月dd日"
					value="${auditRulingBookVO.caseDocVO.issusTime}" />
			</p>
			秘书：<span>${auditRulingBookVO.caseDocVO.managerName}</span>
			
			
		</div>
		<div class="enclosure1 ">
			<c:if
				test="${auditRulingBookVO.duties=='2'||auditRulingBookVO.duties=='3'||auditRulingBookVO.duties=='4'||auditRulingBookVO.duties=='5'}">
				<!--当前用户为秘书，部长或者主任 -->

				<!--审批记录-->
				<div class="approvel-record mgt80">
					<p class="approvel-record-title">审批记录</p>
					<ul>
						<c:if test="${!empty auditRulingBookVO.approveRecordList }">
							<c:forEach items="${auditRulingBookVO.approveRecordList }"
								var="approveRecordList">
								<c:if test="${approveRecordList.duties=='2'}">
									<li>
										<p>
										<fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
												value="${approveRecordList.createTime}" />
										</p> ${fn:substring(approveRecordList.approveName, 0, 1)}秘书初审意见：
										<p class="pdl50">${approveRecordList.approveSuggest }</p>
									</li>
								</c:if>

								<c:if test="${approveRecordList.duties=='3'}">
									<li>
										<p>
											<fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
												value="${approveRecordList.createTime}" />
										</p> ${fn:substring(approveRecordList.approveName, 0, 1)}部长复审意见：
										<p class="pdl50">${approveRecordList.approveSuggest }</p>
									</li>
								</c:if>

								<c:if test="${approveRecordList.duties=='5'}">
									<li>
										<p>
											<fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
												value="${approveRecordList.createTime}" />
										</p> ${fn:substring(approveRecordList.approveName, 0, 1)}副主任复审意见：
										<p class="pdl50">${approveRecordList.approveSuggest }</p>
									</li>
								</c:if>

								<c:if test="${approveRecordList.duties=='4'}">
									<li>
										<p>
											<fmt:formatDate pattern="yyyy-MM-dd  HH:mm"
												value="${approveRecordList.createTime}" />
										</p> ${fn:substring(approveRecordList.approveName, 0, 1)}主任复审意见：
										<p class="pdl50">${approveRecordList.approveSuggest }</p>
									</li>
								</c:if>
							</c:forEach>
						</c:if>


					</ul>
				</div>

				<div class="approvel-record mgt80">
					<p class="approvel-record-title">审批意见</p>
					<textarea id="approveSuggest" class="first-comments"
						placeholder="最多可输入500个字符" style="width:900px"></textarea>
				</div>
			</c:if>

			<div class="bottom-button">
				<c:if
					test="${auditRulingBookVO.duties=='5'}">
					<c:if test="${auditRulingBookVO.duties==auditRulingBookVO.approveDuties}"> <!--副主任 -->
						<button id="btn3" onclick="btn3()" class="avoidanceapply bg475 mgt100">反馈修改意见</button>
						<button id="btn5" onclick="btn5()" class="avoidanceapply mgt100">通过</button>
					</c:if>
					
				</c:if>

				<c:if test="${auditRulingBookVO.duties=='2'}">
					<c:if test="${auditRulingBookVO.duties==auditRulingBookVO.approveDuties}">
						<button id="btn1" onclick="btn1()" class="avoidanceapply bg475 mgt100">申请回避</button>
						<!-- 秘书呈领导审批，需要上传仲裁申请费 -->
						<button id="btn6" onclick="btn6()" class="avoidanceapply mgt100">呈领导审批</button>
					</c:if>
				</c:if>

				<c:if test="${auditRulingBookVO.duties=='4'||auditRulingBookVO.duties=='3'}">
					<!-- 部长呈领导审批 -->
					<c:if test="${auditRulingBookVO.duties==auditRulingBookVO.approveDuties}">
						<button id="btn3" onclick="btn3()" class="avoidanceapply bg475 mgt100">反馈修改意见</button>
						<button id="btn2" onclick="btn2()" class="avoidanceapply mgt100">通过</button>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
</div>


<script src="${appCtx}/static/js/jquery-3.2.1.min.js"></script>
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


	function btn2() { // 副主任部长呈领导审批
		layer.open({
			title : false,
			content : '您选择的是通过,裁决书将提交到上级领导审核,确认提交 ?',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {
				var approveId = "${auditRulingBookVO.approveId}";
				var opinionStatus = "0";
				var caseId = "${auditRulingBookVO.caseId}";
				var approveSuggest = $(" #approveSuggest").val();

				$.ajax({
					url : "${appCtx}/ruling/audit/auditRulingBook",
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


	function btn6() { //秘书呈领导审批
		layer.open({
			title : false,
			content : '秘书是否确认呈领导审批？',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {

				var approveId = "${auditRulingBookVO.approveId}";
				var opinionStatus = "0";
				var caseId = "${auditRulingBookVO.caseId}";
				var approveSuggest = $(" #approveSuggest").val();

				$.ajax({
					url : "${appCtx}/ruling/audit/auditRulingBook",
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


	function btn3() { //主任副主任部长驳回
		layer.open({
			title : false,
			content : '您选择的是反馈修改意见,裁决书将返回给仲裁庭修改 ?',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {

				var approveId = "${auditRulingBookVO.approveId}";
				var opinionStatus = "1";
				var caseId = "${auditRulingBookVO.caseId}";
				var approveSuggest = $(" #approveSuggest").val();

				$.ajax({
					url : "${appCtx}/ruling/audit/auditRulingBook",
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


	function btn5() { //主任通过案件
		layer.open({
			title : false,
			content : '您的审批意见是通过,裁决书盖章后将直接发送到当事人,确认提交 ?',
			btn : [ '确定', '取消' ],
			offset : [ '200', '500' ],
			yes : function() {

				var approveId = "${auditRulingBookVO.approveId}";
				var opinionStatus = "0";
				var caseId = "${auditRulingBookVO.caseId}";
				var approveSuggest = $(" #approveSuggest").val();

				$.ajax({
					url : "${appCtx}/ruling/audit/auditRulingBook",
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
<footer class="common-footer">
	<span>版权所有@ 珠海仲裁委员会 | 未经书面协议授权禁止下载或建立镜像</span> <span>联系我们 |
		新闻公告  | 友情链接</span> <span> 粤ICP备13053290号 |  粤公网安备11010502025090</span>
</footer>
