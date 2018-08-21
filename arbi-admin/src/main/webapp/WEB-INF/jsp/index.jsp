<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="base/taglibs.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-cn" ng-app="app">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>用户管理</title>
    <link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/numberCount.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/userIndex.css"/>
	<script type="text/javascript">
		var token = "${accessToken}";
	</script>
	<style type="text/css">
		.header-section-ul li,#secound-menu li{
			cursor: pointer;
		}
	</style>
</head>

<body style="height: 100%;">
<div id="container">
    <header class="clearfix header">
        <div class="header-top">
            <p class="left-p"><span>珠海仲裁后台系统  | </span>
            <c:if test="${userInfoVO.duties == '0' }">
            	<span> 立案秘书</span></p>
            </c:if>
            <c:if test="${userInfoVO.duties == '1' }">
            	<span> 立案部长</span></p>
            </c:if>
            <c:if test="${userInfoVO.duties == '2' }">
            	<span> 仲裁秘书</span></p>
            </c:if>
            <c:if test="${userInfoVO.duties == '3' }">
            	<span> 仲裁部长</span></p>
            </c:if>
            <c:if test="${userInfoVO.duties == '4' }">
            	<span> 主任</span></p>
            </c:if>
            <c:if test="${userInfoVO.duties == '5' }">
            	<span> 副主任</span></p>
            </c:if>
            <p class="right-p">
                <i class="icon anticon icon-bells"><b>15</b></i>
                <i class="icon anticon icon-user"></i>
                <c:if test="${userInfoVO.duties == '0' }">
                	<span>您好，${fn:substring(userInfoVO.name, 0, 1)}秘书</span>
                    <span>（${fn:substring(userInfoVO.phone , 0, 5)}****${fn:substring(userInfoVO.phone , 9, 11)}）</span>
                </c:if>
                <c:if test="${userInfoVO.duties == '1' }">
                	<span>您好，${fn:substring(userInfoVO.name, 0, 1)}部长</span>
                    <span>（${fn:substring(userInfoVO.phone , 0, 5)}****${fn:substring(userInfoVO.phone , 9, 11)}）</span>
                </c:if>
                <c:if test="${userInfoVO.duties == '2' }">
                	<span>您好，${fn:substring(userInfoVO.name, 0, 1)}秘书</span>
                    <span>（${fn:substring(userInfoVO.phone , 0, 5)}****${fn:substring(userInfoVO.phone , 9, 11)}）</span>
                </c:if>
                <c:if test="${userInfoVO.duties == '3' }">
                	<span>您好，${fn:substring(userInfoVO.name, 0, 1)}部长</span>
                    <span>（${fn:substring(userInfoVO.phone , 0, 5)}****${fn:substring(userInfoVO.phone , 9, 11)}）</span>
                </c:if>
                <c:if test="${userInfoVO.duties == '4' }">
                	<span>您好，${fn:substring(userInfoVO.name, 0, 1)}主任</span>
                    <span>（${fn:substring(userInfoVO.phone , 0, 5)}****${fn:substring(userInfoVO.phone , 9, 11)}）</span>
                </c:if>
                <c:if test="${userInfoVO.duties == '5' }">
                	<span>您好，${fn:substring(userInfoVO.name, 0, 1)}副主任</span>
                    <span>（${fn:substring(userInfoVO.phone , 0, 5)}****${fn:substring(userInfoVO.phone , 9, 11)}）</span>
                </c:if>

                <c:if test="${empty userInfoVO.duties}">
                	<span>您好，${userInfoVO.name}</span>
                    <c:if test="${fn:length(userInfoVO.phone) >=13 }">
                        <span>（${fn:substring(userInfoVO.phone , 0, 5)}****${fn:substring(userInfoVO.phone , 9, 11)}）</span>
                    </c:if>

                    <c:if test="${fn:length(userInfoVO.phone) <13 }">
                        <span>（${userInfoVO.phone}）</span>
                    </c:if>
                </c:if>
                <i class="icon anticon icon-logout"></i>
                <span id="logout">退出</span>
            </p>
        </div>
        <div class="header-section clearfix">
            <img src="${appCtx}/static/img/commonlogo.png">
            <ul class="header-section-ul">
            	<c:forEach var="res" items="${resourceList }" varStatus="vs">
            		<c:if test="${res.parentId=='-1' }">
		                <li ${vs.count==1?'class="colorblue"':'' } data-url="${res.url }" >${res.name }</li>
            		</c:if>
            	</c:forEach>
            	<!-- class="colorblue" -->
                <span class="li-line"></span>
            </ul>
        </div>
    </header>
    <section class="bgf4 pad45 pdb20 clearfix">
        <p class="left-title">
            <span>用户管理</span>
            <i class="icon anticon icon-right"></i>
            <span>仲裁委后台用户管理</span>
        </p>
        <section class="z-main ">
            <section class="z-main clearfix nopadding">
				<div class="zhong-left">
                    <ul id="secound-menu" class="zhong-left-ul z-bg-fff">
                    </ul>
                </div>
                <div id="main" class="zhong-right z-bg-fff" style="padding: 0 20px;">
                </div>
			</section>
		</section>
        <footer class="common-footer">
            <span>版权所有@ 珠海仲裁委员会  |  未经书面协议授权禁止下载或建立镜像</span>
            <span>联系我们  |  新闻公告  |  友情链接</span>
            <span> 粤ICP备13053290号  |  粤公网安备11010502025090</span>
        </footer>

    </section>
</div>
</body>
</html>

<script type="text/javascript">
<!--
	$(function(){
		$(".header-section-ul li").click(function(){

			var _this = $(this);
            var _index = _this.index();
            $('.li-line').stop().animate({'left':20+_index*100},500);;
			$(".header-section-ul li").removeClass("colorblue");
			_this.addClass("colorblue");
			Request.loadMain({url:_this.data("url")});
			var secondMenu = resList[_this.index()].chindren;
			if($("#secound-menu").length ==0 ){
                $(".z-main>.zhong-left").html('<ul id="secound-menu" class="zhong-left-ul"></ul>');
            }else{
                $("#secound-menu li").remove();
            }
			if(typeof(secondMenu)=="undefined"){
                $(".z-main>.zhong-left").html($("#main .zhong-left").html());
                $("#main .zhong-left").remove();
            }else{
                $("#secound-menu").parent().removeClass("none");
                $("#main").removeClass("width-contain");
                for(var i=0,len = secondMenu.length;i<len;i++){
                    $("#secound-menu").append("<li data-url='"+secondMenu[i].url+"'>"+secondMenu[i].name+"</li>");
                }
            }
			$("#secound-menu li:eq(0)").addClass("bg475");
			$("#secound-menu li").click(function(){
				var _this = $(this);
				$("#secound-menu li").removeClass("bg475");
				_this.addClass("bg475");
				Request.loadMain({url:_this.data("url")});
			});
		});		
	});
	var resList = ${resJson};
	resList = transData(resList, 'id', 'parentId', 'chindren');
	function transData(a, idStr, pidStr, chindrenStr){    
        var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;    
        for(; i < len; i++){    
            hash[a[i][id]] = a[i];    
        }    
        for(; j < len; j++){    
            var aVal = a[j], hashVP = hash[aVal[pid]];    
            if(hashVP){    
                !hashVP[children] && (hashVP[children] = []);    
                hashVP[children].push(aVal);    
            }else{    
                r.push(aVal);    
            }    
        }    
        return r;    
    }
    //退出
    $("#logout").click(function(){
        location = cxt+"logout";
    });
//-->
</script>