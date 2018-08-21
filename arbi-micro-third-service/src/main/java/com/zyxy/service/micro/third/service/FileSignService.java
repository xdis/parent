package com.zyxy.service.micro.third.service;

import com.junziqian.api.common.DealType;
import com.junziqian.api.common.SignLevel;
import com.junziqian.api.response.OrganizationCreateResponse;
import com.zyxy.common.domain.SignCreateOrganizationLog;
import com.zyxy.common.domain.SignSignatureLog;
import com.zyxy.common.domain.SignSignetLog;
import com.zyxy.common.domain.SignSignetLogWithBLOBs;
import com.zyxy.common.domain.SysFile;
import com.zyxy.common.dto.SignatoryDTO;
import com.zyxy.common.enums.SignCreateOrganizationLogStatusEnum;
import com.zyxy.common.enums.SignSignatureLogStatusEnum;
import com.zyxy.common.enums.SignSignetLogStatusEnum;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.third.client.ebaoquan.HeTongBaoClient;
import com.zyxy.service.micro.third.client.ebaoquan.JunZiQianClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ligantang
 */
@Service
public class FileSignService {
    private final static Logger logger = LoggerFactory.getLogger(FileSignService.class);
    /**
     * 不显示保全签章
     */
    private static final int NO_EBQ_SIGN = 1;
    /**
     * 使用云证书（CA证书）
     */
    private static final int SERVER_CA = 1;
    @Autowired
    private HeTongBaoClient heTongBaoClient;

    @Autowired
    private JunZiQianClient junZiQianClient;

    @Autowired
    private MicroFileService microFileService;

    @Autowired
    private SignSignetLogService signSignetLogService;

    @Autowired
    private SignSignatureLogService signSignatureLogService;

    @Autowired
    private SignCreateOrganizationLogService signCreateOrganizationLogService;

    @Autowired
    private SequenceService sequenceService;

    /**
     * 文件签名
     *
     * @param fileId            证据、附件文件ID
     * @param signatoryDTO      签名用户信息
     * @param preservationTitle 签名文件标题
     * @param sourceRegistryId  平台来源ID
     * @return 保全ID（由于易保全那边签名接口叫做保全，所以返回的是保全ID）
     */
    public BuzzResultVO<String> signature(String fileId, SignatoryDTO signatoryDTO
            , String preservationTitle, String sourceRegistryId) {
        ApiResultVO<SysFile> sysFileApiResultVO = microFileService.getFileInfoById(fileId);
        SysFile sysFile = sysFileApiResultVO.getBody();

        BuzzResultVO<String> resultVO = new BuzzResultVO<>();
        if (sysFile == null) {
            logger.error("cannot find file in microFileService, fileId:{}", fileId);
            return resultVO.setOk(false).setMessage("在文件表中找不到对应数据");
        }

        //获取证据、附件文件内容字节码
        byte[] fileBytes = null;
        ResponseEntity<byte[]> responseEntity = microFileService.downloadFile(fileId);
        if (responseEntity != null) {
            fileBytes = responseEntity.getBody();
        }
        if (fileBytes == null || fileBytes.length <= 0) {
            logger.error("get empty file from microFileService, fileId:{}", fileId);
            return resultVO.setOk(false).setMessage("通过文件服务找到的文件内容为空");
        }

        SignSignatureLog signSignatureLog = new SignSignatureLog();
        String signSignatureLogId = sequenceService.getCommonID();
        signSignatureLog.setId(signSignatureLogId);
        signSignatureLog.setFileId(fileId);
        String signatory = JsonUtil.toJson(signatoryDTO);
        signSignatureLog.setSignatory(signatory);
        signSignatureLog.setSourceRegistryId(sourceRegistryId);
        signSignatureLog.setStatus(SignSignatureLogStatusEnum.INIT.getValue());
        signSignatureLog.setCreateTime(new Date());

        int result = signSignatureLogService.save(signSignatureLog);
        if (result <= 0) {
            logger.error("save sign_signature_log failure, signSignatureLogId:{}, fileId:{}, signatory:{}",
                    signSignatureLogId, fileId, signatory);
            return resultVO.setOk(false).setMessage("保存签名记录失败");
        }

        String fileName = sysFile.getFileOrignName();
        String preservationId = heTongBaoClient.signature(fileId, signatoryDTO.getIdentityCard(),
                signatoryDTO.getFullName(),
                preservationTitle, sourceRegistryId,
                signatoryDTO.getEmail(), signatoryDTO.getMobile(), fileName, fileBytes);

        //修改签章记录表状态
        SignSignatureLog updateSignatureLog = new SignSignatureLog();
        updateSignatureLog.setId(signSignatureLogId);
        updateSignatureLog.setPreservationId(preservationId);
        updateSignatureLog.setRecordNo("00" + preservationId);
        updateSignatureLog.setUpdateTime(new Date());
        updateSignatureLog.setStatus(StringUtil.isNotEmpty(
                preservationId) ? SignSignatureLogStatusEnum.SUCCESS.getValue() : SignSignatureLogStatusEnum.FAILURE.getValue());
        result = signSignatureLogService.updateByPrimaryKeySelective(updateSignatureLog);
        if (result <= 0) {
            logger.error("update sign_signature_log failure, signSignatureLogId:{}, preservationId:{}",
                    signSignatureLogId,
                    preservationId);
            return resultVO.setOk(false).setMessage("保存签章记录失败").setAttach(signSignatureLogId);
        }

        return resultVO.setOk(true).setAttach(signSignatureLogId);
    }

