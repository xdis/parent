package com.zyxy.service.micro.third.client.ebaoquan;

import com.zyxy.common.util.JsonUtil;
import com.zyxy.service.micro.third.config.EBaoQuanConfig;
import org.mapu.themis.ThemisClient;
import org.mapu.themis.api.common.PersonalIdentifer;
import org.mapu.themis.api.common.PreservationType;
import org.mapu.themis.api.request.contract.ContractFileDownloadUrlRequest;
import org.mapu.themis.api.request.contract.ContractFilePreservationCreateRequest;
import org.mapu.themis.api.response.contract.ContractFileDownloadUrlResponse;
import org.mapu.themis.api.response.preservation.PreservationCreateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rop.request.UploadFile;

import javax.annotation.PostConstruct;

@Component
public class HeTongBaoClient {
    private final static Logger logger = LoggerFactory.getLogger(HeTongBaoClient.class);

    private ThemisClient themisClient;

    @Autowired
    private EBaoQuanConfig eBaoQuanConfig;

    @PostConstruct
    public void init() {
        themisClient = new ThemisClient(eBaoQuanConfig.getHeTongBao().getServicesUrl(),
                eBaoQuanConfig.getHeTongBao().getAppKey(), eBaoQuanConfig.getHeTongBao()
                .getAppSecret());
    }

    /**
     * 调用易保全合同宝接口，对法律文书进行签章
     */
    public String signature(String contractNumber, String identifer, String realName
            , String preservationTitle, String sourceRegistryId, String userEmail, String mobilePhone
            , String fileName, byte[] fileBytes) {
        ContractFilePreservationCreateRequest.Builder builder = new ContractFilePreservationCreateRequest.Builder();

        //保全标题
        builder.withPreservationTitle(preservationTitle);
        //保全类型，默认即可
        builder.withPreservationType(PreservationType.DIGITAL_EVIDENCE);
        //测试是请修改为自己的姓名和身份证号
        builder.withIdentifer(new PersonalIdentifer(identifer, realName));
        //平台来源ID
        builder.withSourceRegistryId(sourceRegistryId);
        //合同编号
        builder.withContractNumber(contractNumber);
        //测试时请修改为自己的手机号码
        builder.withMobilePhone(mobilePhone);
        //测试是请修改为自己的邮箱
        builder.withUserEmail(userEmail);
        //备注
        builder.withComments("备注信息");
        //是否启用保全签章，只有PDF才能设置保全章
        //由于这个接口只需要对文件做保全，不需要盖章，所以直接设置为false
        builder.withIsNeedSign(false);

        ContractFilePreservationCreateRequest cfcr = builder.build();
        cfcr.setFile(new UploadFile(fileName, fileBytes));

        PreservationCreateResponse response = themisClient.createPreservation(cfcr);
        if (response.isSuccess()) {
            return String.valueOf(response.getPreservationId());
        } else {
            logger.error("request heTongBao createPreservation API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }

    public String getDownloadUrl(long preservationId){
        ContractFileDownloadUrlRequest request = new ContractFileDownloadUrlRequest();
        request.setPreservationId(preservationId);
        ContractFileDownloadUrlResponse response = themisClient.getContactFileDownloadUrl(request);
        if (response.isSuccess()) {
            return response.getDownUrl();
        } else {
            logger.error("request heTongBao getContactFileDownloadUrl API failure, [{}]", JsonUtil.toJson(response));
            return null;
        }
    }
}
