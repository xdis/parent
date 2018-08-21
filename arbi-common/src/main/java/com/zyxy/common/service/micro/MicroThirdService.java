package com.zyxy.common.service.micro;

import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.domain.SignCreateOrganizationLog;
import com.zyxy.common.dto.BankFourElementDTO;
import com.zyxy.common.dto.FaceIdDTO;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.dto.SignatureDTO;
import com.zyxy.common.dto.SignetDTO;
import com.zyxy.common.service.micro.fallback.MicroThirdServiceImpl;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.FaceIdGetTokenVO;
import com.zyxy.common.vo.PayItemVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 三方服务
 *
 * @author tanquan
 */
@FeignClient(value = "thirdService", fallback = MicroThirdServiceImpl.class)
public interface MicroThirdService {


    /**
     * 支付服务-获取收费项目信息
     *
     * @param usages 用途：0-案件处理费，1-案件受理费，2-案件行为收费
     * @return
     */
    @RequestMapping(value = "/payment/getPayItems.json", method = RequestMethod.POST)
    ApiResultVO<List<PayItemVO>> getPayItems(@RequestParam("usages") Integer usages);

    /**
     * 支付服务-生成缴费通知书
     *
     * @param info
     * @return 成功则返回支付订单ID  此ID需要业务系统保存，后续取消、查询、获取二维码等操作时需要传入
     */
    @RequestMapping(value = "/payment/pay.do", method = RequestMethod.POST)
    ApiResultVO<String> genPayNote(@RequestBody PayInfoDTO info);

    /**
     * 支付服务-获取缴费通知书二维码
     *
     * @param id 支付订单ID
     * @return 返回二维码 base64 String
     */
    @RequestMapping(value = "/payment/getPayNoteQrCode.do", method = RequestMethod.POST)
    ApiResultVO<String> getPayNoteQrCode(@RequestParam(value = "id") String id);

    /**
     * 支付服务-查询支付详情及缴费状态
     *
     * @param id 支付订单ID
     * @return 0000-查询成功并返回支付订单信息，否则失败
     */
    @RequestMapping(value = "/payment/queryOrder.do", method = RequestMethod.POST)
    ApiResultVO<PayOrder> queryOrder(@RequestParam(value = "id") String id);

    /**
     * 支付服务-取消订单（缴款通知书）
     *
     * @param id 支付订单ID
     * @return 0000-取消成功，否则失败，错误信息见message
     */
    @RequestMapping(value = "/payment/cancleOrder.do", method = RequestMethod.POST)
    ApiResultVO<String> cancleOrder(@RequestParam(value = "id") String id);

    /**
     * 认证服务-银行卡四要素认证
     *
     * @param elemInfo
     * @return 0000-认证成功，否则失败
     */
    @RequestMapping(value = "/auth/bankFourElement.do", method = RequestMethod.POST)
    ApiResultVO<String> verifyBankFourElement(@RequestBody BankFourElementDTO elemInfo);

    /**
     * 得到
     *
     * @param formData
     * @return
     */
    @RequestMapping(value = "/faceId/getToken", method = RequestMethod.POST)
    ApiResultVO<FaceIdGetTokenVO> getFaceToken(@RequestBody FaceIdDTO formData);

    /**
     * 易保全-文件签名
     */
    @RequestMapping(value = "/fileSign/signature", method = RequestMethod.POST)
    ApiResultVO<String> signature(@RequestBody SignatureDTO signatureDTO);

    /**
     * 易保全-获取文件签名完成的文件下载URL
     */
    @RequestMapping(value = "/fileSign/signatureDownloadUrl", method = RequestMethod.POST)
    ApiResultVO<String> getSignatureDownloadUrl(@RequestParam(value = "signSignatureLogId") String signSignatureLogId);

    /**
     * 易保全-文件签章
     */
    @RequestMapping(value = "/fileSign/signet", method = RequestMethod.POST)
    ApiResultVO<String> signet(@RequestBody SignetDTO signetDTO);

    /**
     * 易保全-给特定签章人员发送签约短信
     */
    @RequestMapping(value = "/fileSign/signNotify", method = RequestMethod.POST)
    ApiResultVO<Boolean> signNotify(@RequestParam(value = "signSignetLogId") String signSignetLogId, @RequestBody SignatureDTO
            signatureDTO);

    /**
     * 易保全-获取签章完成的文件下载URL
     */
    @RequestMapping(value = "/fileSign/fileLink", method = RequestMethod.POST)
    ApiResultVO<String> fileLink(@RequestParam(value = "signSignetLogId") String signSignetLogId);

    /**
     * 易保全-获取签章URL
     */
    @RequestMapping(value = "/fileSign/link", method = RequestMethod.POST)
    ApiResultVO<String> link(@RequestParam(value = "signSignetLogId") String signSignetLogId, @RequestBody SignatureDTO
            signatureDTO);

    /**
     * 易保全-查询签章状态
     */
    @RequestMapping(value = "/fileSign/signStatus", method = RequestMethod.POST)
    ApiResultVO<Integer> signStatus(@RequestParam(value = "signSignetLogId") String signSignetLogId, @RequestBody SignatureDTO
            signatureDTO);

    /**
     * 易保全-查询签章完成之后的备案号
     */
    @RequestMapping(value = "/fileSign/recordNo", method = RequestMethod.POST)
    ApiResultVO<Integer> getRecordNo(@RequestParam(value = "signSignetLogId") String signSignetLogId, @RequestBody SignatureDTO
            signatureDTO);

    /**
     * 易保全-上传机构认证信息
     */
    @RequestMapping(value = "/fileSign/organizationCreate", method = RequestMethod.POST)
    ApiResultVO<String> organizationCreate(@RequestBody SignCreateOrganizationLog organizationLog);

    /**
     * 易保全-查询上传机构认证信息状态
     */
    @RequestMapping(value = "/fileSign/organizationStatus", method = RequestMethod.GET)
    ApiResultVO<String> getOrganizationStatus(
            @RequestParam(value = "signCreateOrganizationLogId") String signCreateOrganizationLogId);
}
