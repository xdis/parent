<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../base/taglibs.jsp"%>
    <link rel="stylesheet" href="${appCtx}/static/css/common.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/granted.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/numberCount.css"/>
    <link rel="stylesheet" href="${appCtx}/static/css/userIndex.css"/>
                <div class="zhong-right z-bg-fff min-height450" style="padding: 35px;">
                    <h4>发布通知</h4>
                    <form class="add-role" action="#">
                        <label class="label" style="margin-top: 46px">
                            <span>发布对象</span>
                            <select id="releaseType">
                                <option value="0">全部</option>
                                <option value="1">申请人</option>
                                <option value="2">被申请人</option>
                                <option value="3">代理人</option>
                                <option value="4">仲裁员</option>
                            </select>
                        </label>
                        <label class="label">
                            <span>标题</span>
                            <input id="title" class="role-name" type="text" maxlength="10" placeholder="请输入10个以内的字符"/>
                        </label>
                        <label class="label">
                            <span>通知正文</span>
                            <textarea id="messageBody" class="role-describe" maxlength="100" placeholder="请输入100个以内的字符"></textarea>
                        </label>
                        <input readonly="readonly" type="button" id="submit" class="seek-btn bg475" style="margin: 30px" value="发布">
                        <input readonly="readonly" id="btn" class="seek-btn bg475" value="取消">

                    </form>
                </div>
                
                <script type="text/javascript">


                	$(function(){
                		$("#submit").click(function(){
                		    var title=$("#title").val();
                		    var messageBody=$("#messageBody").val();
                		    var releaseType=$("#releaseType").val();

                            $.ajax({
                                url : "release/message/news",
                                type : "POST",
                                data : {
                                    'title' : title,
                                    'messageBody' : messageBody,
                                    'releaseType' : releaseType
                                },

                                success : function(data) {

                                    var retCode = data.head.retCode;
                                    var msg = data.head.msg;

                                    if (retCode == '0000') {
                                        Request.loadMain({url:"release/message/list"});
                                    } else {
                                        layer.msg(msg, {
                                            icon : 5
                                        });
                                    }

                                },
                                error : function() {
                                    layer.msg('系统异常', {
                                        icon : 6
                                    });
                                }
                            });
                		})
                		$("#btn").click(function(){
                            Request.loadMain({url:"release/message/list"});
                		})
                	})
                </script>