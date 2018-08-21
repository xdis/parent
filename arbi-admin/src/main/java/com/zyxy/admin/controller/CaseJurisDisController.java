package com.zyxy.admin.controller;

import com.zyxy.admin.service.CaseJurisDisService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseJurisDisDTO;
import com.zyxy.common.dto.CaseJurisDisExamineDTO;
import com.zyxy.common.dto.SaveCaseDocDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitrationCaseJurisDisVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 仲裁委管辖权异议审核
 */
@Controller
@RequestMapping("/case/jurisdis")
public class CaseJurisDisController extends BaseController {


    @Autowired
    private CaseJurisDisService caseJurisDisService;

    /**
     * 管辖权异议审核
     * @param jurisApproveId
     * @return
     */
    @WebLog("仲裁委-管辖权异议审核")
    @RequestMapping("/{jurisApproveId}")
    public ModelAndView get(@PathVariable("jurisApproveId") String jurisApproveId) {
        SecurityUserVO sessionUser = super.getSessionUser();

        //参数初始化
        ModelAndView modelAndView = new ModelAndView("case/juisdictiondissent");


        // 参数验证
        if (StringUtil.isEmpty(jurisApproveId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }

        //业务验证
        BusiValidResult busiValidResult = caseJurisDisService.queryCaseJurisDisByCaseIdBusiValid(jurisApproveId,sessionUser.getUserInfoId());

        if (busiValidResult.hasError()) {
        	modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }

        //业务处理
        BusiExecuteResult<ArbitrationCaseJurisDisVO> busiExecuteResult = caseJurisDisService.queryCaseJurisDisByCaseIdBusiExecute(jurisApproveId, sessionUser.getUserInfoId());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("arbitrationCaseJurisDis", busiExecuteResult.getBody());
        return modelAndView;
    }

    /**
     * 审核管辖权异议
     *
     * @param formData
     * @param bindingResult
     * @param request
     * @return
     */
    @WebLog("仲裁委—审核管辖权异议")
    @RequestMapping("/examine")
    @ResponseBody
    public ApiResultVO examine(@Valid SaveCaseDocDTO formData, BindingResult bindingResult, HttpServletRequest request) {

        SecurityUserVO sessionUser = super.getSessionUser();

        //参数初始化
        formData.setUserId(sessionUser.getUserInfoId());

        //参数验证
        if (bindingResult.hasErrors()) {
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = caseJurisDisService.saveDocAndDocContentBusiValidResult(formData);

        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
        }

        //业务处理
        BusiExecuteResult busiExecuteResult = caseJurisDisService.saveDocAndDocContentBusiExecuteResult(formData);

        /*
            判断是否处理成功
         */
        if (busiExecuteResult.hasError()) {
        	return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }

        return super.ok();
    }

}