    /**
     * 获取文件签名完成的文件下载URL
     *
     * @param signSignatureLogId 签名记录表ID
     * @return 文件签名完成文件下载URL
     */
    public BuzzResultVO<String> getSignatureDownloadUrl(String signSignatureLogId) {
        BuzzResultVO<String> resultVO = new BuzzResultVO<>();
        SignSignatureLog signSignatureLog = signSignatureLogService.getById(signSignatureLogId);
        if (signSignatureLog == null) {
            logger.error("can not find signSignatureLog, signSignatureLogId:{}", signSignatureLogId);
            return resultVO.setOk(false).setMessage("can not find signSignetLog");
        }
        String preservationId = signSignatureLog.getPreservationId();
        String downloadUrl = heTongBaoClient.getDownloadUrl(Long.parseLong(preservationId));
        logger.info("get heTongBaoClient download url, preservationId:{}, downloadUrl:{}", preservationId, downloadUrl);
        return resultVO.setOk(true).setAttach(downloadUrl);
    }

    /**
     * PDF文件签章
     *
     * @param docFileId        文书PDF文件ID
     * @param metFileIdList    附件文件ID集合
     * @param contractName     合同名称（在君子签后台显示）
     * @param signatoryDTOList 签章人信息集合
     * @param signLevelCode    签章等级 0: 标准图形章,1: 公章或手写
     * @param dealTypeCode     签章类型 0：手动签章,1自动签章
     * @return 签章编号
     */
    public BuzzResultVO<String> signet(String docFileId, List<String> metFileIdList, String contractName,
            List<SignatoryDTO> signatoryDTOList, int signLevelCode, int dealTypeCode) {
        BuzzResultVO<String> resultVO = new BuzzResultVO<>();

        //获取文件表数据
        ApiResultVO<SysFile> sysFileApiResultVO = microFileService.getFileInfoById(docFileId);
        SysFile sysFile = sysFileApiResultVO.getBody();
        if (sysFile == null) {
            logger.error("cannot find file in microFileService, docFileId:{}", docFileId);
            return resultVO.setOk(false).setMessage("在文件表中找不到对应数据");
        }

        //获取文书PDF文件内容字节码
        byte[] docFileBytes = null;
        ResponseEntity<byte[]> docFileRespEnty = microFileService.downloadFile(docFileId);
        if (docFileRespEnty != null) {
            docFileBytes = docFileRespEnty.getBody();
        }
        if (docFileBytes == null || docFileBytes.length <= 0) {
            logger.error("get empty file from microFileService, docFileId:{}", docFileId);
            return resultVO.setOk(false).setMessage("通过文件服务找到的文书文件内容为空");
        }
        DealType dealType = DealType.fromCode(dealTypeCode);

        SignSignetLogWithBLOBs signSignetLog = new SignSignetLogWithBLOBs();
        String signSignetLogId = sequenceService.getCommonID();
        signSignetLog.setId(signSignetLogId);
        signSignetLog.setDocFileId(docFileId);
        signSignetLog.setContractName(contractName);
        String signatoryList = JsonUtil.toJson(signatoryDTOList);
        signSignetLog.setSignatoryList(signatoryList);
        signSignetLog.setSignLevelCode(String.valueOf(signLevelCode));
        signSignetLog.setDealTypeCode(String.valueOf(dealTypeCode));
        signSignetLog.setStatus(SignSignetLogStatusEnum.INIT.getValue());
        signSignetLog.setCreateTime(new Date());

        String fileName = sysFile.getFileOrignName();
        //保存签章记录到数据库
        int result = signSignetLogService.save(signSignetLog);
        if (result <= 0) {
            logger.error("save sign_signet_log failure, signSignetLogId:{}, docFileId:{}, signatoryList:{}",
                    signSignetLogId, docFileId, signatoryList);
            return resultVO.setOk(false).setMessage("保存签章记录失败");
        }
        //调用接口发起签章
        String applyNo = junZiQianClient.signet(contractName, fileName, docFileBytes, signatoryDTOList,
                SignLevel.fromCode(signLevelCode), SERVER_CA, dealType,
                NO_EBQ_SIGN);

        //修改签章记录表状态
        SignSignetLogWithBLOBs updateSignetLog = new SignSignetLogWithBLOBs();
        updateSignetLog.setId(signSignetLogId);
        updateSignetLog.setApplyNo(applyNo);
        updateSignetLog.setUpdateTime(new Date());
        updateSignetLog.setStatus(StringUtil.isNotEmpty(
                applyNo) ? SignSignetLogStatusEnum.NOT_SIGN.getValue() : SignSignetLogStatusEnum.FAILURE.getValue());
        result = signSignetLogService.updateByPrimaryKeySelective(updateSignetLog);
        if (result <= 0) {
            logger.error("update sign_signet_log failure, signSignetLogId:{}, applyNo:{}", signSignetLogId,
                    applyNo);
            return resultVO.setOk(false).setMessage("保存签章记录失败").setAttach(signSignetLogId);
        }

        return resultVO.setOk(true).setAttach(signSignetLogId);
    }

