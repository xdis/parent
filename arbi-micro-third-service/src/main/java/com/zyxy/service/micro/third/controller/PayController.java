package com.zyxy.service.micro.third.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.vo.PayItemVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.third.service.PayRLItemsService;
import com.zyxy.service.micro.third.service.PayService;

/**
 * 支付服务模块
 * @author tanquan
 */
@Api(description="支付服务模块")
@RequestMapping("/payment")
@Controller
public class PayController extends BaseController{

	@Autowired
	private PayService payService;
	@Autowired
	private PayRLItemsService payRLItemsService;
	
	
	
	/**
	 * 获取缴费项目信息
	 * @param request
	 * @param usages 0-案件处理费，1-案件受理费
	 * @param bdResult
	 * @return
	 */
	@ApiOperation(value="获取缴费项目信息")
	@RequestMapping(value = "/getPayItems.json", method = {RequestMethod.POST})
	@ResponseBody
	public ApiResultVO<List<PayItemVO>> getPayItems(HttpServletRequest request
	        , @ApiParam("用途分类：0-案件处理费，1-案件受理费，2-案件行为收费")@RequestParam(required=true) Integer usages
	        ) {
	    // 该日志必不可少
	    String busiDesr = "获取缴费项目信息";
	    logger.info("开始业务[{}]-参数:{}",  RequestUtil.getParamMap(request));
	    
	    List<PayItemVO> list = payRLItemsService.selectPayItemByUsages(usages);
	    
	    // 该日志必不可少
	    logger.info("执行业务[{}]成功", busiDesr);
	    return ok(list);
	}
	
    
	/**
	 * 发起支付请求（生成缴款通知书）
	 * @param request
	 * @param payInfo
	 * @param bdResult
	 * @return
	 */
	@ApiOperation(value="发起支付请求（生成缴款通知书）")
	@RequestMapping(value = "/pay.do", method = {RequestMethod.POST})
	@ResponseBody
	public ApiResultVO<String> pay(HttpServletRequest request
	        ,@Valid @RequestBody PayInfoDTO payInfo
	        ,BindingResult bdResult
	        ) {
        // 该日志必不可少
        String busiDesr = "发起支付请求（生成缴款通知书）";
        logger.info("开始业务[{}]-参数:{}",  RequestUtil.getParamMap(request));
        
        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        
        BuzzResultVO<String> ret = payService.pay(payInfo);
        
        if (!ret.getOk()) {
            return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(ret.getMessage()), ret.getAttach());
        }
        
        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(ret.getAttach());
	}
    
	/**
	 * 支付服务-获取缴费通知书二维码
	 * @param request
	 * @param id
	 * @param bdResult
	 * @return
	 */
	@ApiOperation(value="支付服务-获取缴费通知书二维码")
	@RequestMapping(value = "/getPayNoteQrCode.do", method = {RequestMethod.POST})
	@ResponseBody
	public ApiResultVO<String> getPayNoteQrCode(HttpServletRequest request
	        ,@RequestParam(required=true) String id
	        ) {
	    // 该日志必不可少
	    String busiDesr = "支付服务-获取缴费通知书二维码";
	    logger.info("开始业务[{}]-参数:{}",  RequestUtil.getParamMap(request));
	    
	    BuzzResultVO<String> ret = payService.getPayNoteQrCode(id);
	    
	    if (!ret.getOk()) {
	        return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(ret.getMessage()));
	    }
	    
	    // 该日志必不可少
	    logger.info("执行业务[{}]成功", busiDesr);
	    return ok(ret.getAttach());
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
	    
	    BuzzResultVO<PayOrder> ret = payService.queryOrder(id, false);
	    
	    if (!ret.getOk()) {
	        return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(ret.getMessage()));
	    }
	    
	    // 该日志必不可少
	    logger.info("执行业务[{}]成功", busiDesr);
	    return ok(ret.getAttach());
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
	    
	    BuzzResultVO<String> ret = payService.cancleQuery(id);
	    
	    if (!ret.getOk()) {
	        return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(ret.getMessage()));
	    }
	    
	    // 该日志必不可少
	    logger.info("执行业务[{}]成功", busiDesr);
	    return ok();
	}
	
}
