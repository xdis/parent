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
            <span>标题</span>
            <input id="title" style="width:210px"  type="text" placeholder="请输入申请人/被申请人/代理人"/>
        </label>

        <label class="mgb20">
            <span>发布时间</span>
            <input type="text" id="createStartTime" placeholder="请输入开始时间" />至
            <input type="text" id="createEndTime" placeholder="请输入结束时间" />
        </label>

        <label class="mgb20">
            <span>通知对象</span>
            <select id="releaseType">
                <option value="0">全部</option>
                <option value="1">申请人</option>
                <option value="2">被申请人</option>
                <option value="3">代理人</option>
                <option value="4">仲裁员</option>
            </select>
        </label>



        <ul class="form-header-ul clearfix">
            <li id="news">发布消息</li>
        </ul>
        <button class="seek bg475" id="search_btn" type="button">查询</button>
    </form>
    <table id="sysMessageList" class="table table-hover table-striped"></table>
</div>
<%--引入的js文件--%>
<script src="${appCtx}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table.min.js"></script>
<script src="${appCtx}/static/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script>
    $(function(){
        laydate({
            elem: '#createStartTime',
            format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
            festival: true, //显示节日
            choose: function(datas){ //选择日期完毕的回调
                //console.log('得到：'+datas);
            }
        });

        laydate({
            elem: '#createEndTime',
            format: 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
            festival: true, //显示节日
            choose: function(datas){ //选择日期完毕的回调
                //console.log('得到：'+datas);
            }
        });
        laydate.skin('molv');
        laydate.skin('molv');
    })

    //生成用户数据
    $('#sysMessageList').bootstrapTable({
        method: 'post',
        url:"${appCtx}/release/message/sysMessageList",//要请求数据的文件路径
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
                title: '标题',//标题  可不加
                field:'title'
            },
            {
                title:'通知对象',
                formatter:releaseType
            },
            {
                title:'发布时间',
                field:'createTime'
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
        onLoadError:function(status){
            if(status=='9995'){
                layer.alert("查询参数输入错误", {
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

    //转换通知对象
    function releaseType(value,row,index){
        var releaseType;
        if(row.releaseType=='0'){
            releaseType='全部';
        }else if(row.releaseType=='1'){
            releaseType='申请人';
        }else if(row.releaseType=='2'){
            releaseType='被申请人';
        }else if(row.releaseType=='3'){
            releaseType='代理人';
        }else{
            releaseType='仲裁员';
        }
        return releaseType;
    }

    //三个参数，value代表该列的值
    function operateFormatter(value,row,index){
        var html='<span class="bg475" onClick="view('+"'"+row.id+"'"+');">查看</span>';
        return html;
    }
    //请求服务数据时所传参数
    function queryParams(params){
        return{
            //每页多少条数据
            pageSize: params.limit,
            //请求第几页
            pageNum:params.pageNumber,
            title:$('#title').val(),
            releaseType:$('#releaseType').val(),
            createStartTime:$('#createStartTime').val(),
            createEndTime:$('#createEndTime').val()
        }
    }
    //查询按钮事件
    $('#search_btn').click(function(){
        $('#sysMessageList').bootstrapTable('refresh', {url: '${appCtx}/release/message/sysMessageList'});
    });



    //查看系统消息详情
    function view(id){
        Request.loadMain({url:"release/message/"+id+"/messageDetail"});
    }

    //点击发布消息
    $('#news').click(function(){
        Request.loadMain({url:"release/message"});
    });
</script>
