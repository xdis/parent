package com.zyxy.service.micro.core.controller;

import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.domain.SysFile;
import com.zyxy.common.dto.BankFourElementDTO;
import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.dto.MailInfoDTO.Attachment;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.enums.SysEnum;
import com.zyxy.common.service.LoginService;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.PayItemVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微服务测试
 *
 * @author tanquan
 */
@Api(description="微服务测试模块")
@RequestMapping("/public")
@Controller
public class TestMicroServiceController extends BaseController{

	private final static Logger logger = LoggerFactory.getLogger(TestMicroServiceController.class);

	@Autowired
	private MicroFileService microFileService;

	@Autowired
	private MicroMessageService microMessageService;

	@Autowired
	private MicroThirdService microThirdService;

	@Autowired
	private LoginService loginService;


    @ApiOperation(value = "文件上传测试")
    @RequestMapping(value = "/uploadDoc", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<String> uploadFiles(
            HttpServletRequest request,
            @ApiParam(value = "文件") @RequestParam(required = true) MultipartFile uploadFile) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "文件上传";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public"
                : sessionUser.getId(), busiDesr, RequestUtil
                .getParamMap(request));
        ApiResultVO<String> ret = microFileService.uploadFile("1000000000000001", SysEnum.FileBuzzType.CASE_DOC.getCode(), uploadFile);

