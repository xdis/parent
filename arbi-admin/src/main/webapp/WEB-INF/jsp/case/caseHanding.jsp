<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
	<%--引入的css文件--%>
    <link href="${appCtx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${appCtx}/static/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">

	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/userIndex.css"/>
        <div class="z-bg-fff" style="padding: 0 20px;">
           <form class="form-header validForm" action="#" method="get">
               <label class="mgb20">
                   <span>申请人/被申请人/代理人</span>
                   <input id="propName" style="width:210px"  type="text" placeholder="请输入申请人/被申请人/代理人"/>
               </label>
               <label class="mgb20">
                   <span>申请时间</span>
                   <input type="text" id="startTime" placeholder="请输入开始时间" />至
                   <input type="text" id="endTime" placeholder="请输入结束时间" />
               </label>
               <label class="mgb20">
                   <span>当前责任人</span>
                   <select id="duties">
                       <option value="-1">全部</option>
                       <option value="0">立案部秘书</option>
                       <option value="1">立案部部长</option>
                       <option value="4">立案部主任</option>
                       <option value="5">立案部副主任</option>
                   </select>
               </label>
               <ul class="form-header-ul clearfix">
                   <li class="bg475" id="all">全部</li>
                   <li id="toAudit">待审核</li>
                   <li id="underReview">审核中</li>
                   <li id="approved">已审核</li>
               </ul>
               <button class="seek bg475" id="search_btn" type="button">查询</button>
           </form>
           <table id="caseList" class="table table-hover table-striped"></table>
        </div>
