<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
	<link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>

	<div class="z-right-box z-bg-fff min-height450">
		<!-- 仲裁申请 -->
			<!-- 仲裁员回避申请 -->
			<c:if test="${not empty secretariesAvoid.avoidVO}">
				<div class="unCasecheck mgt87">
					<h4 class="h4-title">${secretariesAvoid.avoidVO.avoidStyle==2?'秘书自行回避申请书':'秘书回避申请书'}</h4>
					<h4 class="h4-title">
						<c:if test="${secretariesAvoid.avoidVO.avoidStyle==0}">
							(申请人提出)
	                    </c:if>
	                    <c:if test="${secretariesAvoid.avoidVO.avoidStyle==1}">
							(被申请人提出)
	                    </c:if>
	                    ${secretariesAvoid.avoidVO.applicant}
					</h4>
					<div class="case-main-text">
						<p style="margin-top: 24px;">
						<p style="color: #151515; font-size: 16px; margin-top: 20px;">请求事项</p>
						<p>${secretariesAvoid.avoidVO.avoidRequst}</p>
						<p style="color: #151515; font-size: 16px; margin-top: 20px;">事实与理由</p>
						<p>${secretariesAvoid.avoidVO.avoidReason}</p>
						<p style="margin-top: 20px;">此致</p>
						<p>珠海仲裁委员会</p>
						<p style="text-align: right">
							申请人：<span>${secretariesAvoid.avoidVO.applicant}</span>
						</p>
						<p style="text-align: right">
							<fmt:formatDate value="${secretariesAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日" />
						</p>
					</div>
				</div>
			</c:if>


		<c:if test="${secretariesAvoid.duties=='3'}"> <!-- 当前用户为部长 -->
			<button type="button" id="agree">同意模板</button>
			<button type="button" id="reject">拒绝模板</button>
		</c:if>


			<!-- 同意模板 -->
			<div class="decision" style="display: none" id="agreeDecision">
				<h4 class="h4-title">秘书回避决定书</h4>
				<h4 class="h4-title">${secretariesAvoid.avoidVO.caseNo}</h4>
				<p style="margin-top: 24px;">
					申请人：${secretariesAvoid.avoidVO.applicant}
				</p>

				<p>
					珠海仲裁委员会（以下简称本会）于<fmt:formatDate value="${secretariesAvoid.avoidVO.caseAcceptanceTime}" pattern="yyyy年MM月dd日"/>
					受理了${secretariesAvoid.avoidVO.propName}与${secretariesAvoid.avoidVO.defePropName}关于${secretariesAvoid.avoidVO.caseTypeId}一案。
					本会于<fmt:formatDate value="${secretariesAvoid.caseManagerTime}" pattern="yyyy年MM月dd日"/>指派${secretariesAvoid.avoidVO.secretariesName}担任本案办案秘书。
					申请人${secretariesAvoid.avoidVO.applicant}于<fmt:formatDate value="${secretariesAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日"/>向本会提交了秘书回避申请书。

				</p>


				<p>
					本会认为：
					<c:if test="${secretariesAvoid.duties=='3'}">
					<textarea class="textarea-say agreeBodyConsent" id="agconsenteeBodyText" placeholder="最多可以输入500个字符">
							${secretariesAvoid.contentVO.opinion}
					</textarea>
					</c:if>

					<c:if test="${secretariesAvoid.duties!='2'}">
						${secretariesAvoid.contentVO.opinion}
					</c:if>
				</p>

				<p style="color: #151515; font-size: 16px; margin-top: 20px;">本会决定如下</p>
				<p>
					<c:if test="${secretariesAvoid.avoidVO.caseAvoidStatus=='1'}">
						准许${secretariesAvoid.avoidVO.createName}提出的回避申请。
					</c:if>
					<c:if test="${secretariesAvoid.avoidVO.caseAvoidStatus=='2'}">
						驳回${secretariesAvoid.avoidVO.createName}提出的回避申请。
					</c:if>
				</p>
				<p style="color: #151515; font-size: 16px; margin-top: 20px;">本会决定如下</p>
				<p>
							准许${arbitratorAvoid.avoidVO.applicant}提出的回避申请。
				</p>
				<input type="hidden" class="consent" id="issueType" name="issueType" value="0"> <!-- 定义模板为同意模板  -->
				<p style="text-align: right">珠海仲裁委员会</p>
				<p style="text-align: right">${secretariesAvoid.avoidVO.secretariesName}</p>
				<p style="text-align: right"><fmt:formatDate value="${secretariesAvoid.contentVO.issusTime}" pattern="yyyy年MM月dd日"/></p>
			</div>
			<!-- 同意模板 -->


			<!-- 拒绝模板 -->
			<div class="decision" style="display: none" id="rejectDecision">
				<h4 class="h4-title">秘书回避决定书</h4>
				<h4 class="h4-title">${secretariesAvoid.avoidVO.caseNo}</h4>
				<p style="margin-top: 24px;">
					申请人：${secretariesAvoid.avoidVO.applicant}
				</p>

				<p>
					珠海仲裁委员会（以下简称本会）于<fmt:formatDate value="${secretariesAvoid.avoidVO.caseAcceptanceTime}" pattern="yyyy年MM月dd日"/>
					受理了${secretariesAvoid.avoidVO.propName}与${secretariesAvoid.avoidVO.defePropName}关于${secretariesAvoid.avoidVO.caseTypeId}一案。
					本会于<fmt:formatDate value="${secretariesAvoid.caseManagerTime}" pattern="yyyy年MM月dd日"/>指派${secretariesAvoid.avoidVO.secretariesName}担任本案办案秘书。
					申请人${secretariesAvoid.avoidVO.applicant}于<fmt:formatDate value="${secretariesAvoid.avoidVO.applicationTime}" pattern="yyyy年MM月dd日"/>向本会提交了秘书回避申请书。

				</p>


				<p>
					本会认为：
					<c:if test="${secretariesAvoid.duties=='3'}">
					<textarea class="textarea-say agreeBodyConsent" id="agconsenteeBodyText" placeholder="最多可以输入500个字符">
							${secretariesAvoid.contentVO.opinion}
					</textarea>
					</c:if>

					<c:if test="${secretariesAvoid.duties!='3'}">
						${secretariesAvoid.contentVO.opinion}
					</c:if>
				</p>

				<p style="color: #151515; font-size: 16px; margin-top: 20px;">本会决定如下</p>
				<p>
					<c:if test="${secretariesAvoid.avoidVO.caseAvoidStatus=='1'}">
						准许${secretariesAvoid.avoidVO.createName}提出的回避申请。
					</c:if>
					<c:if test="${secretariesAvoid.avoidVO.caseAvoidStatus=='2'}">
						驳回${secretariesAvoid.avoidVO.createName}提出的回避申请。
					</c:if>
				</p>
				<input type="hidden" class="consent" id="issueType" name="issueType" value="1"> <!-- 定义模板为拒绝模板  -->
				<p style="text-align: right">珠海仲裁委员会</p>
				<p style="text-align: right">${secretariesAvoid.avoidVO.secretariesName}</p>
				<p style="text-align: right"><fmt:formatDate value="${secretariesAvoid.contentVO.issusTime}" pattern="yyyy年MM月dd日"/></p>
			</div>
			<!-- 拒绝模板 -->

		

		<!--审批记录-->
		<div class="approvel-record mgt80">
			<ul>
				<c:if test="${secretariesAvoid.contentVO!=null }">
				<p class="approvel-record-title">审批记录</p>
					<c:forEach items="${secretariesAvoid.approveRecordList }"
						var="approveRecordVOList">
						<c:if test="${approveRecordVOList.duties=='5'}">
							<li>
								<p>
									<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordVOList.createTime}" />
								</p> ${fn:substring(approveRecordVOList.approveName, 0, 1)}副主任复审意见：
								<p class="pdl50">${approveRecordVOList.approveSuggest }</p>
							</li>
						</c:if>
	
						<c:if test="${approveRecordVOList.duties=='4'}">
							<li>
								<p>
									<fmt:formatDate pattern="yyyy-MM-dd  HH:mm" value="${approveRecordVOList.createTime}" />
								</p> ${fn:substring(approveRecordVOList.approveName, 0, 1)}主任复审意见：
								<p class="pdl50">${approveRecordVOList.approveSuggest }</p>
							</li>
						</c:if>
					</c:forEach>
				</c:if>
				
				<c:if test="${secretariesAvoid.duties=='4'||secretariesAvoid.duties=='5'}">
				<c:if test="${secretariesAvoid.duties==secretariesAvoid.approveDuties}">
				<div class="approvel-record mgt80">
					<p class="approvel-record-title">审批意见</p>
					<textarea class="textarea-say" id="approveSuggest" placeholder="最多可以输入500个字符" style="width:900px"></textarea>
				</div>
				</c:if>
				</c:if>
			</ul>
		</div>		

		<div class="bottom-button">
		<c:if test="${secretariesAvoid.duties=='4'||secretariesAvoid.duties=='5'}">
			<c:if test="${secretariesAvoid.duties==secretariesAvoid.approveDuties}">
				<!-- 副主任 -->
				<button id="disagree"  class="avoidanceapply bg475 mgt100">驳回</button>
				<button id="getThrough"  class="avoidanceapply mgt100">通过</button>
			</c:if>
		</c:if>
		<c:if test="${secretariesAvoid.duties=='3'}">
			<c:if test="${secretariesAvoid.duties==secretariesAvoid.approveDuties}">
				<!-- 部长呈领导审批 -->
				<button id="getThrough"  class="avoidanceapply mgt100">通过</button>
			</c:if>
		</c:if>
	
		</div>
	
	</div>

<script  type="text/javascript">
	var issueType;
	$(function(){
		issueType='${secretariesAvoid.contentVO.issueType}';
		
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
            url:'${appCtx}/avoid/audit/auditSecretariesAvoid ',  
            dataType:'json',
            data:{
            		docId:'${secretariesAvoid.contentVO.docId}',
            		docContentId:'${secretariesAvoid.contentVO.docContentId}',
	            	caseId:'${secretariesAvoid.caseId}',
	            	bodyText:bodyText,
	            	approveSuggest:$("#approveSuggest").val(),
	            	opinionStatus:opinionStatus,
	            	issueType:issueType,
	            	approveId:'${secretariesAvoid.approveId}',
	            	caseJurisDisId:'${secretariesAvoid.avoidVO.avoidId}'
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

