package com.zyxy.admin.controller;

import com.zyxy.admin.service.CompromiseApplyService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ComproiseApplyVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 和解申请控制层
 */
@Controller
@RequestMapping("/compromise/apply")
public class CompromiseApplyController extends BaseController{

    @Autowired
    private CompromiseApplyService compromiseApplyService;

    /**
     * 仲裁委和解申请
     * @param caseId
     * @param request
     * @return
     */
    @WebLog("仲裁委-和解申请")
    @RequestMapping("/{caseId}")
    public ModelAndView compromiseApply(@PathVariable("caseId") String caseId,HttpServletRequest request){
        SecurityUserVO sessionUser = super.getSessionUser();

        //参数初始化
        ModelAndView modelAndView = new ModelAndView("case/peoplecompromiseApply");

        //参数验证
        if(StringUtil.isEmpty(caseId)){
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }

        //业务验证
        BusiValidResult busiValidResult = compromiseApplyService.queryComproiseApplyBusiValid(caseId);

        if(busiValidResult.hasError()){
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message",busiValidResult.getMsg());
            return modelAndView;
        }

        //业务处理
        ComproiseApplyVO comproiseApplyVO = compromiseApplyService.queryComproiseApplyBusiExcute(caseId);
        modelAndView.addObject("caseId",caseId);
        modelAndView.addObject("comproiseApplyVO",comproiseApplyVO);

        return modelAndView;
    }


    /**
     * 仲裁委同意和解申请
     * @param applyId
     * @param startTime
     * @return
     */
    @WebLog("仲裁委-同意和解申请")
    @RequestMapping("/agree")
    @ResponseBody
    public ApiResultVO agree(@RequestParam("caseId") String caseId,@RequestParam("applyId") String applyId,@RequestParam("startTime") String startTime){
        SecurityUserVO sessionUser = super.getSessionUser();

        //参数验证
        if(StringUtil.isEmpty(applyId)&&StringUtil.isEmpty(startTime)){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = compromiseApplyService.compromiseApplyBusiValidResult(applyId);

        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
        }

        //业务处理
        BusiExecuteResult busiExecuteResult = compromiseApplyService.agreeCompromiseApplyBusiExcute(applyId, startTime,caseId);

        if(busiExecuteResult.hasError()){
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }

        return super.ok();
    }


    /**
     * 仲裁委拒绝和解申请
     * @param applyId
     * @return
     */
    @WebLog("仲裁委-拒绝和解申请")
    @RequestMapping("/refuse")
    @ResponseBody
    public ApiResultVO refuse(@RequestParam("applyId") String applyId){
        SecurityUserVO sessionUser = super.getSessionUser();

        //参数验证
        if(StringUtil.isEmpty(applyId)){
            return super.validError();
        }


        //业务验证
        BusiValidResult busiValidResult = compromiseApplyService.compromiseApplyBusiValidResult(applyId);


        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
        }

        //业务处理
        BusiExecuteResult busiExecuteResult = compromiseApplyService.refuseCompromiseApplyBusiExcute(applyId);

        if(busiExecuteResult.hasError()){
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }

        return super.ok();
    }


}
