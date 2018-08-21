<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="appCtx" value="${pageContext.request.contextPath}"/>
<script src="${appCtx}/static/js/jquery-3.2.1.min.js"></script>
<script src="${appCtx}/static/vendor/laydate/laydate.js"></script>
<script src="${appCtx}/static/vendor/layer/layer.js"></script>
<script src="${appCtx}/static/js/Request.js"></script>
<script src="${appCtx}/static/js/wendu.ajaxhook.min.js"></script>
<script src="${appCtx}/static/js/public.js"></script>
 <script type="text/javascript">
    <!--
    var cxt = "${pageContext.request.contextPath}/";
    var access_token = "${param.access_token}";

    /**
     * 处理url，加上token
     * @param url url
     * @returns 加上token后的url
     * @author jax
     */
    function urlDeal(url) {
        if (url.endsWith("uaa/oauth/token")) {
            return url;
        }
        if (url.indexOf("?") !== -1) {
            //有传参数情况
            if (url.endsWith("?")) {
                //以?结尾的情况,www.baidu.com?
                url += "access_token=" + access_token;
            } else {
                //带了参数的情况,www.baidu.com?wd=1
                url += "&access_token=" + access_token;
            }
        } else {
            //无传参数的情况,www.baidu.com
            url += "?access_token=" + access_token;
        }
        return url;
    }

    hookAjax({
        open: function (arg) {
//        this.xhr.setRequestHeader("Authorization", "Bearer "+token);
            arg[1] = urlDeal(arg[1]);
        }
    });

    function href(url) {
        var urled = urlDeal(url);
        window.location.href = urled;
    }



    //变更仲裁请求
    function change(caseId){
        Request.loadMain({url:"case/changeRecord",max:true,container:".case-main",params:'caseId='+caseId+'&counterclaimFlag=0'+'&approveType=ALTERATION_ARBITRATION_REQUEST'});
    }
    //变更仲裁反请求
    function changeCounterclaim(caseId){
        Request.loadMain({url:"case/processing/"+caseId+"/changeCounterclaim",max:true,container:".case-main"});
    }

    //本请求管辖权异议
    function thisJuisdic(caseId) {
        Request.loadMain({url:"case/jurisdis",max:true,container:".case-main",params:'caseId='+caseId+'&counterclaimFlag=0&approveType=JURISDICTION_OBJECTION_APPROVAL&docType=17'});
    }

    //反请求管辖权异议
    function counterclaimJuisdic(caseId) {
        Request.loadMain({url:"case/jurisdis",max:true,container:".case-main",params:'caseId='+caseId+'&counterclaimFlag=1&approveType=COUNTERCLAIM_JURISDICTION_APPROVAL&docType=18'});
    }

    //-->


</script>