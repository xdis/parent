package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyxy.admin.service.CaseProtocolRecordService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.domain.CaseProtocolRecordWithBLOBs;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;

/**
 * 调解协议申请
 *
 */
@Controller
@RequestMapping("/case/protocolRecord")
public class CaseProtocolRecordController extends BaseController{
	
	@Autowired
	private CaseProtocolRecordService caseProtocolRecordService;
	
	/**
	 * 调解协议申请
	 * @param caseId
	 * @param request
	 * @return
	 */
	@WebLog("仲裁委-调解协议申请")
	@RequestMapping("/{caseId}")
	@ResponseBody
	public ApiResultVO<CaseProtocolRecordWithBLOBs> caseProtocolRecordApply(@PathVariable("caseId") String caseId, HttpServletRequest request){
		
		//参数验证
		if(StringUtil.isEmpty(caseId)){
			return super.busiValidError(Coder.VALID_ERROR);
		}
		
		//业务验证
		BusiValidResult busiValidResult = caseProtocolRecordService.queryCaseProtocolRecordBusiValid(caseId);
		if(busiValidResult.hasError()){
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		
		//业务处理
		BusiExecuteResult<CaseProtocolRecordWithBLOBs> busiExecuteResult = caseProtocolRecordService.queryCaseProtocolRecordBusiExecute(caseId);
		
		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	}
}
