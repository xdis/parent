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
	<link href="${appCtx}/static/css/aduitstyles.css" type="text/css" rel="stylesheet"/>
	
    
        
        
         <!-- Unnamed (组合) -->
      <div id="u19005" class="ax_default">
      
      <div id="u19053" class="ax_default _二级标题">
        <div id="u19053_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19054" class="text" style="visibility: visible;">
          <p><span>仲裁员最新信息</span></p>
        </div>
      </div>      

        <!-- Unnamed (矩形) -->
        <div id="u19006" class="ax_default label">
          <div id="u19006_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19007" class="text" style="visibility: visible;">
            <p><span>姓名：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19008" class="ax_default label">
          <div id="u19008_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19009" class="text" style="visibility: visible;">
            <p><span>出生年月：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19010" class="ax_default label">
          <div id="u19010_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19011" class="text" style="visibility: visible;">
            <p><span>职业：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19012" class="ax_default label">
          <div id="u19012_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19013" class="text" style="visibility: visible;">
            <p><span>专长：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19014" class="ax_default label">
          <div id="u19014_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19015" class="text" style="visibility: visible;">
            <p><span>居住地：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19016" class="ax_default label">
          <div id="u19016_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19017" class="text" style="visibility: visible;">
          <c:if test="${arbitratorInfo.newAddress==arbitratorInfo.sourceAddress}">
            <p><span>${arbitratorInfo.newAddress}</span></p>
          </c:if>
          <c:if test="${arbitratorInfo.newAddress!=arbitratorInfo.sourceAddress}">
            <p><span style="color:#FF0000;">${arbitratorInfo.newAddress}</span></p>
          </c:if>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19018" class="ax_default label">
          <div id="u19018_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19019" class="text" style="visibility: visible;">
            <p><span>${arbitratorInfo.name}</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19020" class="ax_default label">
          <div id="u19020_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19021" class="text" style="visibility: visible;">
            <p><span>${arbitratorInfo.birthDates}</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19022" class="ax_default label">
          <div id="u19022_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19023" class="text" style="visibility: visible;">
            <c:if test="${arbitratorInfo.newOccupation==arbitratorInfo.sourceOccupation}">
           		<p><span>${arbitratorInfo.newOccupation}</span></p>
          	</c:if>
            <c:if test="${arbitratorInfo.newOccupation!=arbitratorInfo.sourceOccupation}">
            	<p><span style="color:#FF0000;">${arbitratorInfo.newOccupation}</span></p>
          	</c:if>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19024" class="ax_default label">
          <div id="u19024_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19025" class="text" style="visibility: visible;">
            <c:if test="${arbitratorInfo.newSpecialty==arbitratorInfo.sourceSpecialty}">
            	<p><span>${arbitratorInfo.newSpecialty}</span></p>
          	</c:if>
            <c:if test="${arbitratorInfo.newSpecialty!=arbitratorInfo.sourceSpecialty}">
            	<p><span style="color:#FF0000;">${arbitratorInfo.newSpecialty}</span></p>
          	</c:if>
          </div>
        </div>

        <!-- Unnamed (图片) -->
        <div id="u19026" class="ax_default image">
          <img id="u19026_img" class="img " src="${arbitratorInfo.newIdCard}"/>
          <!-- Unnamed () -->
          <div id="u19027" class="text" style="display: none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>

      <!-- Unnamed (组合) -->
      <div id="u19028" class="ax_default">

 	<!-- Unnamed (矩形) -->
      <div id="u19051" class="ax_default _二级标题">
        <div id="u19051_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19052" class="text" style="visibility: visible;">
          <p><span>原仲裁员信息</span></p>
        </div>
      </div>

        <!-- Unnamed (矩形) -->
        <div id="u19029" class="ax_default label">
          <div id="u19029_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19030" class="text" style="visibility: visible;">
            <p><span>姓名：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19031" class="ax_default label">
          <div id="u19031_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19032" class="text" style="visibility: visible;">
            <p><span>出生年月：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19033" class="ax_default label">
          <div id="u19033_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19034" class="text" style="visibility: visible;">
            <p><span>职业：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19035" class="ax_default label">
          <div id="u19035_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19036" class="text" style="visibility: visible;">
            <p><span>专长：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19037" class="ax_default label">
          <div id="u19037_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19038" class="text" style="visibility: visible;">
            <p><span>居住地：</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19039" class="ax_default label">
          <div id="u19039_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19040" class="text" style="visibility: visible;">
            <p><span>${arbitratorInfo.sourceAddress}</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19041" class="ax_default label">
          <div id="u19041_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19042" class="text" style="visibility: visible;">
            <p><span>${arbitratorInfo.name}</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19043" class="ax_default label">
          <div id="u19043_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19044" class="text" style="visibility: visible;">
            <p><span>${arbitratorInfo.birthDates}</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19045" class="ax_default label">
          <div id="u19045_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19046" class="text" style="visibility: visible;">
            <p><span>${arbitratorInfo.sourceOccupation}</span></p>
          </div>
        </div>

        <!-- Unnamed (矩形) -->
        <div id="u19047" class="ax_default label">
          <div id="u19047_div" class=""></div>
          <!-- Unnamed () -->
          <div id="u19048" class="text" style="visibility: visible;">
            <p><span>${arbitratorInfo.sourceSpecialty}</span></p>
          </div>
        </div>

        <!-- Unnamed (图片) -->
        <div id="u19049" class="ax_default image">
          <img id="u19049_img" class="img " src="${arbitratorInfo.sourceIdCard}"/>
          <!-- Unnamed () -->
          <div id="u19050" class="text" style="display: none; visibility: hidden">
            <p><span></span></p>
          </div>
        </div>
      </div>
      
            <!-- Unnamed (矩形) -->
      <div id="u19059" class="ax_default label">
        <div id="u19059_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19060" class="text" style="visibility: visible;">
          <p><span>说明：</span></p>
        </div>
      </div>

      <!-- Unnamed (矩形) -->
      <div id="u19061" class="ax_default box_1">
        <div id="u19061_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19062" class="text" style="display: none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- 说明-->
      <div id="u19063" class="ax_default label">
        <div id="u19063_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19064" class="text" style="visibility: visible;">
          <p><span>${arbitratorInfo.newRemark}</span></p>
        </div>
      </div>

		
	  <!-- 按钮 -->

      <!-- Unnamed (矩形) -->
      <div id="u19055" class="ax_default box_1">
        <div id="u19055_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19056" class="text" style="visibility: visible;">
          <p><span onclick="update(0)">确认修改</span></p>
        </div>
      </div>

      <!-- Unnamed (矩形) -->
      <div id="u19057" class="ax_default box_1">
        <div id="u19057_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19058" class="text" style="visibility: visible;">
          <p><span onclick="update(1)">驳回</span></p>
        </div>
      </div>
      
	<script type="text/javascript">
		function update(cid){
			$.ajax({
				type : 'post',
				url : '${appCtx}/arbitrator/administer/updateArbitratorInfo',
				dataType : 'json',
				data : {
					'id':'${arbitratorInfo.id}',
					'newId':'${arbitratorInfo.newId}',
					'newOccupation':'${arbitratorInfo.newOccupation}',
					'newSpecialty':'${arbitratorInfo.newSpecialty}',
					'newSpecialty':'${arbitratorInfo.newSpecialty}',
					'newAddress':'${arbitratorInfo.newAddress}',
					'newIdentityId':'${arbitratorInfo.newIdentityId}',
					'status' : cid
				},
				success : function(json) {
					if (json.head.retCode == '0000') {
						layer.msg('操作成功', {icon: 1});
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

	