        return ret;

    }

    @ApiOperation(value = "文件下载测试")
    @RequestMapping(value = "/downloadDoc", method = {RequestMethod.POST })
    @ResponseBody
    public ResponseEntity<byte[]> downloadFiles(
            HttpServletRequest request,
            @ApiParam(value = "文件ID") @RequestParam(required = true) String id) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "文件下载";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public"
                : sessionUser.getId(), busiDesr, RequestUtil
                .getParamMap(request));
        return microFileService.downloadFile(id);
    }

    @ApiOperation(value = "文件-查看摘要信息")
    @RequestMapping(value = "/viewFileInfo", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<SysFile> viewFileInfo(
            HttpServletRequest request,
            @ApiParam(value = "文件ID") @RequestParam(required = true) String id) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "文件下载";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public"
                : sessionUser.getId(), busiDesr, RequestUtil
                .getParamMap(request));

        ApiResultVO<SysFile> ret = microFileService.getFileInfoById(id);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ret;
    }

    @ApiOperation(value = "消息服务-发送短信测试")
    @RequestMapping(value = "/sendSmsTest", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<String> sendSmsTest(
            HttpServletRequest request,
            @ApiParam(value = "手机号") @RequestParam(required = true) String phoneNo
            ,@ApiParam(value = "用户编号") @RequestParam(required = false) String userId
            ,@ApiParam(value = "业务编号") @RequestParam(required = false) String buzzId
            ) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "短信发送";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public"
                : sessionUser.getId(), busiDesr, RequestUtil
                .getParamMap(request));

        Map<String, String> params = new HashMap<>();
        params.put("code", "345221");
        params.put("validMin", "10");
        ApiResultVO<String> ret = microMessageService.sendSms(phoneNo, "1001", JsonUtil.toJson(params), userId, buzzId);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ret;
    }

    @ApiOperation(value = "支付服务-获取缴费项目信息")
    @RequestMapping(value = "/getPayItems.json", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<List<PayItemVO>> getPayItems(
            HttpServletRequest request
            , @ApiParam("usages") @RequestParam(required=true) Integer usages
            ) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "支付服务-获取缴费项目信息";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public" : sessionUser.getId(), busiDesr, RequestUtil.getParamMap(request));

        ApiResultVO<List<PayItemVO>> ret = microThirdService.getPayItems(usages);

        // 该日志必不可少
        logger.info("执行业务[{}]完成", busiDesr);
        return ret;
    }

    @ApiOperation(value = "消息服务-发送邮件测试")
    @RequestMapping(value = "/sendMailTest", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<String> sendMailTest(
            HttpServletRequest request
            , @ApiParam("收件人") @RequestParam(required=true) String to
            , @ApiParam("标题") @RequestParam(required=true) String subject
            , @ApiParam("内容") @RequestParam(required=true) String content
            ) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "邮件发送";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public" : sessionUser.getId(), busiDesr, RequestUtil.getParamMap(request));

        MailInfoDTO info = new MailInfoDTO();
        info.setAttachments(new Attachment[]{new Attachment(new File("/root/files/testFile/仲裁平台表设计.zip")), new Attachment(new File("/root/files/testFile/2016113016144800000803_20171107.txt"))});
        info.setTo(new String[]{to});
        info.setCc(new String[] {"718001160@qq.com", "tan.quan@ielpm.com"});
        info.setIsSimmple(false);
        info.setSubject(subject);
        info.setContent(content);

        ApiResultVO<String> ret = microMessageService.sendMail(info);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ret;
    }

    @ApiOperation(value = "三方服务-缴费测试（生成缴费通知书）")
    @RequestMapping(value = "/genPayNote.do", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<String> genPayNote(
            HttpServletRequest request
            , @Valid PayInfoDTO info
            , BindingResult bdResult
            ) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "缴费（生成缴费通知书）";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public" : sessionUser.getId(), busiDesr, RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }

        ApiResultVO<String> ret = microThirdService.genPayNote(info);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ret;
    }

    @ApiOperation(value = "三方服务-获取缴费二维码测试")
    @RequestMapping(value = "/getPayNoteQrCode.do", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<String> getPayNoteQrCode(
            HttpServletRequest request
            , @RequestParam(required=true) String id
            ) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "获取缴费二维码测试";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public" : sessionUser.getId(), busiDesr, RequestUtil.getParamMap(request));

        ApiResultVO<String> ret = microThirdService.getPayNoteQrCode(id);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ret;
    }

    /**
     * 支付服务-查询支付详情及缴费状态
     * @param request
     * @param id
     * @return
     */
    @ApiOperation(value="支付服务-查询支付详情及缴费状态")
    @RequestMapping(value = "/queryOrder.do", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<PayOrder> queryOrder(HttpServletRequest request
            ,@RequestParam(required=true) String id
            ) {
        // 该日志必不可少
        String busiDesr = "支付服务-查询支付详情及缴费状态";
        logger.info("开始业务[{}]-参数:{}",  RequestUtil.getParamMap(request));

        ApiResultVO<PayOrder> ret = microThirdService.queryOrder(id);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(ret.getBody());
    }

    /**
     * 支付服务-取消订单（缴款通知书）
     * @param request
     * @param id
     * @return
     */
    @ApiOperation(value="支付服务-取消订单（缴款通知书）")
    @RequestMapping(value = "/cancleOrder.do", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> cancleOrder(HttpServletRequest request
            ,@RequestParam(required=true) String id
            ) {
        // 该日志必不可少
        String busiDesr = "支付服务-取消订单（缴款通知书）";
        logger.info("开始业务[{}]-参数:{}",  RequestUtil.getParamMap(request));

        ApiResultVO<String> ret = microThirdService.cancleOrder(id);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ret;
    }


    @ApiOperation(value = "认证服务-银行卡四要素验证测试")
    @RequestMapping(value = "/verifyBankFourElement.do", method = {RequestMethod.POST })
    @ResponseBody
    public ApiResultVO<String> getPayNoteQrCode(
            HttpServletRequest request
            , @Valid BankFourElementDTO info
            , BindingResult bdResult
            ) {
        SecurityUserVO sessionUser = super.getSessionUser();
        // 该日志必不可少
        String busiDesr = "认证服务-银行卡四要素验证测试";
        logger.info("用户[{}]开始业务[{}]-参数:{}", sessionUser == null ? "~public" : sessionUser.getId(), busiDesr, RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }

        ApiResultVO<String> ret = microThirdService.verifyBankFourElement(info);

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ret;
    }

    @ApiOperation(value = "后台登录服务-登录")
    @RequestMapping(value = "/login.do", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> login() {
        logger.info(loginService.login("admin", "123123", "ARBITRATOR"));
        return ok();
    }
}
