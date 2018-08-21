package com.zyxy.admin.controller;

import com.zyxy.admin.service.CaseAvoidRecordService;
import com.zyxy.admin.service.CompromiseRecordService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.domain.CompromiseRecord;
import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CaseCompromiseRecordVO;
import com.zyxy.common.vo.QuestionAnswerListVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;

/**
 * 和解记录controller
 */
@Controller
@RequestMapping("/compromise/record")
public class CompromiseRecordController extends BaseController {

    @Autowired
    private CompromiseRecordService compromiseRecordService;

    @Autowired
    private CaseAvoidRecordService caseAvoidRecordService;


    /**
     * 仲裁委和解记录
     * @param caseId
     * @param request
     * @return
     */
    @WebLog("仲裁委-和解记录")
    @RequestMapping("/{caseId}")
    @ResponseBody
    public ApiResultVO<List<CaseCompromiseRecordVO>> list(@PathVariable("caseId") String caseId, HttpServletRequest request){

        SecurityUserVO sessionUser = super.getSessionUser();


        //参数验证
        if(StringUtil.isEmpty(caseId)){
            return super.busiValidError(Coder.VALID_ERROR);
        }

        //业务验证
        BusiValidResult busiValidResult = compromiseRecordService.queryCompromiseRecordBusiValid(caseId);

        if(busiValidResult.hasError()){
           return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }

        //业务处理
        List<CaseCompromiseRecordVO> caseCompromiseRecordVOList = compromiseRecordService.queryCompromiseRecordBusiExecute(caseId);
        return super.ok(caseCompromiseRecordVOList);
    }
    
    /**
     * 裁判-和解沟通记录、仲裁员当事人问答记录
     * @param caseId
     * @param request
     * @return
     */
    @WebLog("裁判-和解沟通记录、仲裁员当事人问答记录")
    @RequestMapping("settlement/{caseId}")
    @ResponseBody
    public ModelAndView record(@PathVariable("caseId") String caseId, HttpServletRequest request){

        SecurityUserVO sessionUser = super.getSessionUser();
        ModelAndView modelAndView = new ModelAndView("case/theReferee");

        //参数验证
        if(StringUtil.isEmpty(caseId)){
        	modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
        	modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
        	return modelAndView;
        }

        //业务验证
        BusiValidResult busiValidResult = compromiseRecordService.queryCompromiseRecordBusiValid(caseId);

        if(busiValidResult.hasError()){
        	modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
        	modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
        	return modelAndView;
        }

        //业务处理
        List<CaseCompromiseRecordVO> caseCompromiseRecordVOList = compromiseRecordService
        		.queryCompromiseRecordBusiExecute(caseId);
        
        QuestionAnswerListVO answerListVO = compromiseRecordService.questionAnswer(caseId);
        
        modelAndView.addObject("caseCompromiseRecordVOList", caseCompromiseRecordVOList);
        modelAndView.addObject("answerListVO", answerListVO);
        
        return modelAndView;
    }

    /**
     * 仲裁秘书参与和解记录，发送消息
     * @param formData
     * @param request
     * @return
     */
    @WebLog("仲裁秘书参与和解记录，发送消息")
    @RequestMapping("/sender")
    @ResponseBody
    public ApiResultVO sender(@Valid CompromiseRecord formData, BindingResult bindingResult, HttpServletRequest request){

        SecurityUserVO sessionUser = super.getSessionUser();


        //参数初始化
        formData.setCreaterId(sessionUser.getUserInfoId());

        //参数验证
        if(bindingResult.hasErrors()){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = compromiseRecordService.queryCompromiseRecordBusiValid(formData.getCaseId());

        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }

        //业务处理
        boolean flag = compromiseRecordService.insertCompromseRecordBusiExecute(formData);

        //返回是否更新成功
        return flag?super.ok():super.error(ApiResultVO.Coder.DB_INSERT_ERROR);
    }


    /**
     * 仲裁秘书申请回避
     * @param formData
     * @param bindingResult
     * @param request
     * @return
     */
    @WebLog("仲裁委-仲裁秘书申请回避")
    @RequestMapping("/sidestep")
    @ResponseBody
    public ApiResultVO sidestep(@Valid CaseAvoidRecordInsertDTO formData, BindingResult bindingResult, HttpServletRequest request){
        SecurityUserVO sessionUser = super.getSessionUser();


        // 参数初始化
        formData.setCreaterId(sessionUser.getUserInfoId());

        //参数验证
        if(bindingResult.hasErrors()){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = compromiseRecordService.queryCompromiseRecordBusiValid(formData.getCaseId());

        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }

        //业务处理
        Boolean flag = caseAvoidRecordService.insertCaseAvoidRecordBusiExecute(formData);

        return flag?super.ok():super.error(ApiResultVO.Coder.DB_INSERT_ERROR);

    }
}
