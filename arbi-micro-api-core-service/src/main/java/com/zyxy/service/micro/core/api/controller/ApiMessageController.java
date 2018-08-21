package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.MessageInsertDTO;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MessageCenterVO;
import com.zyxy.common.vo.MessageInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 消息模块Controller
 */
@Api(description="消息模块")
@RestController
@RequestMapping("/api/common/message")
public class ApiMessageController extends BaseController {

    Logger logger = LoggerFactory.getLogger(ApiMessageController.class);

    @Autowired
    private MessageService messageService;

    @WebLog("消息-消息列表")
    @ApiOperation("消息列表")
    @GetMapping("")
    public ApiResultVO<MessageCenterVO> list(@RequestBody MessageRecordListDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return messageService.list(formData);
    }

    @WebLog("消息-获取消息详情")
    @ApiOperation("获取消息详情")
    @GetMapping("/{id}")
    public ApiResultVO<MessageInfoVO> get(@PathVariable() Integer id) {
        return messageService.get(id, getSessionUser().getUserInfoId());
    }

    @WebLog("消息-更改消息状态")
    @ApiOperation("更改消息状态")
    @PutMapping("/{id}")
    public ApiResultVO<String> updateStatus(@PathVariable Integer id) {
        return messageService.updateStatus(id, getSessionUser().getUserInfoId());
    }

    @WebLog("消息-一键删除")
    @ApiOperation("一键删除")
    @DeleteMapping("")
    public ApiResultVO<String> deleteAll() {
        return messageService.deleteAll(getSessionUser().getUserInfoId());
    }

    @WebLog("消息-删除")
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResultVO<String> delete(@PathVariable Integer id) {
        return messageService.delete(id, getSessionUser().getUserInfoId());
    }

    @WebLog("消息-发送信息")
    @ApiOperation("发送消息")
    @PostMapping("")
    public ApiResultVO<String> add(@RequestBody MessageInsertDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return messageService.add(formData);
    }
}
