package com.zyxy.service.micro.third.controller;

import com.zyxy.common.domain.SignCreateOrganizationLog;
import com.zyxy.common.dto.SignatoryDTO;
import com.zyxy.common.dto.SignatureDTO;
import com.zyxy.common.dto.SignetDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.third.service.FileSignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 文件签名、签章服务
 */
@Api(description = "文件签名、签章服务")
@RequestMapping("/fileSign")
@Controller
public class FileSignController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(FileSignController.class);

    @Autowired
    private FileSignService fileSignService;

    @ApiOperation(value = "签名")
    @RequestMapping(value = "/signature", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> signature(HttpServletRequest request, @Valid @RequestBody SignatureDTO signatureDTO,
            BindingResult bdResult) {
        String busiDesr = "发起文件签名请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        BuzzResultVO<String> result = fileSignService.signature(signatureDTO.getFileId(),
                signatureDTO.getSignatoryDTO(), signatureDTO
                        .getPreservationTitle(), signatureDTO.getSourceRegistryId());

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "获取文件签名完成的文件下载URL")
    @RequestMapping(value = "/signatureDownloadUrl", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> getSignatureDownloadUrl(HttpServletRequest request,
            @RequestParam String signSignatureLogId) {
        String busiDesr = "获取文件签名完成的文件下载URL请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        BuzzResultVO<String> result = fileSignService.getSignatureDownloadUrl(signSignatureLogId);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "签章")
    @RequestMapping(value = "/signet", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> signet(HttpServletRequest request, @Valid @RequestBody SignetDTO signetDTO,
            BindingResult bdResult) {
        String busiDesr = "发起文件签章请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        BuzzResultVO<String> result = fileSignService.signet(signetDTO.getDocFileId(), signetDTO.getMetFileIdList(),
                signetDTO.getContractName(), signetDTO.getSignatoryDTOList(), signetDTO.getSignLevelCode(),
                signetDTO.getDealTypeCode());

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "给特定签章人员发送签章短信")
    @RequestMapping(value = "/signNotify", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<Boolean> signNotify(HttpServletRequest request, @RequestParam String signSignetLogId,
            @Valid @RequestBody SignatoryDTO signatoryDTO, BindingResult bdResult) {
        String busiDesr = "给特定签章人员发送签章短信请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        BuzzResultVO<Boolean> result = fileSignService.signNotify(signSignetLogId, signatoryDTO);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "获取签章完成的文件下载URL")
    @RequestMapping(value = "/fileLink", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> fileLink(HttpServletRequest request, @RequestParam String signSignetLogId) {
        String busiDesr = "获取签章完成的文件下载URL请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        BuzzResultVO<String> result = fileSignService.fileLink(signSignetLogId);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "获取签章URL")
    @RequestMapping(value = "/link", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> link(HttpServletRequest request, @RequestParam String signSignetLogId,
            @Valid @RequestBody SignatoryDTO signatoryDTO, BindingResult bdResult) {
        String busiDesr = "获取签章URL请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        BuzzResultVO<String> result = fileSignService.link(signSignetLogId, signatoryDTO);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "查询签章状态")
    @RequestMapping(value = "/signStatus", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<Integer> signStatus(HttpServletRequest request, @RequestParam String signSignetLogId,
            @Valid @RequestBody SignatoryDTO signatoryDTO, BindingResult bdResult) {
        String busiDesr = "查询签章状态请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        BuzzResultVO<Integer> result = fileSignService.signStatus(signSignetLogId, signatoryDTO);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "查询签章完成之后的备案号")
    @RequestMapping(value = "/recordNo", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> getRecordNo(HttpServletRequest request, @RequestParam String signSignetLogId,
            @Valid @RequestBody SignatoryDTO signatoryDTO, BindingResult bdResult) {
        String busiDesr = "查询签章完成之后的备案号请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        BuzzResultVO<String> result = fileSignService.getRecordNo(signSignetLogId, signatoryDTO);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }

    @ApiOperation(value = "上传机构认证信息")
    @RequestMapping(value = "/organizationCreate", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultVO<String> organizationCreate(HttpServletRequest request,
            @Valid @RequestBody SignCreateOrganizationLog organizationLog, BindingResult bdResult) {
        String busiDesr = "上传机构认证信息请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        BuzzResultVO<String> result = fileSignService.organizationCreate(organizationLog);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }


    @ApiOperation(value = "查询上传机构认证信息状态")
    @RequestMapping(value = "/organizationStatus", method = {RequestMethod.GET})
    @ResponseBody
    public ApiResultVO<Integer> getOrganizationStatus(HttpServletRequest request, @RequestParam
            String signCreateOrganizationLogId) {
        String busiDesr = "查询上传机构认证信息状态请求";
        logger.info("开始业务[{}]-参数:{}", RequestUtil.getParamMap(request));

        BuzzResultVO<Integer> result = fileSignService.getOrganizationStatus(signCreateOrganizationLogId);

        if (!result.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(result.getMessage()), result.getAttach());
        }

        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(result.getAttach());
    }
}
