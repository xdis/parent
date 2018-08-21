package com.zyxy.service.micro.api.service.api;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyxy.common.constants.RegexpConstant;
import com.zyxy.common.domain.ApiOrgnazation;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.ArrayUtil;
import com.zyxy.common.util.BeanUtil;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqBaseDTO;
import com.zyxy.service.micro.api.dto.ResResultDTO;
import com.zyxy.service.micro.api.enums.ApiCodeEnum;
import com.zyxy.service.micro.api.service.ApiOrgnazationService;
import com.zyxy.service.micro.api.service.cert.SecretService;

/**
 * api逻辑处理基础类
 * @author sonta
 *
 */
public abstract class BaseService<REQ_VO extends ReqBaseDTO, RES_VO>{

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected Validator validator;
	@Autowired
	protected SequenceService sequenceService;
	@Autowired
	private ApiOrgnazationService apiOrgnazationService;
	@Autowired
	protected SecretService secretService;
    
	/**
	 * 核心业务处理
	 * @return
	 */
	public ResResultDTO call(REQ_VO vo, String currentIp) {
	    ResResultDTO ret = new ResResultDTO();
	    // 基本参数检查 orgNo校验
	    BuzzResultVO<ApiOrgnazation> bRet = this.baseParamCheck(vo, currentIp);
	    if (!bRet.getOk()) {
	        return ret.setCoder(ApiCodeEnum.UNKNOWN_ORGANIZATION);
	    }
	    
	    // 白名单校验
	    if (!this.checkWhiteList(bRet.getAttach().getIpWhiteList(), currentIp)) {
	        return ret.setCoder(ApiCodeEnum.UNKNOWN_HOST_IP);
	    }
	    
	    // 验签
        if (!this.verifySign(vo)) {
            return ret.setCoder(ApiCodeEnum.SIGN_ERROR);
        }
        
	    // 参数解密
	    BuzzResultVO<REQ_VO> decRet = this.decrypt(vo);
	    if (!decRet.getOk()) {
	        return ret.setCoder(ApiCodeEnum.DECRYPT_ERROR).setMessage(decRet.getMessage());
	    }
	    vo = decRet.getAttach();
	    logger.info("参数解密结果-{}", JsonUtil.toJson(vo));
	    
	    // 参数有效性检查
	    BuzzResultVO<String> vRet = this.validate(vo);
	    if (!vRet.getOk()) {
	        if (vRet.getMessage() == null) {
	            return ret.setCoder(ApiCodeEnum.ERROR);
	        }
	        return ret.setCoder(ApiCodeEnum.REQ_PARAM_ILLEGAL).setMessage(vRet.getMessage());
	    }
	    
	    // 业务处理
	    BuzzResultVO<RES_VO> bizRet = this.doBuzz(vo, currentIp);
	    if (!bizRet.getOk()) {
	        return ret.setCoder(ApiCodeEnum.BIZZ_EXCUTE_FAILED).setMessage(bizRet.getMessage());
	    }
	    logger.debug("待返回结果：{}", this.getJsonStr(bizRet.getAttach()));
	    // 结果加密处理
	    BuzzResultVO<String> encRet = this.encrypt(bizRet.getAttach(), vo.getOrgNo());
	    if (!encRet.getOk()) {
	        return ret.setCoder(ApiCodeEnum.ERROR);
	    }
	    if (StringUtil.isEmpty(encRet.getAttach())) {
	        return ret.setCoder(ApiCodeEnum.SUCCESS);
	    }
	    // 加密内容URLEncode
	    String encStr = null;
	    try {
            encStr = URLEncoder.encode(encRet.getAttach(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("URLEncoder 失败-{}", encRet.getAttach(), e);
            return ret.setCoder(ApiCodeEnum.ERROR);
        }
	    return ret.setCoder(ApiCodeEnum.SUCCESS).setResult(encStr);
	}
	

    /**
     * 业务实现
     * @param vo
     * @return
     */
    protected abstract BuzzResultVO<RES_VO> doBuzz(REQ_VO vo, String ip);
	
	/**
	 * 解密参数
	 * @param vo
	 * @return
	 */
	protected BuzzResultVO<REQ_VO> decrypt(REQ_VO vo) {
	    if (vo.getSecretKeys() == null || vo.getSecretKeys().length < 1) {
	        return this.success(vo);
	    }
	    Map<String, Object> beanMap = BeanUtil.getFieldsAsMap(vo, true);
	    for (String key : vo.getSecretKeys()) {
	        if (StringUtil.isEmpty((String)beanMap.get(key))) {
	            continue;
	        }
	        try {
                BeanUtil.findDeclaredMethod(vo.getClass(), "set" + BeanUtil.getMethodName(key), String.class).invoke(vo, secretService.decrypt(vo.getOrgNo(), (String)beanMap.get(key)));
            } catch (IllegalAccessException e) {
                logger.error("解密环节出错", e);
                return this.error(null);
            } catch (IllegalArgumentException e) {
                logger.error("解密环节出错", e);
                return this.error(null);
            } catch (InvocationTargetException e) {
                logger.error("解密环节出错", e);
                return this.error(null);
            } catch (Exception e) {
                logger.error("参数解密失败-param:{},value:{}", key, beanMap.get(key), e);
                return this.error("解密[" + key + "]失败，请确认已加密");
            }
	    }
	    return this.success(vo);
	}
	
	/**
	 * 参数验证
	 * @param vo
	 * @return
	 */
	private BuzzResultVO<String> validate(REQ_VO vo) {
	    Set<ConstraintViolation<REQ_VO>> set = validator.validate(vo);
	    if (set == null || set.isEmpty()) {
	        return this.success();
	    }
	    StringBuilder errorRes = new StringBuilder();
	    for (ConstraintViolation<REQ_VO> constraintViolation : set) {
	        errorRes.append(constraintViolation.getPropertyPath().toString()).append(constraintViolation.getMessage()).append(";");
	    }
	    if (errorRes.indexOf(";") > -1) {
	        return this.error(errorRes.substring(0, errorRes.lastIndexOf(";")));
	    }
	    return this.error(errorRes.toString());
	}
	
	/**
	 * 基本参数检查（orgNo）
	 * @param vo
	 * @return
	 */
	private BuzzResultVO<ApiOrgnazation> baseParamCheck(REQ_VO vo, String currentIp) {
	    if (StringUtil.isEmpty(vo.getOrgNo())) {
	        return this.error("orgNo不能为空");
	    }
	    if (!vo.getOrgNo().matches(RegexpConstant.ID_COMMON_REGEX)) {
	        return this.error("orgNo格式不正确");
	    }
	    ApiOrgnazation org = apiOrgnazationService.selectCacheByPrimaryKey(vo.getOrgNo());
	    if (org == null) {
	        return this.error("机构/用户不存在");
	    }
	    return this.success(org);
	}
	
	/**
	 * 白名单检测
	 * @return
	 */
	private boolean checkWhiteList(String whiteListJsonStr, String currentIp) {
	    if (StringUtil.isEmpty(whiteListJsonStr)) {
	        return false;
	    }
	    if ("*".equals(whiteListJsonStr.trim())) {
	        return true;
	    }
	    List<String> whiteList = JsonUtil.jsonToList(whiteListJsonStr, String.class);
	    if (whiteList == null || whiteList.isEmpty()) {
	        return false;
	    }
	    for (String ip : whiteList) {
	        ip = ip.trim();
	        // 区间的形式只允许ip最后一个区段为变化区段
	        if (ip.indexOf("-") > -1) {
	            String[] arrs = ip.split("-");
	            if (arrs[0].equals(currentIp) || arrs[1].equals(currentIp)) {
	                return true;
	            }
	            String ipCommon = arrs[0].substring(0, arrs[0].lastIndexOf(".") + 1);
	            int s = Integer.valueOf(arrs[0].substring(arrs[0].lastIndexOf(".") + 1));
	            int e = Integer.valueOf(arrs[1].substring(arrs[1].lastIndexOf(".") + 1));
	            for (int i = 1; i < e - s + 1; i++) {
	                if ((ipCommon + i).equals(currentIp)) {
	                    return true;
	                }
	            }
	        } else if (ip.equals(currentIp)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * 内容加密
	 * @param res
	 * @param orgNo
	 * @return
	 */
	protected BuzzResultVO<String> encrypt(RES_VO res, String orgNo) {
	    BuzzResultVO<String> ret = new BuzzResultVO<String>();
	    if (res == null) {
	        return this.success(null);
	    }
	    ret = this.getJsonStr(res);
	    if (!ret.getOk()) {
	        return ret;
	    }
	    String toEncryptStr = ret.getAttach();
	    if (toEncryptStr == null || StringUtil.isEmpty(toEncryptStr)) {
	        return this.success(toEncryptStr);
	    }
	    try {
            return this.success(secretService.encrypt(orgNo, toEncryptStr));
        } catch (Exception e) {
            logger.error("加密错误-{}", toEncryptStr);
            return this.error("加密错误");
        }
	}
	
	/**
	 * 获取json字符串
	 * @param res
	 * @return
	 */
	private BuzzResultVO<String> getJsonStr(RES_VO res) {
	    if (res == null) {
            return this.success(null);
        }
        if (res instanceof String || res instanceof Integer || res instanceof Double || res instanceof Float || res instanceof Long) {
            return this.success(String.valueOf(res));
        }
        String toEncryptStr = null;
        try {
            toEncryptStr = JsonUtil.toJson(res);
        } catch (Exception ex) {
            return this.error("to json string failed");
        }
        return this.success(String.valueOf(toEncryptStr));
	}
	
	/**
	 * 验签
	 * @param obj
	 * @return
	 */
	protected Boolean verifySign(REQ_VO vo) {
	    String[] noSignKeys = vo.noSignKeys();
	    if (noSignKeys == null || noSignKeys.length < 1) {
	        noSignKeys = new String[] {"sign"};
	    } else {
	        noSignKeys = ArrayUtil.concatAll(noSignKeys, new String[]{"sign"});
	    }
	    Map<String, Object> toSignMap = BeanUtil.getFieldsAsHttpMap(vo, noSignKeys, true);
	    String toSignContent = secretService.getSignContent(toSignMap);
        try {
            return secretService.verify(vo.getOrgNo(), toSignContent, vo.getSign());
        } catch (Exception e) {
            logger.error("验签错误-{}", vo.getOrgNo(), e);
            logger.warn("sign content - {}", toSignContent);
        }
        return false;
	}
	
	/**
	 * 签名
	 * @param obj
	 * @return
	 */
	protected String sign(Object obj) {
	    return "";
	}
	
	protected boolean isApiExcuteSuccess(ApiResultVO<?> vo) {
	    return ApiResultVO.Coder.SUCCESS.getCode().equals(vo.getHead().getRetCode());
	}
	
	protected String getApiExcuteMessage(ApiResultVO<?> vo) {
	    return vo.getHead().getMsg();
	}
	
	protected <T> BuzzResultVO<T> error(String message) {
	    return new BuzzResultVO<T>().setOk(false).setMessage(message);
	}
	
	protected <T> BuzzResultVO<T> success(T t) {
	    return new BuzzResultVO<T>().setOk(true).setAttach(t);
	}
	
	protected <T> BuzzResultVO<T> success() {
	    return new BuzzResultVO<T>().setOk(true);
	}
}
