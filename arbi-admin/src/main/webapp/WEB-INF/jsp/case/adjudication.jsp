<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../base/taglibs.jsp"%>

    <title>补正</title>
    <link rel="stylesheet" href="${appCtx}/static/css/common.css" />
    <link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css" />
    <link rel="stylesheet" href="${appCtx}/static/css/unCasecheck.css"/>
    
    <link rel="stylesheet" href="${appCtx}/static/js/plugin/page/css/reset.css" />
	<link rel="stylesheet" href="${appCtx}/static/js/plugin/page/css/pagination.css" />

             <div class="z-right-box z-bg-fff">
                 <div class="case-main">
                     <div class="unCasecheck">
                         <h4 class="h4-title mgt80">补正历史记录</h4>
                     </div>
                     
                     <c:if test="${not empty amendmentVO.pageInfoAdjudication.list }">
	                      <c:forEach items="${amendmentVO.pageInfoAdjudication.list }" 
	                      				var="amendmentListVO" varStatus="vs">
		                       <div class="benrequestan mgt50">
			                        <c:if test="${amendmentListVO.applyType==0}">
			                            <p class="benrequestan-title">申请方补正内容：<span class="benrequestan-time"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${amendmentListVO.createTime}"/></span></p>
			                            <div class="benrequestan-contain  mgt10">
			                                <p class="benrequestan-contain-reason">
			                                    <span style="display: inline-block">${amendmentListVO.content }</span>
			                                </p>
			                                <c:if test="${amendmentListVO.stauts==1}">
			                                	<img src="${appCtx}/static/img/agree.png" alt="">
			                                </c:if>
			                                <c:if test="${amendmentListVO.stauts==2}">
			                                	<img src="${appCtx}/static/img/disagree.png" alt="">
			                                </c:if>
			                            </div>
			                            <p class="benrequestan-book">
			                            	<a style="cursor:pointer;" onclick="judgment('${amendmentVO.approveId}','${amendmentListVO.id}','${caseId}');">补正裁决书${vs.count}</a>
			                            </p>
			                        </c:if>
			                        
			                        <c:if test="${amendmentListVO.applyType==1}">
			                            <p class="benrequestan-title">被申请方补正内容：<span class="benrequestan-time"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${amendmentListVO.createTime}"/></span></p>
			                            <div class="benrequestan-contain  mgt10">
			                                <p class="benrequestan-contain-reason">
			                                    <span style="display: inline-block">${amendmentListVO.content }</span>
			                                </p>
			                                <c:if test="${amendmentListVO.stauts==1}">
			                                	<img src="${appCtx}/static/img/agree.png" alt="">
			                                </c:if>
			                                <c:if test="${amendmentListVO.stauts==2}">
			                                	<img src="${appCtx}/static/img/disagree.png" alt="">
			                                </c:if>
			                            </div>
			                            <p class="benrequestan-book">
			                            	<a style="cursor:pointer;" onclick="judgment('${amendmentVO.approveId}','${amendmentListVO.id}','${caseId}');">补正裁决书${vs.count}</a>
			                            </p>
			                        </c:if>
		                       </div>
	                      </c:forEach>
                     </c:if>
                 </div>
             </div>
             
             	<!-- 分页导航条 -->
                <div class="pages">
			    	<div class="pmain">
				        <div id="Pagination" class="flickr"></div>
				        <div class="searchPage">
				          <span class="page-sum">共<strong class="allPage">${amendmentVO.pageInfoAdjudication.pages}</strong>页</span>
				          <span class="page-go">到第<input type="text" value="${amendmentVO.pageInfoAdjudication.pageNum}">页</span>
				          <a href="javascript:;" class="page-btn">确定</a>
				        </div>
			        </div>
			    </div>

<script src="${appCtx}/static/vendor/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${appCtx}/static/js/plugin/page/lib/jquery.min.js"></script>
<script type="text/javascript" src="${appCtx}/static/js/plugin/page/jquery.pagination.js"></script>

<script>
	$(document).ready(function() {
	    $("#Pagination").pagination("${amendmentVO.pageInfoAdjudication.pages}",{
			current_page:'${amendmentVO.pageInfoAdjudication.pageNum*1-1}', //当前页码,页码编号从0开始
			//load_first_page:true,//插件加载时是否回调当前页码
	        callback:function(current_page){
	            //回调函数,当前页码为current_page，页码编号从0开始
	            console.log(current_page)
	            <%--var parmList = "?pageNum="+(current_page+1)+"&pageSize=${messageList.pageSize}";--%>
	            <%--location.href = "${appCtx}/numberCount/myNews"+parmList;--%>
	            Request.loadMain({url:"adjudicationAmendmentDoc/caseId",params:'pageNum='+(current_page+1)+'&pageSize=${amendmentVO.pageInfoAdjudication.pageSize}'});
	        }
		});
	});

    $('#scroll-nav').animate({
        left: -242
    })
    $('#icon-left').on('click', function() {
        $('#scroll-nav').animate({
            left: 0
        })
    })
    $('#icon-right').on('click', function() {
        $('#scroll-nav').animate({
            left: -242
        })
    })
</script>

