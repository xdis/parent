<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
	<%--引入的css文件--%>
    <link href="${appCtx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${appCtx}/static/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">

	<link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/caseDetail.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/userIndex.css"/>
    
           <form class="form-header validForm" action="#" method="get">
               <label class="mgb20">
                   <span>姓名</span>
                   <input id="name" style="width:210px"  type="text" placeholder=""/>
               </label>
              <label class="mgb20">
                <span>手机号</span>
                <input id="phone" style="width:210px"  type="text" placeholder=""/>
              </label>
               <label class="mgb20">
                   <span>接案状态</span>
                   <select id="status">
                       <option value="">全部</option>
                       <option value="0">正常</option>
                       <option value="1">停用</option>
                   </select>
               </label>
               
                <ul class="form-header-ul clearfix">
                   <li class="bg475" id="all">全部</li>
                   <li id="toAudit">正常</li>
                   <li id="underReview">黑名单</li>
               </ul>
               <button class="seek bg475" id="search_btn" type="button">查询</button>
           </form>
           <table id="caseList" class="table table-hover table-striped"></table>
           
<%--引入的js文件--%>
<script src="${appCtx}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script>

	var toAudit;
	var underReview;
	var approved;
    $(function(){
    	
    	 /* laydate({
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
    	    laydate.skin('molv'); */
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
        url:"${appCtx}/arbitrator/administer/list",//要请求数据的文件路径
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
                title:'仲裁员姓名 ',
                field:'name'
            },
            {
                title:'手机号',
                field:'phone'
            },
            {
                title:'擅长领域',
                field:'specialty'
            },

            {
                title:'创建时间 ',
                formatter:createDate
            },
         
            {
                title:'当前状态 ',
                formatter:blackList
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
    
     // 是否接案状态
    function blackList(value,row,index){
    	var statusMsg='';
    
    		if(row.blackList=='0'){
        		statusMsg='正常';
        	}else if(row.blackList=='1'){
        		statusMsg='停用';
        		
        		
        		
        	}
    	
    	return statusMsg;
    }
    
    // 创建时间
    function createDate(value,row,index){
    	var msg=row.createDate;
    	return msg.substring(0,4)+'-'+msg.substring(4,6)+'-'+msg.substring(6,8);
    }
     
    
    //设置class
    function cellStyle(value,row,index){
    	return{ 'classes': 'timeSet'+index}
    }
    //三个参数，value代表该列的值
    function operateFormatter(value,row,index){
    
    	var html='';
    	 html+='<span class="bg475" onClick="view('+"'"+row.id+"'"+');">查看</span>';
    	if(underReview==null){
    		
    		    if(row.blackList!='1'){
    		    	html+='<span class="bg475" onClick="disable('+"'"+row.id+"'"+');">禁用</span>';
    		    }

    		    if(row.status=='0'){
    		    	 html+='<span class="bg475" onClick="auditInfo('+"'"+row.id+"'"+');">信息审核</span>';
    		    }
    	}else{
    		var deleteStatus=1;
    		var blackListStatus=0;
    		 html+='<span class="bg475" onClick="deleteOrReinstateNormal('+"'"+row.id+"'"+',1,null);">删除</span>';
    		 html+='<span class="bg475" onClick="deleteOrReinstateNormal('+"'"+row.id+"'"+',null,0);">移出黑名单</span>';
    		
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
            name:$('#name').val(),
            phone:$('#phone').val(),
            status:$('#status').val(),
            createTime:$('#createTime').val(),
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
       $('#caseList').bootstrapTable('refresh', {url:'${appCtx}/arbitrator/administer/list'});
    });
    
    //正常
    $('#toAudit').click(function(){
        removeClass();
        $('#toAudit').addClass('bg475');
        toAudit=0;
        underReview=null;
        approved=null;
        $('#caseList').bootstrapTable('refresh', {url:'${appCtx}/arbitrator/administer/list'});
    });
    
    //黑名单
    $('#underReview').click(function(){
        removeClass();
        $('#underReview').addClass('bg475');
        toAudit=null;
        underReview=1;
        approved=null;
        $('#caseList').bootstrapTable('refresh', {url:'${appCtx}/arbitrator/administer/list'});
    });

   
    //全部
    $('#all').click(function(){
        removeClass();
        $('#all').addClass('bg475');
        $('#caseList').bootstrapTable('refresh', {url: '${appCtx}/arbitrator/administer/list'});
    });
    
    //去掉class
    function removeClass(){
    	toAudit=null;
        underReview=null;
        approved=null;
        $("#toAudit").removeClass("bg475");
        $("#underReview").removeClass("bg475");
        $("#approved").removeClass("bg475");
        $("#all").removeClass("bg475");
    }

	// 查看
	function view(id) {
		location.href="${appCtx}/arbitrator/administer/"+id+"/info";
		// Request.loadMain({url:'${appCtx}/arbitrator/administer/'+id+'/info'});
	}
	
	
	// 查看信息审核
	function auditInfo(id) {
		location.href="${appCtx}/arbitrator/administer/"+id+"/infoAudit";
		// Request.loadMain({url:'${appCtx}/arbitrator/administer/'+id+'/infoAudit'});
	}
	
	
	// 禁用
	function disable(id) {
		$.ajax({
			type : 'post',
			url : '${appCtx}/arbitrator/administer/disable',
			dataType : 'json',
			data : {
				'id' : id
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
	
	
	//删除 
	function deleteOrReinstateNormal(id,deleteStatus,blackListStatus) {
		$.ajax({
			type : 'post',
			url : '${appCtx}/arbitrator/administer/deleteOrReinstateNormal',
			dataType : 'json',
			data : {
				'id' : id,
				'deleteStatus':deleteStatus,
				'blackListStatus':blackListStatus
				
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
	
</script>
