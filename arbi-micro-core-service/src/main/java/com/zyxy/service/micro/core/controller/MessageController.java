package com.zyxy.service.micro.core.controller;

import com.zyxy.common.vo.MessageCenterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.MessageInsertDTO;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MessageInfoVO;
import com.zyxy.common.vo.MessageRecordListVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.MessageService;

/**
 * 消息模块Controller
 */
@Api("消息模块")
@RestController
@RequestMapping("/common/message")
public class MessageController extends BaseController{

    @Autowired
    private MessageService messageService;

    @ApiOperation("消息列表")
    @RequestMapping("")
    public ApiResultVO<MessageCenterVO> list(@RequestBody @Valid MessageRecordListDTO formData, BindingResult bindingResult, HttpServletRequest request){
        //参数验证
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        MessageCenterVO messageCenterVO =  messageService.queryMessageList(formData);
        return super.ok(messageCenterVO);
    }

    @ApiOperation("获取消息详情")
    @RequestMapping("/{id}/get")
    public ApiResultVO<MessageInfoVO> get(@PathVariable() Integer id, String userId, HttpServletRequest request){

        //参数验证
        if (id == null){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = messageService.messageInfoBusiValid(id,userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        //业务执行
        BusiExecuteResult<MessageInfoVO> busiExecuteResult = messageService.messageInfoExecute(id,userId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }

        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation("更改消息状态")
    @RequestMapping("/{id}/update")
    public ApiResultVO<String> updateStatus(@PathVariable Integer id, String userId, HttpServletRequest request){
        int rows = messageService.updateMessageStatus(id, userId);
        return rows>0?super.ok():super.error(ApiResultVO.Coder.DB_UPDATE_ERROR);
    }

    @ApiOperation("一键删除")
    @RequestMapping("/deleteAll")
    public ApiResultVO<String> deleteAll(HttpServletRequest request, String userId){
        messageService.deleteAllMessages(userId);
        return super.ok();
    }

    @ApiOperation("删除")
    @RequestMapping("/{id}/delete")
    public ApiResultVO<String> delete(@PathVariable Integer id, String userId){
        //参数验证
        if (id == null){
            return super.validError();
        }
        int rows = messageService.deleteMessage(id, userId);
        return rows > 0?super.ok():super.error(ApiResultVO.Coder.DB_DELETE_ERROR);
    }

    @ApiOperation("发送消息")
    @RequestMapping("/post")
    public ApiResultVO<String> add(@RequestBody @Valid MessageInsertDTO formData,BindingResult bindingResult, HttpServletRequest request){
        if (bindingResult.hasErrors()){
            return  super.validError();
        }
        messageService.addMessage(formData);
        return super.ok();
    }
}