    /**
     * 给特定签章人员发送签章短信
     *
     * @param signSignetLogId 签章记录表ID
     * @param signatoryDTO    签章人信息
     * @return 签章URL
     */
    public BuzzResultVO<Boolean> signNotify(String signSignetLogId, SignatoryDTO signatoryDTO) {
        BuzzResultVO<Boolean> resultVO = new BuzzResultVO<>();
        SignSignetLog signSignetLog = signSignetLogService.getById(signSignetLogId);
        if (signSignetLog == null) {
            logger.error("can not find signSignetLog, signSignetLogId:{}", signSignetLogId);
            return resultVO.setOk(false).setMessage("can not find signSignetLog");
        }
        String applyNo = signSignetLog.getApplyNo();
        boolean result = junZiQianClient.signNotify(applyNo, signatoryDTO);
        logger.info("request junZiQian sign notify, applyNo:{}, signatoryDTO:{}, result:{}", applyNo, signatoryDTO,
                result);
        return resultVO.setOk(true).setAttach(result);
    }

    /**
     * 获取签章完成的文件下载URL
     *
     * @param signSignetLogId 签章记录表ID
     * @return 签章完成文件下载URL
     */
    public BuzzResultVO<String> fileLink(String signSignetLogId) {
        BuzzResultVO<String> resultVO = new BuzzResultVO<>();
        SignSignetLog signSignetLog = signSignetLogService.getById(signSignetLogId);
        if (signSignetLog == null) {
            logger.error("can not find signSignetLog, signSignetLogId:{}", signSignetLogId);
            return resultVO.setOk(false).setMessage("can not find signSignetLog");
        }
        String applyNo = signSignetLog.getApplyNo();
        String fileLink = junZiQianClient.fileLink(applyNo);
        if (fileLink == null) {
            logger.error("get fileLink failure from junZiQian, applyNo:{}", applyNo);
            return resultVO.setOk(false).setMessage("get fileLink failure from junZiQian");
        }
        logger.info("get junZiQian download url, applyNo:{}, fileLink:{}", applyNo, fileLink);
        return resultVO.setOk(true).setAttach(fileLink);
    }

    /**
     * 获取签章URL
     *
     * @param signSignetLogId 签章记录表ID
     * @param signatoryDTO    签章人信息
     * @return 签章URL
     */
    public BuzzResultVO<String> link(String signSignetLogId, SignatoryDTO signatoryDTO) {
        BuzzResultVO<String> resultVO = new BuzzResultVO<>();
        SignSignetLog signSignetLog = signSignetLogService.getById(signSignetLogId);
        if (signSignetLog == null) {
            logger.error("can not find signSignetLog, signSignetLogId:{}", signSignetLogId);
            return resultVO.setOk(false).setMessage("can not find signSignetLog");
        }
        String applyNo = signSignetLog.getApplyNo();
        String link = junZiQianClient.link(applyNo, signatoryDTO);
        if (link == null) {
            logger.error("get link failure from junZiQian, applyNo:{}", applyNo);
            return resultVO.setOk(false).setMessage("get link failure from junZiQian");
        }

        logger.info("get junZiQian signet url, applyNo:{}, link:{}", applyNo, link);
        return resultVO.setOk(true).setAttach(link);
    }

