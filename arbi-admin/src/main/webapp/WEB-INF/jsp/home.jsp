<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <p class="left-title">
            <span>用户管理</span>
            <i class="icon anticon icon-right"></i>
            <span>仲裁委后台用户管理</span>
        </p>
        <section class="z-main ">
            <section class="z-main clearfix nopadding">
                <div class="zhong-left z-bg-fff">
                    <ul class="zhong-left-ul">
                        <li class="bg475">仲裁委后台用户管理</li>
                        <li>仲裁员管理</li>
                        <li>平台注册用户管理</li>
                    </ul>
                </div>
                <div class="zhong-right z-bg-fff" style="padding: 0 20px;">
                    <form class="form-header validForm">
                        <label>
                            <input type="text" placeholder=""/>
                        </label>
                        <label>
                            <span>角色</span>
                            <select>
                                <option >全部</option>
                                <option >立案部秘书</option>
                                <option >立案部部长</option>
                                <option >立案部主任</option>
                            </select>
                        </label>
                        <label>
                            <span>按创建日期</span>
                            <input type="date" placeholder="请输入开始时间" class="form-control search-input createTime"/>
                        </label>
                        <label>
                            <span>启用状态</span>
                            <select>
                                <option >全部</option>
                                <option >立案部秘书</option>
                                <option >立案部部长</option>
                                <option >立案部主任</option>
                            </select>
                        </label>
                        <button class="seek-btn bg475">查询</button>
                        <ul class="form-header-ul clearfix">
                            <li class="bg475">新建帐号</li>
                        </ul>

                    </form>
                    <table class="table table-striped">
                        <tbody>
                        <!--表格头部开始-->
                        <tr class="first-tr">
                            <td class="index-td">序号</td>
                            <td>收案号</td>
                            <td>申请人</td>
                            <td>被申请人</td>
                            <td>案件进展</td>
                            <td>当前责任人</td>
                            <td>申请时间</td>
                            <td>案件排队时间</td>
                            <td>操作</td>
                        </tr>
                        <!--表格头部结束-->
                        <!--表格主题开始(渲染数据部分开始)-->
                        <tr>
                            <td>1</td>
                            <td>100011212</td>
                            <td>建设银行北京硅谷分行</td>
                            <td>常量</td>
                            <td>立案</td>
                            <td>立案秘书</td>
                            <td>2016-10-30 13:24:29</td>

                            <td class="lightblue">1小时20分30秒</td>
                            <td class="lightblue last-td">
                                <span class="bg475">查看</span>
                                <span class="bg475">审核</span>
                            </td>

                        <tr>
                            <td>1</td>
                            <td>100011212</td>
                            <td>建设银行北京硅谷分行</td>
                            <td>常量</td>
                            <td>立案</td>
                            <td>立案秘书</td>
                            <td>2016-10-30 13:24:29</td>

                            <td class="lightblue">1小时20分30秒</td>
                            <td class="lightblue">
                                <span class="bg475">查看</span>
                                <span class="bg475">批复</span>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>100011212</td>
                            <td>建设银行北京硅谷分行</td>
                            <td>常量</td>
                            <td>立案</td>
                            <td>立案秘书</td>
                            <td>2016-10-30 13:24:29</td>

                            <td class="lightblue">1小时20分30秒</td>
                            <td class="lightblue">
                                <span class="bg475">查看</span>
                                <span class="bg475">审核</span>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>100011212</td>
                            <td>建设银行北京硅谷分行</td>
                            <td>常量</td>
                            <td>立案</td>
                            <td>立案秘书</td>
                            <td>2016-10-30 13:24:29</td>

                            <td class="lightblue">1小时20分30秒</td>
                            <td class="lightblue">
                                <span class="bg475">查看</span>
                                <span class="bg475">审核</span>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>100011212</td>
                            <td>建设银行北京硅谷分行</td>
                            <td>常量</td>
                            <td>立案</td>
                            <td>立案秘书</td>
                            <td>2016-10-30 13:24:29</td>

                            <td class="lightblue">1小时20分30秒</td>
                            <td class="lightblue">
                                <span class="bg475">查看</span>
                                <span class="bg475">审核</span>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>100011212</td>
                            <td>建设银行北京硅谷分行</td>
                            <td>常量</td>
                            <td>立案</td>
                            <td>立案秘书</td>
                            <td>2016-10-30 13:24:29</td>

                            <td class="lightblue">1小时20分30秒</td>
                            <td class="lightblue">
                                <span class="bg475">查看</span>
                                <span class="bg475">审核</span>
                            </td>
                        </tr>
                        <!--表格主题结束(渲染数据部分结束)-->
                        </tbody>
                    </table>
                    <!--分页器-->
                    <div class="page-detail">
                        <ul class="clearfix">
                            <li><i class="icon anticon icon-left"></i></li>
                            <li>1</li>
                            <li>2</li>
                            <li>3</li>
                            <li>4</li>
                            <li>5</li>
                            <li>6</li>
                            <li>...</li>
                            <li><i class="icon anticon icon-left"></i></li>
                            <div class="jump">到第 <input type="text">页 <b class="btn bg475">确定</b></div>
                        </ul>
                    </div>
                </div>
