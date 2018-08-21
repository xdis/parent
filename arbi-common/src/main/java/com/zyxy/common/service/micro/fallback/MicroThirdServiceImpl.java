package com.zyxy.common.service.micro.fallback;

import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.domain.SignCreateOrganizationLog;
import com.zyxy.common.dto.BankFourElementDTO;
import com.zyxy.common.dto.FaceIdDTO;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.dto.SignatureDTO;
import com.zyxy.common.dto.SignetDTO;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.FaceIdGetTokenVO;
import com.zyxy.common.vo.PayItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MicroThirdServiceImpl implements MicroThirdService {

    @Override
    public ApiResultVO<List<PayItemVO>> getPayItems(Integer usages) {
        return new ApiResultVO<List<PayItemVO>>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用获取收费项目信息失败");
    }

    @Override
    public ApiResultVO<String> genPayNote(PayInfoDTO info) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用缴费服务失败");
    }

    @Override
    public ApiResultVO<String> getPayNoteQrCode(String id) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用获取缴费通知书二维码服务失败");
    }

    @Override
    public ApiResultVO<String> verifyBankFourElement(BankFourElementDTO elemInfo) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用银行卡四要素验证服务失败");
    }

    @Override
    public ApiResultVO<PayOrder> queryOrder(String id) {
        return new ApiResultVO<PayOrder>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用缴费查询服务失败");
    }

    @Override
    public ApiResultVO<String> cancleOrder(String id) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用取消支付订单服务失败");
    }

    @Override
    public ApiResultVO<FaceIdGetTokenVO> getFaceToken(FaceIdDTO formData) {
        return new ApiResultVO<FaceIdGetTokenVO>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用获取FaceToken服务失败");
    }

    @Override
    public ApiResultVO<String> signature(SignatureDTO signatureDTO) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用文件签名服务失败");
    }

    @Override
    public ApiResultVO<String> getSignatureDownloadUrl(String signSignatureLogId) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用获取文件签名完成的文件下载URL服务失败");
    }

    @Override
    public ApiResultVO<String> signet(SignetDTO signetDTO) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用文件签章服务失败");
    }

    @Override
    public ApiResultVO<Boolean> signNotify(String signSignetLogId, SignatureDTO signatureDTO) {
        return new ApiResultVO<Boolean>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用给特定签章人员发送签章短信服务失败");
    }

    @Override
    public ApiResultVO<String> fileLink(String signSignetLogId) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用获取签章完成的文件下载URL服务失败");
    }

    @Override
    public ApiResultVO<String> link(String signSignetLogId, SignatureDTO signatureDTO) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用获取签章URL服务失败");
    }

    @Override
    public ApiResultVO<Integer> signStatus(String signSignetLogId, SignatureDTO signatureDTO) {
        return new ApiResultVO<Integer>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用查询签章状态服务失败");
    }

    @Override
    public ApiResultVO<Integer> getRecordNo(String signSignetLogId, SignatureDTO signatureDTO) {
        return new ApiResultVO<Integer>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用查询签章完成之后的备案号服务失败");
    }

    @Override
    public ApiResultVO<String> organizationCreate(SignCreateOrganizationLog organizationLog) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用上传机构认证信息服务失败");
    }

    @Override
    public ApiResultVO<String> getOrganizationStatus(String signCreateOrganizationLogId) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("调用查询上传机构认证信息状态服务失败");
    }
}
