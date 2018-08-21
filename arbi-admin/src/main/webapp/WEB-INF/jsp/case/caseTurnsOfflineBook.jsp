<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../base/taglibs.jsp"%>
<%
	String path = request.getContextPath();
%>
<base href="<%=path%>/">

	<title>案件转线下申请审核</title>
	<link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/numberCount.css"/>
    <link rel="stylesheet" href="static/css/userIndex.css"/>
	
    <div class="zhong-right z-bg-fff min-height450" style="padding: 35px;">
        <div class="case-main">
            <h3>案件转线下申请</h3>
            <div class="case-main-lastname">
                <p>原因：${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.cause }</p>
                <c:if test="${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.createrIdDuties=='2' }">
                	<p>来自${fn:substring(caseTurnsOfflineRecordVO.createrName, 0, 1)}秘书</p>
               	</c:if>
               	<c:if test="${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.createrIdDuties=='3' }">
                	<p>来自${fn:substring(caseTurnsOfflineRecordVO.createrName, 0, 1)}部长</p>
               	</c:if>
               	<c:if test="${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.createrIdDuties=='5' }">
                	<p>来自${fn:substring(caseTurnsOfflineRecordVO.createrName, 0, 1)}副主任</p>
               	</c:if>
               	<c:if test="${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.createrIdDuties=='4' }">
                	<p>来自${fn:substring(caseTurnsOfflineRecordVO.createrName, 0, 1)}主任</p>
               	</c:if>
            </div>

            <div class="enclosure1 ">
                <!--当前用户为副主任或者主任 -->
                <c:if test="${caseTurnsOfflineRecordVO.duties=='4'||caseTurnsOfflineRecordVO.duties=='5'}">
                    <!--审批记录-->
                    <div class="approvel-record mgt80">
                        <p class="approvel-record-title">审批记录</p>
                        <ul>
                            <c:if test="${!empty caseTurnsOfflineRecordVO.approveRecorList}">
                                <c:forEach items="${caseTurnsOfflineRecordVO.approveRecorList}"
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
                    <textarea class="role-describe"
                        placeholder="最多可输入500个字符" style="width:900px"></textarea>
                </div>

                <div class="bottom-button">
                	<button onclick="btn1()" class="avoidanceapply bg475 mgt100">驳回</button>
                    &emsp;
                    <button onclick="btn2()" class="avoidanceapply mgt100">通过</button>
                </div>
            </div>
        </div>
    </div>
    
    <script src="static/vendor/jquery-2.1.1.min.js"></script>
	<script src="static/vendor/layer/layer.js"></script>
	
	<script type="text/javascript">
		function btn1() {	//部长主任副主任驳回案件
			layer.open({
				title : false,
				content : '您选择的是驳回，案件继续',
				btn : [ '确定', '取消' ],
				offset : [ '200', '500' ],
				yes : function() {
					var approveId = "${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.id}";
					var opinionStatus = "1";
					var caseId = "${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.caseId}";
					var approveSuggest = $(".role-describe").val();
					$.ajax({
						url : "${appCtx}/case/turns/offline/audit",
						type : "POST",
						dataType : 'json',
						data : {
							'approveId' : approveId,
							'opinionStatus' : opinionStatus,
							'approveSuggest' : approveSuggest,
							'caseId' : caseId
						},
						success : function(data) {
							var retCode = data.head.retCode;
							var msg = data.head.msg;
							if (retCode == '0000') {
								//成功 
								location.reload();
							} else {
								//出错  
								layer.alert(msg, {
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
		
		function btn2() { //部长主任副主任通过案件
			layer.open({
				title : false,
				content : '是否确认通过?',
				btn : [ '确定', '取消' ],
				offset : [ '200', '500' ],
				yes : function() {
					var approveId = "${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.id}";
					var opinionStatus = "0";
					var caseId = "${caseTurnsOfflineRecordVO.caseTurnsOfflineRecord.caseId}";
					var approveSuggest = $(".role-describe").val();
					$.ajax({
						url : "${appCtx}/case/turns/offline/audit",
						type : "POST",
						dataType : 'json',
						data : {
							'approveId' : approveId,
							'opinionStatus' : opinionStatus,
							'approveSuggest' : approveSuggest,
							'caseId' : caseId
						},
						success : function(data) {
							var retCode = data.head.retCode;
							var msg = data.head.msg;
							if (retCode == '0000') {
								//成功 
								location.reload();
							} else {
								//出错  
								layer.alert(msg, {
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