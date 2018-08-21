<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%
	String path = request.getContextPath();
%>
<base href="<%=path%>/">

    <title>数据统计</title>
    <link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/numberCount.css"/>
    <link rel="stylesheet" href="static/css/userIndex.css"/>

		<c:if test="${0==dataStatisticsVO.duties || 1==dataStatisticsVO.duties}">
	        <div class="numberCount" style="padding-left: 200px">
	            <div class="numberCount-box">
	                <i class="icon anticon icon-barschart"></i><span>累计数据</span>
	                <ul class="num-list clearfix mgt30">
	                    <li><span class="text colorblue">在线审核案件</span><span class="num colorblue">${dataStatisticsVO.totalDataStatistics.total }</span></li>
	                    <li><span class="text">已通过案件</span><span class="num">${dataStatisticsVO.totalDataStatistics.auditAdopt }</span></li>
	                    <li><span class="text">已拒绝案件</span><span class="num">${dataStatisticsVO.totalDataStatistics.auditNotPass }</span></li>
	                </ul>
	            </div>
	            <div class="numberCount-box mgt30">
	                <i class="icon anticon icon-barschart"></i><span>当日数据</span>
	                <ul class="num-list clearfix mgt30">
	                    <li><span class="text">在线审核案件</span><span class="num">${dataStatisticsVO.todayDataStatistics.total }</span></li>
	                    <li><span class="text">已通过案件</span><span class="num">${dataStatisticsVO.todayDataStatistics.auditAdopt }</span></li>
	                    <li><span class="text">已拒绝案件</span><span class="num">${dataStatisticsVO.todayDataStatistics.auditNotPass }</span></li>
	                </ul>
	            </div>
	            <div class="numberCount-user mgt30">
	                <i class="icon anticon icon-barschart"></i><span>月数据</span>
	                <p class=" mgt30">
	                	<span class="choosetime">时间</span>
	                	<input onchange="time()" type="month" class="choosemonth" value="${dataStatisticsVO.sameMonth }">
	                </p>
	                <div id="main" style="width: 500px;height: 400px;float:right;" duties = ${dataStatisticsVO.duties }></div>
	                <ul class="show-list clearfix mgt30">
	                    <li><span class="text">本月审批案件</span><span id="btn1" class="num">${dataStatisticsVO.monthDataStatistics.total }件</span></li>
	                    <li><span class="text">本月通过案件</span><span id="btn2" class="num">${dataStatisticsVO.monthDataStatistics.auditAdopt }件</span></li>
	                    <li><span class="text">本月拒绝案件</span><span id="btn3" class="num">${dataStatisticsVO.monthDataStatistics.auditNotPass }件</span></li>
	                </ul>
	            </div>
	        </div>
        </c:if>
        
        <c:if test="${2==dataStatisticsVO.duties || 3==dataStatisticsVO.duties
        		|| 4==dataStatisticsVO.duties || 5==dataStatisticsVO.duties}">
        	<div class="numberCount" style="padding-left: 200px">
	            <div class="numberCount-box">
	                <i class="icon anticon icon-barschart"></i><span>累计数据</span>
	                <ul class="num-list-ul clearfix mgt30">
	                    <li><span class="text colorblue">在线审核案件</span><span class="num colorblue">${dataStatisticsVO.totalDataStatistics.total }</span></li>
	                    <li><span class="text">已立案案件数</span><span class="num">${dataStatisticsVO.totalRegistered.auditAdopt }</span></li>
	                    <li><span class="text">已裁决案件数</span><span class="num">${dataStatisticsVO.totalNumber.auditAdopt }</span></li>
	                    <li><span class="text">已结案案件数</span><span class="num">${dataStatisticsVO.totalDataStatistics.auditAdopt }</span></li>
	                </ul>
	            </div>
	            <div class="numberCount-user mgt30">
	                <i class="icon anticon icon-barschart"></i><span>当日数据</span>
	                <ul class="num-list-ul clearfix mgt30">
	                    <li><span class="text colorblue">已接案件数</span><span class="num colorblue">${dataStatisticsVO.todayDataStatistics.total }</span></li>
	                    <li><span class="text">已完结案件数</span><span class="num">${dataStatisticsVO.totalDataStatistics.auditAdopt }</span></li>
	                    <li><span class="text">已拒绝案件数</span><span class="num">${dataStatisticsVO.totalDataStatistics.auditNotPass }</span></li>
	                    <li><span class="text">已撤案案件数</span><span class="num">${dataStatisticsVO.todayCancel.auditAdopt }</span></li>
	                    <li><span class="text">已调解案件数</span><span class="num">${dataStatisticsVO.todayConciliation.auditAdopt }</span></li>
	                </ul>
	            </div>
	            <div class="numberCount-user mgt30"> 
	                <i class="icon anticon icon-barschart"></i><span>月数据</span>
	                <p class=" mgt30">
	                	<span class="choosetime">时间</span>
	                	<input onchange="time()" type="month" class="choosemonth" value="${dataStatisticsVO.sameMonth }">
	                </p>
	            	<div id="main" style="width: 500px;height: 400px;float:right;" duties = ${dataStatisticsVO.duties }></div>
	                <ul class="show-list clearfix mgt30">
	                    <li><span class="text">本月申请仲裁审批</span><span id="btn1" class="num">${dataStatisticsVO.monthDataStatistics.total }件</span></li>
	                    <li><span class="text">本月立案审批</span><span id="btn2" class="num">${dataStatisticsVO.monthRegistered.total }件</span></li>
	                    <li><span class="text">本月裁决审批</span><span id="btn3" class="num">${dataStatisticsVO.monthNumber.total }件</span></li>
	                    <li><span class="text">反请求申请审批</span><span id="btn4" class="num">${dataStatisticsVO.monthCounterclaim.total }件</span></li>
	                    <li><span class="text">仲裁请求变更审批</span><span id="btn5" class="num">${dataStatisticsVO.monthChange.total }件</span></li>
	                    <li><span class="text">秘书回避请求审批</span><span id="btn6" class="num">${dataStatisticsVO.monthAvoid.total }件</span></li>
	                </ul>
	            </div>
	        </div>
        </c:if>

