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

	
    <div class="zhong-right z-bg-fff min-height450" style="padding: 20px;">
    		<div>
    			<span><img src="${arbitratorInfo.headPhoto}" class="left" style="width: 100px;height: 100px;"></span>
    		</div>
            <div class="zhong-right-top clearfix">
                
                <ul class="zhong-right-top-ul left">
                    <li><span>姓名:</span>${arbitratorInfo.name}</li>
                    <li><span>出生年月:</span>${arbitratorInfo.dateOfBirth}</li>
                    <li><span>职业:</span>${arbitratorInfo.vocation}</li>
                    <li><span>专长:</span>${arbitratorInfo.specialty}</li>
                    <li><span>居住地:</span>${arbitratorInfo.address}</li>
                </ul>
            </div>
        </div>
	