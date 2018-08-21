<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
	<link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>

	<div class="z-right-box z-bg-fff min-height450">
		<div class="case-main">
			<!-- 仲裁员回避申请 -->
			<c:if test="${not empty arbitratorAvoid.avoidVO}">
				<div class="unCasecheck mgt87">
					<h4 class="h4-title">${arbitratorAvoid.avoidVO.avoidStyle==2?'仲裁员自行回避申请书':'仲裁员回避申请书'}</h4>
					<h4 class="h4-title">
						<c:if test="${arbitratorAvoid.avoidVO.avoidStyle==0}">
							(申请人提出)
	                    </c:if>
	                    <c:if test="${arbitratorAvoid.avoidVO.avoidStyle==1}">
							(被申请人提出)
	                    </c:if>

							申请人：<span>${arbitratorAvoid.avoidVO.applicant}</span>
					</h4>
					<div class="case-main-text">
						<p style="margin-top: 24px;">
						<p style="color: #151515; font-size: 16px; margin-top: 20px;">请求事项</p>
						<p>${arbitratorAvoid.avoidVO.avoidRequst}</p>
						<p style="color: #151515; font-size: 16px; margin-top: 20px;">事实与理由</p>
						<p>${arbitratorAvoid.avoidVO.avoidReason}</p>
						<p style="margin-top: 20px;">此致</p>
						<p>珠海仲裁委员会</p>
						<p style="text-align: right">
							申请人：<span>${arbitratorAvoid.avoidVO.applicant}</span>
						</p>
						<p style="text-align: right">
							<fmt:formatDate value="${arbitratorAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日" />
						</p>
					</div>
				</div>
			</c:if>

		<c:if test="${arbitratorAvoid.duties=='2'}"> <!-- 当前用户为秘书 -->
			<button type="button" id="agree">同意模板</button>
			<button type="button" id="reject">拒绝模板</button>
		</c:if>

			<!-- 同意模板 -->
			<div class="decision" style="display: none" id="agreeDecision">
				<h4 class="h4-title">仲裁员回避决定书</h4>
				<h4 class="h4-title">${arbitratorAvoid.avoidVO.caseNo}</h4>
				<p style="margin-top: 24px;">
					申请人：${arbitratorAvoid.avoidVO.applicant}
				</p>
				<p>
					珠海仲裁委员会（以下简称本会）于<fmt:formatDate value="${arbitratorAvoid.avoidVO.caseAcceptanceTime}" pattern="yyyy年MM月dd日"/>
					受理了申请人${arbitratorAvoid.avoidVO.propName}与被申请人${arbitratorAvoid.avoidVO.defePropName}关于${arbitratorAvoid.avoidVO.caseTypeId}一案。
					<%--是双方选定仲裁员--%>
					<c:if test="${arbitratorAvoid.caseArbiType=='0'}">
						在本会《仲裁规则》规定期限内，双方共同选定仲裁员${arbitratorAvoid.avoidVO.arbitrator}组成独任仲裁庭，
						仲裁庭于<fmt:formatDate value="${arbitratorAvoid.avoidVO.triBunalTime}" pattern="yyyy年MM月dd日"/>成立。
						本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。
					</c:if>
					<%--主任指派--%>
					<c:if test="${arbitratorAvoid.caseArbiType=='1'}">
						双方当事人未在规定期限内共同选定或共同委托本会主任指定独任仲裁员，
						根据《中华人民共和国仲裁法》（以下简称《仲裁法》）第三十二条、《仲裁规则》第  条的规定，
						本会主任指定${arbitratorAvoid.avoidVO.arbitrator}为本案独任仲裁员，仲裁庭于<fmt:formatDate value="${arbitratorAvoid.avoidVO.triBunalTime}" pattern="yyyy年MM月dd日"/>成立。
						本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。
					</c:if>
				</p>

				<p>
					<%--申请人申请或者被申请人申请回避--%>
					<c:if test="${arbitratorAvoid.avoidVO.avoidStyle=='0' || arbitratorAvoid.avoidVO.avoidStyle=='1'}">
						申请人${arbitratorAvoid.avoidVO.applicant}于<fmt:formatDate value="${arbitratorAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日"/>向本会提交了仲裁员回避申请书。
					</c:if>
					<%--自己申请回避--%>
					<c:if test="${arbitratorAvoid.avoidVO.avoidStyle=='2'}">
						仲裁员${arbitratorAvoid.avoidVO.applicant}于<fmt:formatDate value="${arbitratorAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日"/>向本会提交了仲裁员自行回避申请书。
					</c:if>
				</p>

				<p>
					本会认为：
					<c:if test="${arbitratorAvoid.duties=='2'}">
						<textarea class="textarea-say agreeBodyConsent" id="agconsenteeBodyText" placeholder="最多可以输入500个字符">
								${arbitratorAvoid.contentVO.opinion}
						</textarea>
					</c:if>

					<c:if test="${arbitratorAvoid.duties!='2'}">
						${arbitratorAvoid.contentVO.opinion}
					</c:if>

				</p>
				<p style="color: #151515; font-size: 16px; margin-top: 20px;">本会决定如下</p>
				<p>
							准许${arbitratorAvoid.avoidVO.applicant}提出的回避申请。
				</p>
				<input type="hidden" class="consent" id="issueType" name="issueType" value="0"> <!-- 定义模板为同意模板  -->
				<p style="text-align: right">珠海仲裁委员会</p>
				<p style="text-align: right">${arbitratorAvoid.avoidVO.secretariesName}</p>
				<p style="text-align: right"><fmt:formatDate value="${arbitratorAvoid.contentVO.issusTime}" pattern="yyyy年MM月dd日"/></p>
			</div>
			<!-- 同意模板 -->


			<!-- 拒绝模板 -->
			<div class="decision" style="display: none" id="rejectDecision">
				<h4 class="h4-title">仲裁员回避决定书</h4>
				<h4 class="h4-title">${arbitratorAvoid.avoidVO.caseNo}</h4>
				<p style="margin-top: 24px;">
					申请人：${arbitratorAvoid.avoidVO.applicant}
				</p>
				<p>
					珠海仲裁委员会（以下简称本会）于<fmt:formatDate value="${arbitratorAvoid.avoidVO.caseAcceptanceTime}" pattern="yyyy年MM月dd日"/>
					受理了申请人${arbitratorAvoid.avoidVO.propName}与被申请人${arbitratorAvoid.avoidVO.defePropName}关于${arbitratorAvoid.avoidVO.caseTypeId}一案。
					<%--是双方选定仲裁员--%>
					<c:if test="${arbitratorAvoid.caseArbiType=='0'}">
						在本会《仲裁规则》规定期限内，双方共同选定仲裁员${arbitratorAvoid.avoidVO.arbitrator}组成独任仲裁庭，
						仲裁庭于<fmt:formatDate value="${arbitratorAvoid.avoidVO.triBunalTime}" pattern="yyyy年MM月dd日"/>成立。
						本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。
					</c:if>
					<%--主任指派--%>
					<c:if test="${arbitratorAvoid.caseArbiType=='1'}">
						双方当事人未在规定期限内共同选定或共同委托本会主任指定独任仲裁员，
						根据《中华人民共和国仲裁法》（以下简称《仲裁法》）第三十二条、《仲裁规则》第  条的规定，
						本会主任指定${arbitratorAvoid.avoidVO.arbitrator}为本案独任仲裁员，仲裁庭于<fmt:formatDate value="${arbitratorAvoid.avoidVO.triBunalTime}" pattern="yyyy年MM月dd日"/>成立。
						本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。
					</c:if>
				</p>

				<p>
					<%--申请人申请或者被申请人申请回避--%>
					<c:if test="${arbitratorAvoid.avoidVO.avoidStyle=='0' || arbitratorAvoid.avoidVO.avoidStyle=='1'}">
						申请人${arbitratorAvoid.avoidVO.applicant}于<fmt:formatDate value="${arbitratorAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日"/>向本会提交了仲裁员回避申请书。
					</c:if>
					<%--自己申请回避--%>
					<c:if test="${arbitratorAvoid.avoidVO.avoidStyle=='2'}">
						仲裁员${arbitratorAvoid.contentVO.applicant}于<fmt:formatDate value="${arbitratorAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日"/>向本会提交了仲裁员自行回避申请书。
					</c:if>
				</p>

				<p>
					本会认为：
					<c:if test="${arbitratorAvoid.duties=='2'}">
						<textarea class="textarea-say agreeBodyConsent" id="agconsenteeBodyText" placeholder="最多可以输入500个字符">
								${arbitratorAvoid.contentVO.opinion}
						</textarea>
					</c:if>

					<c:if test="${arbitratorAvoid.duties!='2'}">
						${arbitratorAvoid.contentVO.opinion}
					</c:if>

				</p>
				<p style="color: #151515; font-size: 16px; margin-top: 20px;">本会决定如下</p>
				<p>
					<c:if test="${arbitratorAvoid.avoidVO.caseAvoidStatus=='1'}">
						准许${arbitratorAvoid.avoidVO.createName}提出的回避申请。
					</c:if>
					<c:if test="${arbitratorAvoid.avoidVO.caseAvoidStatus=='2'}">
						驳回${arbitratorAvoid.avoidVO.createName}提出的回避申请。
					</c:if>
				</p>
				<input type="hidden" class="reject" id="issueType" name="issueType" value="1"> <!-- 定义模板为不同意模板 -->
				<p style="text-align: right">珠海仲裁委员会</p>
				<p style="text-align: right">${arbitratorAvoid.avoidVO.secretariesName}</p>
				<p style="text-align: right"><fmt:formatDate value="${arbitratorAvoid.contentVO.issusTime}" pattern="yyyy年MM月dd日"/></p>
			</div>
			<!-- 拒绝模板 -->


			<!--审批记录-->
			<div class="approvel-record mgt80">
				<p class="approvel-record-title">审批记录</p>
				<ul>

					<c:if test="${arbitratorAvoid.contentVO!=null }">
						<c:forEach items="${arbitratorAvoid.approveRecordList }"
							var="approveRecordVOList">
							
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
			<c:if test="${arbitratorAvoid.duties=='3'||arbitratorAvoid.duties=='4'||arbitratorAvoid.duties=='5'}">
			<c:if test="${arbitratorAvoid.duties==arbitratorAvoid.approveDuties}">
				<div class="approvel-record mgt80">
					<p class="left">审批意见：</p>
					
					<textarea class="textarea-say" style="width:900px" id="approveSuggest" class="first-comments" placeholder="最多可以输入500个字符"></textarea>
				</div>
			</c:if>
			</c:if>

		<div class="bottom-button">
		<c:if
			test="${arbitratorAvoid.duties=='4'||arbitratorAvoid.duties=='5'}">
			<c:if
				test="${arbitratorAvoid.duties==arbitratorAvoid.approveDuties}">
				<!-- 副主任 -->
				<button id="disagree" 
					class="avoidanceapply bg475 mgt100">驳回</button>
					
				<button id="getThrough"  class="avoidanceapply mgt100">通过</button>
			</c:if>
	
			<c:if test="${arbitratorAvoid.approveDuties=='5'}">
				<!-- 主任 -->
				<c:if test="${arbitratorAvoid.duties=='4'}">
					<button id="disagree" 
						class="avoidanceapply bg475 mgt100">驳回</button>
					<button id="getThrough"  class="avoidanceapply mgt100">通过</button>
				</c:if>
			</c:if>
		</c:if>
	
		<c:if test="${arbitratorAvoid.duties=='3'}"><!-- 部长审批 -->
			<c:if
				test="${arbitratorAvoid.duties==arbitratorAvoid.approveDuties}">
				
				<button id="disagree" 
						class="avoidanceapply bg475 mgt100">驳回</button>
				<button id="getThrough"  class="avoidanceapply mgt100">通过</button>
			</c:if>
		</c:if>
		
		<c:if test="${arbitratorAvoid.duties=='2'}"><!-- 秘书审批 -->
			<c:if
				test="${arbitratorAvoid.duties==arbitratorAvoid.approveDuties}">
				<button id="getThrough"  class="avoidanceapply mgt100">通过</button>
			</c:if>
		</c:if>
	
			</div>
		</div>
	</div>
