package com.zyxy.admin.controller;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.FinanceService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.FincaceDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.FinanceVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 财务模块控制层
 */
@Controller
@RequestMapping("case/finance")
public class FinanceController extends BaseController{

    @Autowired
    private FinanceService financeService;

    @WebLog("仲裁委—财务模块列表")
    @RequestMapping("")
    @ResponseBody
    public PageInfo<FinanceVO> list(@Valid FincaceDTO formData, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){

        SecurityUserVO sessionUser = super.getSessionUser();

        /*
            参数验证
         */
        if(bindingResult.hasErrors()){
            response.setStatus(Integer.parseInt(ApiResultVO.Coder.VALID_ERROR.getCode()));
            return null;
        }

        /*
            业务处理
         */
        BusiExecuteResult<PageInfo<FinanceVO>> pageInfoBusiExecuteResult = financeService.queryFinanceBusiExecute(formData);

        if(pageInfoBusiExecuteResult.hasError()){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }


        return pageInfoBusiExecuteResult.getBody();
    }
}