<script src="static/js/echarts.js"></script>        
<script type="text/javascript">
	/* 月份刷选 */
	function time(){
		var sameMonth = $(".choosemonth").val();
		$.ajax({
			url : "${appCtx}/data/statistics/months",
			type : "POST",
			data : {
				'sameMonth':sameMonth
			},
			success : function(data) {
				if (2 == data.duties || 3 == data.duties
						|| 4 == data.duties || 5 == data.duties) {
					$("#btn1").html(data.monthDataStatistics.total);
					$("#btn2").html(data.monthRegistered.total);
					$("#btn3").html(data.monthNumber.total);
					$("#btn4").html(data.monthCounterclaim.total);
					$("#btn5").html(data.monthChange.total);
					$("#btn6").html(data.monthAvoid.total);
				}else if (0 == data.duties || 1 == data.duties) {
					$("#btn1").html(data.monthDataStatistics.total);
					$("#btn2").html(data.monthDataStatistics.auditAdopt);
					$("#btn3").html(data.monthDataStatistics.auditNotPass);
				}
			}
		});
	}
	
	/* 数据图表 */
	$(function(){
		var duties = $("#main").attr("duties");
		if (2 == duties || 3 == duties
				|| 4 == duties || 5 == duties) {
			var myChart = echarts.init(document.getElementById("main"));
			var monthDataStatistics = parseInt($("#btn1").text().replace(/[^0-9]/ig,""));//截取数字
			var monthRegistered = parseInt($("#btn2").text().replace(/[^0-9]/ig,""));
			var monthNumber = parseInt($("#btn3").text().replace(/[^0-9]/ig,""));
			var monthCounterclaim = parseInt($("#btn4").text().replace(/[^0-9]/ig,""));
			var monthChange = parseInt($("#btn5").text().replace(/[^0-9]/ig,""));
			var monthAvoid = parseInt($("#btn6").text().replace(/[^0-9]/ig,""));
			myChart.setOption({
				color: ['#3398DB'],
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : [
			            	'本月申请仲裁审批', 
			            	'本月立案审批', 
			            	'本月裁决审批', 
			            	'反请求申请审批', 
			            	'仲裁请求变更审批', 
			            	'秘书回避请求审批'
			            ],
			            axisLabel: {interval:0, rotate:40}
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            splitNumber:5
			        }
			    ],
			    series : [
			        {
			            name:'数量',
			            type:'bar',
			            barWidth: '60%',
			            data:[
			                  monthDataStatistics, 
			                  monthRegistered, 
			                  monthNumber, 
			                  monthCounterclaim, 
			                  monthChange, 
			                  monthAvoid
			            ]
			        }
			    ]
			})
		}
		
		if (0 == duties || 1 == duties) {
			var myChart = echarts.init(document.getElementById("main"));
			var total = parseInt($("#btn1").text().replace(/[^0-9]/ig,""));//截取数字
			var auditAdopt = parseInt($("#btn2").text().replace(/[^0-9]/ig,""));
			var auditNotPass = parseInt($("#btn3").text().replace(/[^0-9]/ig,""));
			myChart.setOption({
				color: ['#3398DB'],
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : [
			            	'本月审批案件', 
			            	'本月通过案件', 
			            	'本月拒绝案件', 
			            ],
			            axisLabel: {interval:0, rotate:40}
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            splitNumber:5
			        }
			    ],
			    series : [
			        {
			            name:'数量',
			            type:'bar',
			            barWidth: '60%',
			            data:[
			                  total, 
			                  auditAdopt, 
			                  auditNotPass, 
			            ]
			        }
			    ]
			})
		}
	})
</script>