    /**
     * 查询签章状态
     *
     * @param signSignetLogId 签章记录表ID
     * @param signatoryDTO    签章人信息
     * @return -1 签章未初始化完成、0 未签、1 已签、2 拒签、3 保全
     */
    public BuzzResultVO<Integer> signStatus(String signSignetLogId, SignatoryDTO signatoryDTO) {
        BuzzResultVO<Integer> resultVO = new BuzzResultVO<>();
        SignSignetLog signSignetLog = signSignetLogService.getById(signSignetLogId);
        if (signSignetLog == null) {
            logger.error("can not find signSignetLog, signSignetLogId:{}", signSignetLogId);
            return resultVO.setOk(false).setMessage("can not find signSignetLog");
        }
        String applyNo = signSignetLog.getApplyNo();
        Integer signStatus = junZiQianClient.signStatus(applyNo, signatoryDTO);
        if (signStatus == null) {
            logger.error("get signStatus failure from junZiQian, applyNo:{}", applyNo);
            return resultVO.setOk(false).setMessage("get signStatus failure from junZiQian");
        }

        int result = signSignetLogService.updateSignSignetStatus(applyNo, signStatus);
        if (result <= 0) {
            logger.error("update sign_signet_log status failure, applyNo:{}, signStatus:{}", applyNo,
                    signStatus);
        }
        return resultVO.setOk(true).setAttach(signStatus);
    }

    /**
     * 查询签章完成之后的备案号
     *
     * @param signSignetLogId 签章记录表ID
     * @param signatoryDTO    签章人信息
     * @return 备案号
     */
    public BuzzResultVO<String> getRecordNo(String signSignetLogId, SignatoryDTO signatoryDTO) {
        BuzzResultVO<String> resultVO = new BuzzResultVO<>();
        SignSignetLog signSignetLog = signSignetLogService.getById(signSignetLogId);
        if (signSignetLog == null) {
            logger.error("can not find signSignetLog, signSignetLogId:{}", signSignetLogId);
            return resultVO.setOk(false).setMessage("can not find signSignetLog");
        }
        String applyNo = signSignetLog.getApplyNo();
        String recordNo = junZiQianClient.getRecordNo(applyNo, signatoryDTO);
        if (recordNo == null) {
            logger.error("get recordNo failure from junZiQian, applyNo:{}", applyNo);
            return resultVO.setOk(false).setMessage("get recordNo failure from junZiQian");
        }

        int result = signSignetLogService.updateRecordNo(applyNo, recordNo);
        if (result <= 0) {
            logger.error("update sign_signet_log recordNo failure, applyNo:{}, recordNo:{}", applyNo,
                    recordNo);
        }
        return resultVO.setOk(true).setAttach(recordNo);
    }