<%--引入的js文件--%>
<script src="${appCtx}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${appCtx}/static/js/countDown.js"></script>
<script>
	var toAudit;
	var underReview;
	var approved;
	var timerArr=[];
    $(function(){
    	 	laydate({
    	        elem: '#startTime',
    	        format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
    	        festival: true, //显示节日
    	        choose: function(datas){ //选择日期完毕的回调
    	            //console.log('得到：'+datas);
    	        }
    	    });

    	    laydate({
    	        elem: '#endTime',
    	        format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
    	        festival: true, //显示节日
    	        choose: function(datas){ //选择日期完毕的回调
    	            //console.log('得到：'+datas);
    	        }
    	    });
    	    laydate.skin('molv');
    	    laydate.skin('molv'); 
    })
   

    //tableHeight函数
   /*  function tableHeight(){
        //可以根据自己页面情况进行调整
        return $(window).height() -280;
    } */

    //根据窗口调整表格高度
  /*   $(window).resize(function() {
        $('#caseList').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
 */

    //生成用户数据
    $('#caseList').bootstrapTable({
        method: 'post',
        url:"${appCtx}/case/caseinfo/list",//要请求数据的文件路径
        //toolbar: '#toolbar',//指定工具栏
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        //data : obj, //最终的JSON数据放在这里
        //height:tableHeight(),//高度调整
        striped: true, //是否显示行间隔色
        dataField: "list",//bootstrap table 可以前端分页也可以后端分页，这里
        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的
        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination:true,//是否分页
        smartDisplay:false,
        queryParamsType:'limit',//查询参数组织方式
        queryParams:queryParams,//请求服务器时所传的参数
        sidePagination:'server',//指定服务器端分页
        pageSize:10,//单页记录数
        pageList:[5,10,20,30],//分页步进值
        showRefresh:true,//刷新按钮
        showColumns:true,
        clickToSelect: true,//是否启用点击选中行
        toolbarAlign:'right',//工具栏对齐方式
        buttonsAlign:'right',//按钮对齐方式
        // toolbar:'#toolbar',//指定工作栏
       // showHeader:false,
        columns:[
            {
                title: '序号',//标题  可不加
                formatter: function (value, row, index) {
                    return index+1;
                }
            },
            {
                title:'申请人',
                field:'proposerName'
            },
            {
                title:'被申请人',
                field:'defendantName'
            },
            {
                title:'案件进展',
                formatter:caseStatus
            },
            {
                title:'申请时间',
                field:'applyTime'
            },
            {
                title:'当前责任人',
                formatter:ownnerName
            },
            {
                title:'案件审核期倒计时',
                formatter:countDown,
                cellStyle:cellStyle
            },
            
            {
                title:'操作',
                field:'Attribute',
                align:'center',
                //列数据格式化
                formatter:operateFormatter
            }
        ],
        locale:'zh-CN',//中文支持,
        /*responseHandler:function(res){
         //在ajax获取到数据，渲染表格之前，修改数据源
         return res;
         }*/
        onLoadError:function(status){
        	if(status=='9995'){
        		layer.alert("查询参数输入错误", {
                    skin: 'layui-layer-lan' //样式类名
                    ,closeBtn: 0
                });
        	}else if(status=='6001'){
        		layer.alert("账户异常", {
                    skin: 'layui-layer-lan' //样式类名
                    ,closeBtn: 0
                });
        	}else{
        		layer.alert("系统异常", {
                    skin: 'layui-layer-lan' //样式类名
                    ,closeBtn: 0
                });
        	}
        }
    })
    //案件状态
    function caseStatus(value,row,index){
    	var statusMsg='待审核';
    	if(row.approveStatus=='0'){
    		if(row.caseStatus=='0'){
        		statusMsg='待审核';
        	}else if(row.caseStatus=='1'){
        		statusMsg='审核中';
        	}	
    	}else{
    		statusMsg='已审核';
    	}
    	return statusMsg;
    	/* var statusMsg;
    	if(row.approveStatus=='0'){
    		statusMsg='待审核';
    	}else if(row.approveStatus=='1'){
    		statusMsg='审核不通过';
    	}else if(row.approveStatus=='2'){
    		statusMsg='审核通过';
    	}
    	return statusMsg; */
    }
    

    //拼接姓和职务
	function ownnerName(value,row,index){
    	var ownnerName=row.ownnerName.substring(0,1) ;
    	var duties;
    	if(row.duties=='0'){
    		duties='秘书';
    	}else if(row.duties=='1'){
    		duties='部长';
    	}else if(row.duties=='2'){
    		duties='秘书';
    	}else if(row.duties=='3'){
    		duties='部长';
    	}else if(row.duties=='4'){
    		duties='主任';
    	}else{
    		duties='副主任';
    	}
    	return ownnerName+duties;
    }	
    
    //倒计时
    function countDown(value,row,index){
    	return setTime(row.timeSet,index,timerArr,row.approveStatus);
    }
    
    //设置class
    function cellStyle(value,row,index){
    	return{ 'classes': 'timeSet'+index}
    }
    //三个参数，value代表该列的值
    function operateFormatter(value,row,index){
    	var html='';
    	if(row.primiss==0){
	        html+='<span class="bg475" onClick="view('+"'"+row.caseId+"'"+');">查看</span>';
	        if(row.approveStatus=='0'){
	    		if(row.caseStatus=='0'){
	    			html+='<span class="bg475" onClick="approve('+"'"+row.caseId+"'"+');">批复</span>';
	        	}
	    	}
    	}
        return html;
    }
    //请求服务数据时所传参数
    function queryParams(params){
        return{
            //每页多少条数据
            pageSize: params.limit,
            //请求第几页
            pageNum:params.pageNumber,
            propName:$('#propName').val(),
            acceptanceNo:$('#acceptanceNo').val(),
            startTime:$('#startTime').val(),
            endTime:$('#endTime').val(),
            duties:$('#duties').val(),
            toAudit:toAudit,
            underReview:underReview,
            approved:approved
        }
    }
    //查询按钮事件
    $('#search_btn').click(function(){
       $('#caseList').bootstrapTable('refresh', {url: '${appCtx}/case/caseinfo/list'});
    });

    //待审核
    $('#toAudit').click(function(){
        removeClass();
        $('#toAudit').addClass('bg475');
        toAudit=-1;
        underReview=null;
        approved=null;
        $('#caseList').bootstrapTable('refresh', {url: '${appCtx}/case/caseinfo/list'});
    });
    //审核中
    $('#underReview').click(function(){
        removeClass();
        $('#underReview').addClass('bg475');
        toAudit=null;
        underReview=-1;
        approved=null;
        $('#caseList').bootstrapTable('refresh', {url: '${appCtx}/case/caseinfo/list'});
    });

    //已审核
    $('#approved').click(function(){
        removeClass();
        $('#approved').addClass('bg475');
        toAudit=null;
        underReview=null;
        approved=-1;
        $('#caseList').bootstrapTable('refresh', {url: '${appCtx}/case/caseinfo/list'});
    });

    //全部
    $('#all').click(function(){
        removeClass();
        $('#all').addClass('bg475');
        $('#caseList').bootstrapTable('refresh', {url: '${appCtx}/case/caseinfo/list'});
    });

    //去掉class
    function removeClass(){
    	for(var i=0;i<timerArr.length;i++){
    		clearInterval(timerArr[i]);
    	}
    	toAudit=null;
        underReview=null;
        approved=null;
        $("#toAudit").removeClass("bg475");
        $("#underReview").removeClass("bg475");
        $("#approved").removeClass("bg475");
        $("#all").removeClass("bg475");
    }

    
    //查看案件详情
    function view(caseId){
    	//location.href="${appCtx}/case/caseinfo/"+caseId+"/arbitrationRequest";
    	//Request.loadMain({url:"case/caseinfo/"+caseId+"/arbitrationRequest",max:true,container:"#id"});
    	Request.loadMain({url:"case/caseinfo/"+caseId+"/arbitrationRequest",max:true});
    }
    //批复案件
    function approve(caseId){
    	//location.href="${appCtx}/initate/audit/"+caseId;
    	Request.loadMain({url:"initate/audit/"+caseId,max:true});
    }
    
    //和解申请
   /*  function apply(caseId){
    	//location.href="${appCtx}/compromise/apply/"+caseId;
    	Request.loadMain({url:"compromise/apply/"+caseId});
    } */
    
    
    /* function casejuis(caseId){
    	Request.loadMain({url:"case/jurisdis?caseId=201712061336640037879377&counterclaimFlag=0&approveType=4&docType=17"});
    } */
</script>
