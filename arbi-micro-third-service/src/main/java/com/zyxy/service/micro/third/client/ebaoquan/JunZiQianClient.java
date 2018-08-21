package com.zyxy.service.micro.third.client.ebaoquan;

import com.junziqian.api.JunziqianClient;
import com.junziqian.api.bean.Signatory;
import com.junziqian.api.common.Constants;
import com.junziqian.api.common.DealType;
import com.junziqian.api.common.IdentityType;
import com.junziqian.api.common.SignLevel;
import com.junziqian.api.request.ApplySignFileRequest;
import com.junziqian.api.request.FileLinkRequest;
import com.junziqian.api.request.OrganizationAuditStatusRequest;
import com.junziqian.api.request.PresIdRequest;
import com.junziqian.api.request.SignLinkRequest;
import com.junziqian.api.request.SignNotifyRequest;
import com.junziqian.api.request.SignStatusRequest;
import com.junziqian.api.request.builder.OrganizationCreateBuilder;
import com.junziqian.api.response.ApplySignResponse;
import com.junziqian.api.response.OrganizationAuditStatusResponse;
import com.junziqian.api.response.OrganizationCreateResponse;
import com.junziqian.api.response.PresIdResponse;
import com.junziqian.api.response.SignLinkResponse;
import com.junziqian.api.response.SignStatusResponse;
import com.zyxy.common.dto.SignatoryDTO;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.service.micro.third.config.EBaoQuanConfig;
import org.ebaoquan.rop.request.UploadFile;
import org.ebaoquan.rop.response.RopResponse;
import org.ebaoquan.rop.thirdparty.com.alibaba.fastjson.JSONArray;
import org.ebaoquan.rop.thirdparty.com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;

@Component
public class JunZiQianClient {
    private final static Logger logger = LoggerFactory.getLogger(HeTongBaoClient.class);

    private JunziqianClient junziqianClient;

    @Autowired
    private EBaoQuanConfig eBaoQuanConfig;

    @PostConstruct
    public void init() {
        junziqianClient = new JunziqianClient(eBaoQuanConfig.getJunZiQian().getServicesUrl(),
                eBaoQuanConfig.getJunZiQian().getAppKey(),
                eBaoQuanConfig.getJunZiQian().getAppSecret());
    }

    /**
     * 调用易保全君子签接口，对法律文书进行签章
     *
     * @param contractName     合同名称（在君子签后台显示）
     * @param fileName         文件名称
     * @param fileBytes        文件字节数组
     * @param signatoryDTOList 签章人集合
     * @param signLevel        签字类型 0 为标准图形章，1 为公章或手写
     * @param serverCa         使用CA证书，0 不使用，1 使用
     * @param dealType         签章类型 0：手动签章,1自动签章
     * @param noEbqSign        保全签章显示 0,显示保全章；1 不显示保全章
     * @return 签章编号
     */
    public String signet(String contractName, String fileName, byte[] fileBytes
            , List<SignatoryDTO> signatoryDTOList, SignLevel signLevel, int serverCa
            , DealType dealType, int noEbqSign) {
        return this.signet(contractName, fileName, fileBytes, signatoryDTOList, signLevel, serverCa, dealType,
                noEbqSign,
                null);
    }