    /**
     * 上传机构认证信息
     *
     * @param signCreateOrganizationLog 机构认证信息
     * @return 上传机构认证信息记录表id
     */
    public BuzzResultVO<String> organizationCreate(SignCreateOrganizationLog signCreateOrganizationLog) {
        BuzzResultVO<String> resultVO = new BuzzResultVO<>();

        //保存上传机构认证信息记录
        String id = sequenceService.getCommonID();
        signCreateOrganizationLog.setId(id);
        signCreateOrganizationLog.setStatus(SignCreateOrganizationLogStatusEnum.INIT.getValue());
        signCreateOrganizationLog.setCreateTime(new Date());
        int result = signCreateOrganizationLogService.save(signCreateOrganizationLog);
        if (result <= 0) {
            logger.error("save signCreateOrganizationLog failure, organizationLog:[{}]",
                    JsonUtil.toJson(signCreateOrganizationLog));
            return resultVO.setOk(false).setMessage("在文件表中找不到对应数据");
        }

        String organizationRegImg = signCreateOrganizationLog.getOrganizationRegImg();
        ApiResultVO<SysFile> organizationRegImgFileVo = microFileService.getFileInfoById(organizationRegImg);
        SysFile organizationRegImgSysFile = organizationRegImgFileVo.getBody();
        if (organizationRegImgSysFile == null) {
            signCreateOrganizationLogService.updateStatus(id, SignCreateOrganizationLogStatusEnum.FAILURE.getValue(),
                    "cannot find organizationRegImgFile in microFileService");
            logger.error("cannot find organizationRegImgFile in microFileService, organizationRegImg:{}",
                    organizationRegImg);
            return resultVO.setOk(false).setMessage("在文件表中找不到对应数据");
        }
        byte[] organizationRegImgFileBytes = null;
        ResponseEntity<byte[]> responseEntity = microFileService.downloadFile(organizationRegImg);
        if (responseEntity != null) {
            organizationRegImgFileBytes = responseEntity.getBody();
        }
        if (organizationRegImgFileBytes == null || organizationRegImgFileBytes.length <= 0) {
            signCreateOrganizationLogService.updateStatus(id, SignCreateOrganizationLogStatusEnum.FAILURE.getValue(),
                    "get empty organizationRegImgFile from microFileService");
            logger.error("get empty organizationRegImgFile from microFileService, organizationRegImg:{}",
                    organizationRegImg);
            return resultVO.setOk(false).setMessage("通过文件服务找到的文件内容为空");
        }

        String signApplication = signCreateOrganizationLog.getSignApplication();
        ApiResultVO<SysFile> signApplicationFileVo = microFileService.getFileInfoById(signApplication);
        SysFile signApplicationSysFile = signApplicationFileVo.getBody();
        if (signApplicationSysFile == null) {
            signCreateOrganizationLogService.updateStatus(id, SignCreateOrganizationLogStatusEnum.FAILURE.getValue(),
                    "cannot find signApplicationFile in microFileService");
            logger.error("cannot find signApplicationFile in microFileService, signApplication:{}",
                    signApplication);
            return resultVO.setOk(false).setMessage("在文件表中找不到对应数据");
        }
        byte[] signApplicationFileBytes = null;
        ResponseEntity<byte[]> signApplicationRespEntity = microFileService.downloadFile(signApplication);
        if (signApplicationRespEntity != null) {
            signApplicationFileBytes = signApplicationRespEntity.getBody();
        }
        if (signApplicationFileBytes == null || signApplicationFileBytes.length <= 0) {
            signCreateOrganizationLogService.updateStatus(id, SignCreateOrganizationLogStatusEnum.FAILURE.getValue(),
                    "get empty signApplicationFile from microFileService");
            logger.error("get empty signApplicationFile from microFileService, signApplication:{}",
                    signApplication);
            return resultVO.setOk(false).setMessage("通过文件服务找到的文件内容为空");
        }

        OrganizationCreateResponse organizationCreateResponse = junZiQianClient.organizationCreate(
                signCreateOrganizationLog.getEmail(), signCreateOrganizationLog.getName(),
                signCreateOrganizationLog.getOrganizationType(), signCreateOrganizationLog.getOrganizationRegNo(),
                organizationRegImgSysFile.getFileOrignName(), organizationRegImgFileBytes,
                signApplicationSysFile.getFileOrignName(), signApplicationFileBytes);

        //接口请求失败
        if (!organizationCreateResponse.isSuccess()) {
            signCreateOrganizationLogService.updateStatus(id, SignCreateOrganizationLogStatusEnum.FAILURE.getValue(),
                    JsonUtil.toJson(organizationCreateResponse));
            return resultVO.setOk(true).setAttach(id);
        } else {
            return resultVO.setOk(true).setAttach(id);
        }
    }

    /**
     * 查询上传机构认证信息状态
     *
     * @param signCreateOrganizationLogId 上传机构认证信息表Id
     * @return -1：未申请;0：未审核;1：通过审核;2： 未通过
     */
    public BuzzResultVO<Integer> getOrganizationStatus(String signCreateOrganizationLogId) {
        BuzzResultVO<Integer> resultVO = new BuzzResultVO<>();
        SignCreateOrganizationLog signCreateOrganizationLog = signCreateOrganizationLogService.getById(
                signCreateOrganizationLogId);
        if (signCreateOrganizationLog == null) {
            logger.error("can not find signCreateOrganizationLog, signCreateOrganizationLogId:{}",
                    signCreateOrganizationLogId);
            return resultVO.setOk(false).setMessage("can not find signCreateOrganizationLog");
        }
        Integer organizationStatus = junZiQianClient.organizationStatus(signCreateOrganizationLog.getEmail());
        if (organizationStatus == null) {
            logger.error("get organizationStatus failure from junZiQian, email:{}",
                    signCreateOrganizationLog.getEmail());
            return resultVO.setOk(false).setMessage("get organizationStatus failure from junZiQian");
        }
        signCreateOrganizationLogService.updateStatus(signCreateOrganizationLogId, organizationStatus);
        return resultVO.setOk(true).setAttach(organizationStatus);
    }

}
