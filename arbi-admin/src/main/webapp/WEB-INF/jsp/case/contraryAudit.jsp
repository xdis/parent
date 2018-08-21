<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@include file="../base/taglibs.jsp" %>
<%
	String path = request.getContextPath();
%>
<base href="<%=path%>/">
	<%--引入的css文件--%>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="static/bootstrap/css/bootstrap-table.min.css" rel="stylesheet">

	<link rel="stylesheet" href="static/css/common.css"/>
    <link rel="stylesheet" href="static/css/caseDetail.css"/>
    <link rel="stylesheet" href="static/css/userIndex.css"/>
    
           <form class="form-header validForm" action="#" method="get">
               <label class="mgb20">
                   <span>打款方</span>
                   <input id="moneyName" style="width:150px"  type="text" placeholder=""/>
               </label>
               <label class="mgb20">
                   <span>打款账号</span>
                   <input id="moneyAccount" style="width:150px"  type="text" placeholder=""/>
               </label>
               <label class="mgb20">
                   <span>提交时间</span>
                   <input id="initTime" class="input form-control search-input createTime" style="width:150px"  type="text" placeholder="" class="form-control search-input createTime"/>
                 	至
                   <input id="cutoffTime" class="input form-control search-input createTime" style="width:150px"  type="text" placeholder="" class="form-control search-input createTime"/>
               </label>
               <label class="mgb20">
                   <span>状态</span>
                   <select id="status">
                       <option value="">全部</option>
                       <option value="0">待审核</option>
                       <option value="1">审核通过</option>
                       <option value="2">驳回</option>
                   </select>
               </label>
               <button class="seek bg475" id="search_btn" type="button">查询</button>
           </form>
           <table id="caseList" class="table table-hover table-striped"></table>
           
<%--引入的js文件--%>
<script src="static/vendor/jquery-2.1.1.min.js"></script>
<script src="static/vendor/laydate/laydate.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/bootstrap/js/bootstrap-table.min.js"></script>
<script src="static/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script>
	var toAudit;
	var underReview;
	var approved;
    $(function(){
    	  laydate({
    	        elem: '#initTime',
    	        format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
    	        festival: true, //显示节日
    	        choose: function(datas){ //选择日期完毕的回调
    	            //console.log('得到：'+datas);
    	        }
    	    });

    	  laydate({
    	        elem: '#cutoffTime',
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
        url:"${appCtx}/contrary/audit/list ",//要请求数据的文件路径
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
                title:'打款方',
                formatter:moneyName
            },
            {
                title:'审核应缴（元）',
                field:'amount'
            },
            {
                title:'打款银行',
                field:'moneyBank'
            },
            {
                title:'打款账号',
                formatter:moneyAccount
            },
            {
                title:'备注',
                formatter:'remark'
            },
            {
                title:'提交时间 ',
                formatter:'createTime'
            },
            {
                title:'状态 ',
                formatter:status
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
                    skin: 'layui-layer-lan', //样式类名
                    closeBtn: 0,
                    offset: ['200px', '500px']
                });
        	}else if(status=='9001'){
        		layer.alert("无此权限", {
                    skin: 'layui-layer-lan', //样式类名
                    closeBtn: 0,
                    offset: ['200px', '500px']
                });
        	}else{
        		layer.alert("系统异常", {
                    skin: 'layui-layer-lan', //样式类名
                    closeBtn: 0,
                    offset: ['200px', '500px']
                });
        	}
        }
    })
    
    //案件状态
    function status(value,row,index){
    	var statusMsg='待审核';
    
    		if(row.status=='0'){
        		statusMsg='待审核';
        	}else if(row.status=='1'){
        		statusMsg='审核通过';
        	}else if(row.status=='2'){
        		statusMsg='驳回';
        	}	
    	
    	return statusMsg;
    }
    
 	//  驳回名字显示为红色
    function moneyName(value,row,index){
    	var msg=row.status;
    	var name=row.moneyName;
    	if(msg=='2'){
    		return '<font color=red>'+name+'</font>';
    	}
    	return name;
    }
    
    //设置class
    function cellStyle(value,row,index){
    	return{ 'classes': 'timeSet'+index}
    }
    
    //三个参数，value代表该列的值
    function operateFormatter(value,row,index){
    	var html='';
    	if(row.status==0){
	        html+='<span class="bg475" onClick="view('+"'"+row.id+"'"+');">通过</span>';
	        html+='<span class="bg475" onClick="approve('+"'"+row.id+"'"+');">驳回 </span>'; 
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
            moneyName:$('#moneyName').val(),
            moneyAccount:$('#moneyAccount').val(),
            initTime:$('#initTime').val(),
            cutoffTime:$('#cutoffTime').val(),
            status:$('#status').val(),
            toAudit:toAudit,
            underReview:underReview,
            approved:approved
        }
    }
    
    //查询按钮事件
    $('#search_btn').click(function(){
       $('#caseList').bootstrapTable('refresh', {url: '${appCtx}/contrary/audit/list'});
    });

	//去掉class
	function removeClass() {
		toAudit = null;
		underReview = null;
		approved = null;
		$("#toAudit").removeClass("bg475");
		$("#underReview").removeClass("bg475");
		$("#approved").removeClass("bg475");
		$("#all").removeClass("bg475");
	}

	// 通过
	function view(id) {
		$.ajax({
			type : 'post',
			url : '${appCtx}/contrary/audit/audit',
			dataType : 'json',
			data : {
				'id' : id,
				'operation' : '1', //  通过
			},
			success : function(json) {
				if (json.head.retCode == '0000') {
					//成功 
					location.reload();
				} else {
					//出错  
					layer.alert(json.head.msg, {
						skin : 'layui-layer-lan', //样式类名
						closeBtn : 0
					});
				}
			}
		});
	}

	// 驳回
	function approve(id) {
		$.ajax({
			type : 'post',
			url : '${appCtx}/contrary/audit/audit',
			dataType : 'json',
			data : {
				'id' : id,
				'operation' : '2', //  驳回
			},
			success : function(json) {
				if (json.head.retCode == '0000') {
					//成功 
					location.reload();
				} else {
					//出错  
					layer.alert(json.head.msg, {
						skin : 'layui-layer-lan', //样式类名
						closeBtn : 0
					});
				}
			}
		});
	}
</script>