</div>
<script  type="text/javascript">
var issueType;
$(function(){
	issueType='${arbitratorAvoid.contentVO.issueType}';
	
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
	removeAgreeClass();	
})


//拒绝模板
$("#reject").click(function(){
	removeRejectClass();
})

//删除同意模板style
function removeAgreeClass(){
	$("#agreeDecision").removeAttr("style");
	$("#rejectDecision").css('display','none'); 

	$(".reject ").removeAttr("id");
	$(".agreeFinalConsent ").removeAttr("id");

	$(".agreeBodyConsent ").attr('id','agconsenteeBodyText');
	$(".consent").attr('id','issueType');

}

//删除拒绝模板style
function removeRejectClass(){
	
	$(".agreeBodyConsent ").removeAttr('id');
	$(".consent").removeAttr('id');

	$(".reject ").attr('id','issueType');
	$(".agreeFinalConsent ").attr('id','agconsenteeBodyText');

	$("#rejectDecision").removeAttr("style");
	$("#agreeDecision").css('display','none'); 
}


//通过
$("#getThrough").click(function(){
	var bodyText='';
		bodyText=$("#agconsenteeBodyText").val();
	var	issueType=$("#issueType").val();
	var opinionStatus='0';
	examine(bodyText,opinionStatus,issueType);
})


//驳回
$("#disagree").click(function(){
	var bodyText='';
		bodyText=$("#agconsenteeBodyText").val();

	var	issueType=$("#issueType").val();
	var opinionStatus='1';
	examine(bodyText,opinionStatus,issueType);
})
	

//审核
function examine(bodyText,opinionStatus,issueType){
	$.ajax({
		type:'post',  
        url:'${appCtx}/avoid/audit/auditArbitratorAvoid',  
        dataType:'json',
        data:{
        		docId:'${arbitratorAvoid.contentVO.docId}',
        		docContentId:'${arbitratorAvoid.contentVO.docContentId}',
            	caseId:'${arbitratorAvoid.caseId}',
            	bodyText:bodyText,
            	approveSuggest:$("#approveSuggest").val(),
            	opinionStatus:opinionStatus,
            	issueType:issueType,
            	approveId:'${arbitratorAvoid.approveId}',
            	caseJurisDisId:'${arbitratorAvoid.avoidVO.avoidId}'
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