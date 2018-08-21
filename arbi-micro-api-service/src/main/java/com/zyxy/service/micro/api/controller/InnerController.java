package com.zyxy.service.micro.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyxy.common.domain.ApiOrgCertExample;
import com.zyxy.common.domain.ApiOrgCertWithBLOBs;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.api.service.ApiOrgCertService;

/**
 * 内部功能
 * @author sonta
 *
 */
@Api(description="内部功能")
@RequestMapping("/inner")
@Controller
public class InnerController extends BaseController{
    
    @Autowired
    private ApiOrgCertService apiOrgCertService;
    
	@ApiOperation(value="初始化指定机构/用户")
	@RequestMapping(value = "/initOrg.do", method = {RequestMethod.POST})
	@ResponseBody
	public ApiResultVO<String> initOrg(HttpServletRequest request
	        , @RequestParam(required=true) String orgNo
	        ) {
	    // 该日志必不可少
        String busiDesr = "初始化指定机构/用户";
        logger.info("开始业务[{}]-参数:{}",  RequestUtil.getParamMap(request));
        
        apiOrgCertService.generateCert(orgNo, "arbi321");
        
        // 该日志必不可少
        logger.info("执行业务[{}]完成，返回-{}:{}", busiDesr);
	    return super.ok();
	}
	
	@ApiOperation(value = "机构/用户证书下载")
    @RequestMapping(value = "/downloadCert", method = {RequestMethod.POST,  RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<byte[]> downloadCert(
            HttpServletRequest request
            ,@ApiParam(value="机构/用户编号")@RequestParam(required=true) String orgNo
            ,@ApiParam(value = "证书类型：0-客户端私钥，1-服务端公钥") @RequestParam(required = true)Integer type
            ) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "机构/用户证书下载";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public"
                : sessionUser.getId(), busiDesr, RequestUtil
                .getParamMap(request));
        ApiOrgCertExample ex = new ApiOrgCertExample();
        ex.createCriteria().andOrgIdEqualTo(orgNo).andStatusEqualTo(1);
        List<ApiOrgCertWithBLOBs> certList = apiOrgCertService.selectByExampleWithBLOBs(ex);
        if (certList == null || certList.isEmpty()) {
            return new ResponseEntity<byte[]>("数据不存在".getBytes(), null, HttpStatus.NOT_FOUND);
        }
        ApiOrgCertWithBLOBs cert = certList.get(0);
        
        HttpHeaders headers = new HttpHeaders();
        String dfileName = "";
        try {
            dfileName = new String(type == 0 ? cert.getCltPrivateCertName().getBytes("gb2312") : cert.getPltPublicKeyName().getBytes("gb2312"),
                    "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(type == 0 ? cert.getCltPrivateCert() : cert.getPltPublicKey(), headers, HttpStatus.OK);
    }
}