    /**
     * 调用易保全君子签接口，对法律文书进行签章，并对附件进行签名保全
     *
     * @param contractName       合同名称（在君子签后台显示）
     * @param fileName           文件名称
     * @param fileBytes          文件字节数组
     * @param signatoryDTOList   签章人集合
     * @param signLevel          签字类型 0 为标准图形章，1 为公章或手写
     * @param serverCa           使用CA证书，0 不使用，1 使用
     * @param dealType           签章类型 0：手动签章,1自动签章
     * @param noEbqSign          保全签章显示 0,显示保全章；1 不显示保全章
     * @param attachFileBytesArr 附件字节数组集合
     * @return 签章编号
     */
    public String signet(String contractName, String fileName, byte[] fileBytes
            , List<SignatoryDTO> signatoryDTOList, SignLevel signLevel, int serverCa
            , DealType dealType, int noEbqSign, List<byte[]> attachFileBytesArr) {

        HashSet<Signatory> signatorySet = new HashSet<>();
        for (SignatoryDTO signatoryDTO : signatoryDTOList) {
            Signatory signatory = new Signatory();
            //姓名或公司名称
            signatory.setFullName(signatoryDTO.getFullName());
            //证件类型
            signatory.setSignatoryIdentityType(IdentityType.fromCode(signatoryDTO.getIdentityTypeCode()));
            //证件号码
            signatory.setIdentityCard(signatoryDTO.getIdentityCard());
            //签章人手机号
            signatory.setMobile(signatoryDTO.getMobile());
            //签章人邮箱
            signatory.setEmail(signatoryDTO.getEmail());
            //是否验证签章人手机或邮箱，0:验证短信（邮箱）验证码，1:不验证短信（邮箱）验证码
            signatory.setNoNeedVerify(signatoryDTO.getNoNeedVerify());
            //签章位置
            List<SignatoryDTO.SignPageDTO> chapteJsonList = signatoryDTO.getChapteJson();
            JSONArray chapteJson = new JSONArray();
            for (SignatoryDTO.SignPageDTO signPageDTO : chapteJsonList) {
                JSONObject pageJson = new JSONObject();
                pageJson.put("page", signPageDTO.getPage());

                List<SignatoryDTO.SignChapteDTO> chaptesList = signPageDTO.getChaptes();
                JSONArray chaptes = new JSONArray();
                for (SignatoryDTO.SignChapteDTO signChapteDTO : chaptesList) {
                    JSONObject chapte = new JSONObject();
                    chapte.put("offsetX", signChapteDTO.getOffsetX());
                    chapte.put("offsetY", signChapteDTO.getOffsetY());
                    chaptes.add(chapte);
                }

                pageJson.put("chaptes", chaptes);
                chapteJson.add(pageJson);
            }

            /* 签章在文件中页面上的位置坐标（文件页左上角(0.0,0.0)为基准，按百分比进行设置）
             * 签章可以在不同页面上设置，也能一页上设置多个，所以数据格式如下：
             * [{"page":0,","chaptes":[{"offsetX":0.12,"offsetY":0.23}]},{"page":1,"chaptes":[{"offsetX":0.45,"offsetY":0.67}]}]
             * page：页数从0开始计算，设置为负数就是从最后一页开始算，-1为最后一页
             * chaptes：坐标列表，如果设置多个，就会在当前页上有多个签章
             * offsetX:横坐标比例，设置为 0-1 之间
             * offsetY:纵坐标比例，设置为 0-1 之间
             */
            signatory.withChapteJson(chapteJson);
            signatorySet.add(signatory);
        }
        ApplySignFileRequest.Builder builder = new ApplySignFileRequest.Builder();

        // 合同名称，必填
        builder.withContractName(contractName);
        //签章文件
        builder.withFile(fileName, fileBytes);
        //使用CA证书，0 不使用，1 使用
        builder.withServerCa(serverCa);
        //签章类型 0：手动签章,1自动签章
        builder.withDealType(dealType);
        //0,显示保全章；1 不显示保全章
        builder.withNoEbqSign(noEbqSign);
        // 添加签章人
        builder.withSignatories(signatorySet);
        // 签字类型 0 为标准图形章，1 为公章或手写
        builder.withSignLevel(signLevel.getCode());

        //易保全接口中只提供上传三个附件的上传，平台暂时不用这个进行证据签名
        ApplySignResponse response = junziqianClient.applySignFile(builder.build());
        if (response.isSuccess()) {
            return response.getApplyNo();
        } else {
            logger.error("request junziqian applySignFile API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }

    /**
     * 给特定签章人员发送签章短信
     *
     * @param applyNo      签章编号
     * @param signatoryDTO 签章人信息
     * @return 签章URL
     */
    public boolean signNotify(String applyNo, SignatoryDTO signatoryDTO) {
        SignNotifyRequest request = new SignNotifyRequest();
        request.setApplyNo(applyNo);
        request.setSignNotifyType(SignNotifyRequest.NOTIFYTYPE_SIGN);
        Signatory signatory = new Signatory();
        signatory.setFullName(signatoryDTO.getFullName());
        signatory.setIdentityCard(signatoryDTO.getIdentityCard());
        signatory.setSignatoryIdentityType(IdentityType.fromCode(signatoryDTO.getIdentityTypeCode()));
        request.setSignatory(signatory);
        RopResponse response = junziqianClient.signNotify(request);
        boolean result = response.isSuccess();
        if (!result) {
            logger.error("request junziqian signNotify API failure, [{}]", JsonUtil.toJson(response));
        }
        return result;
    }

    /**
     * 获取签章完成的文件下载URL
     *
     * @param applyNo 签章编号
     * @return 签章完成文件下载URL
     */
    public String fileLink(String applyNo) {
        FileLinkRequest request = new FileLinkRequest();
        request.setApplyNo(applyNo);
        SignLinkResponse response = junziqianClient.fileLink(request);
        if (response.isSuccess()) {
            return response.getLink();
        } else {
            logger.error("request junziqian fileLink API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }

    /**
     * 获取签章URL
     *
     * @param applyNo      签章编号
     * @param signatoryDTO 签章人信息
     * @return 签章URL
     */
    public String link(String applyNo, SignatoryDTO signatoryDTO) {
        SignLinkRequest request = new SignLinkRequest();
        request.setApplyNo(applyNo);

        Signatory signatory = new Signatory();
        signatory.setFullName(signatoryDTO.getFullName());
        signatory.setIdentityCard(signatoryDTO.getIdentityCard());
        signatory.setSignatoryIdentityType(IdentityType.fromCode(signatoryDTO.getIdentityTypeCode()));
        request.setSignatory(signatory);

        SignLinkResponse response = junziqianClient.signLink(request);
        if (response.isSuccess()) {
            return response.getLink();
        } else {
            logger.error("request junziqian fileLink API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }

    /**
     * 查询签章状态
     *
     * @param applyNo      签章编号
     * @param signatoryDTO 签章人信息
     * @return -1 签章未初始化完成、0 未签、1 已签、2 拒签、3 保全
     */
    public Integer signStatus(String applyNo, SignatoryDTO signatoryDTO) {
        SignStatusRequest request = new SignStatusRequest();
        request.setApplyNo(applyNo);
        /*
         * Signatory 可填可不填
         * 填写时查询当前约签人的状态
         * 不填写时查询整个签章合同的签章状态
         * */
        if (signatoryDTO != null) {
            Signatory signatory = new Signatory();
            signatory.setFullName(signatoryDTO.getFullName());
            signatory.setIdentityCard(signatoryDTO.getIdentityCard());
            signatory.setSignatoryIdentityType(IdentityType.fromCode(signatoryDTO.getIdentityTypeCode()));
            request.setSignatory(signatory);
        }
        SignStatusResponse response = junziqianClient.signStatus(request);
        if (response.isSuccess()) {
            return response.getSignStatus();
        } else {
            logger.error("request junziqian fileLink API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }

    /**
     * 查询签章完成之后的备案号
     *
     * @param applyNo      签章编号
     * @param signatoryDTO 签章人信息
     * @return 备案号
     */
    public String getRecordNo(String applyNo, SignatoryDTO signatoryDTO) {
        PresIdRequest request = new PresIdRequest();
        request.setApplyNo(applyNo);

        Signatory signatory = new Signatory();
        signatory.setFullName(signatoryDTO.getFullName());
        signatory.setIdentityCard(signatoryDTO.getIdentityCard());
        signatory.setSignatoryIdentityType(IdentityType.fromCode(signatoryDTO.getIdentityTypeCode()));
        //证据包
        request.setDealType(1);
        request.setSignatory(signatory);

        PresIdResponse response = junziqianClient.presId(request);
        if (response.isSuccess()) {
            return response.getPresId();
        } else {
            logger.error("request junziqian presId API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }

    /**
     * @param email                      邮箱
     * @param name                       公司名称
     * @param organizationType           公司类型，0-企业，1-事业单位
     * @param organizationRegNo          统一社会信用代码
     * @param organizationRegImgFileName 彩色三证合一营业执照文件名
     * @param organizationRegImgFile     彩色三证合一营业执照文件内容字节数组
     * @param signApplicationFileName    君子签企业服务授权书扫描件文件名
     * @param signApplicationFile        君子签企业服务授权书扫描件文件内容字节数组
     * @return 签章结果
     */
    public OrganizationCreateResponse organizationCreate(String email, String name, int organizationType,
            String organizationRegNo, String organizationRegImgFileName, byte[] organizationRegImgFile,
            String signApplicationFileName, byte[] signApplicationFile) {
        OrganizationCreateBuilder builder = new OrganizationCreateBuilder();
        builder.withEmailOrMobile(email);
        builder.withName(name);
        //多证合一
        builder.withIdentificationType(Constants.IDENTIFICATION_TYPE_ALLINONE);
        builder.withOrganizationType(organizationType);
        builder.withOrganizationRegNo(organizationRegNo);
        builder.withOrganizationRegImg(new UploadFile(organizationRegImgFileName, organizationRegImgFile));
        builder.withSignApplication(new UploadFile(signApplicationFileName, signApplicationFile));
        OrganizationCreateResponse response = junziqianClient.organizationCreate(builder.build());
        if (response.isSuccess()) {
            return response;
        } else {
            logger.error("request junziqian organizationCreate API failure, [{}]", JsonUtil.toJson(response));
            return response;
        }
    }

    /**
     * 查询企业认证状态
     *
     * @param email 企业邮箱
     * @return -1：未申请;0：未审核;1：通过审核;2： 未通过
     */
    public Integer organizationStatus(String email) {
        OrganizationAuditStatusRequest request = new OrganizationAuditStatusRequest();
        request.setEmailOrMobile(email);
        OrganizationAuditStatusResponse response = junziqianClient.organizationStatus(request);
        if (response.isSuccess()) {
            return response.getStatus();
        } else {
            logger.error("request junziqian organizationStatus API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }
}
