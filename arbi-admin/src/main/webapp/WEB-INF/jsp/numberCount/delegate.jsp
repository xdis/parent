<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
	<link rel="stylesheet" href="${appCtx}/static/css/delegate.css"/>
	<p class="delegate-p" style="padding-top: 30px;">
		<span>本账号可授权代管的权限：</span>
		<label><input type="checkbox" id="checkAll"><b>全选</b></label>
	</p>
<ul class="clearfix delegate-ul">
		<c:forEach items="${atList}" var="at" varStatus="vs">
			<li><input type="checkbox" name="g1" id="c${vs.index}" value="${at.typeName}" /><label for="c${vs.index}">${at.typeValue}</label></li>
		</c:forEach>

	</ul>
	<div class="change-delegate">
		<p class="change-delegate-p1">
			<span>将以上勾选的权限授予</span>
			<select id="delegateUserId">
				<option value="">请选择后台用户</option>
				<c:forEach items="${ownDelegateList}" var="dt" varStatus="vs">
					<option value="${dt.id}">${dt.name}</option>
				</c:forEach>
			</select>
			<span>代管</span>
		</p>
		<p class="change-delegate-p2">主任可将权限给副主任代管，副主任可将权限给部长代管，不可跨级别代管</p>
		<label class="change-delegate-label">
			<span>代管时间</span>
			<input type="date" id="startDate" placeholder="请输入开始时间" class="form-control search-input createTime"/>至
			<input type="date" id="endDate" placeholder="请输入结束时间" class="form-control search-input createTime"/>
		</label>
		<button class="seek-btn" style="width:160px;border: 1px solid #47599e;margin-right: 20px;">取消</button>
		<button class="seek-btn bg475" style="width: 160px;" id="addDelegate">确定</button>
	</div>
<script>
	$("#checkAll").click(function(){
	    $("input[name='g1']").prop("checked",$(this).is(':checked'));
	});
	$("#addDelegate").click(function(){
        if($("#startDate").val() == ""){
            layer.msg("请选择开始日期!");
            return;
        }
        if($("#endDate").val() == ""){
            layer.msg("请选择结束日期!");
            return;
        }
        if($("#startDate").val() == ""){
            layer.msg("请选择开始日期!");
            return;
        }
        if($("#delegateUserId").val() == ""){
            layer.msg("请选择被授权人!");
            return;
        }
        var delegateCheckBox = $("input[name='g1']:checked");
        if(delegateCheckBox.length==0){
            layer.msg("请选择代管权限!");
            return;
		}
		var delegateIds = "";
        delegateCheckBox.each(function(i,o){
            delegateIds += ($(o).val()+",");
		});
		delegateIds = delegateIds.replace(/,$/gi,"");
		Request.loadMain({url:"numberCount/addDelegate",params:"approveTypeIds="+delegateIds
			+"&delegateUserId="+$("#delegateUserId").val()
			+"&startDate="+$("#startDate").val()
			+"&endDate="+$("#endDate").val()});
	});
</script>