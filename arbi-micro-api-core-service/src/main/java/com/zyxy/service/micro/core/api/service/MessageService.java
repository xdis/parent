package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.MessageInsertDTO;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MessageCenterVO;
import com.zyxy.common.vo.MessageInfoVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 消息模块Controller
 */
@FeignClient("coreService")
public interface MessageService {

    /**
     * 消息列表
     * @param formData
     * @return
     */
    @RequestMapping(value = "/common/message",method = RequestMethod.POST)
    ApiResultVO<MessageCenterVO> list(@RequestBody MessageRecordListDTO formData);

    /**
     * 指定Id详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/common/message/{id}/get", method = RequestMethod.POST)
    ApiResultVO<MessageInfoVO> get(@PathVariable("id") Integer id, @RequestParam("userId") String userId);

    /**
     * 更改消息状态
     * @param id
     * @return
     */
    @RequestMapping(value = "/common/message/{id}/update",method = RequestMethod.POST)
    ApiResultVO<String> updateStatus(@PathVariable("id") Integer id, @RequestParam("userId") String userId);

    /**
     * 一键删除
     * @return
     */
    @RequestMapping(value = "/common/message/deleteAll",method = RequestMethod.POST)
    ApiResultVO<String> deleteAll(String userId);

    /**
     * 删除指定ID信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/common/message/{id}/delete",method = RequestMethod.POST)
    ApiResultVO<String> delete(@PathVariable("id") Integer id, @RequestParam("userId") String userId);

    /**
     * 发送消息
     * @param formData
     * @return
     */
    @RequestMapping(value = "/common/message/post",method = RequestMethod.POST)
    ApiResultVO<String> add(@RequestBody MessageInsertDTO formData);
}
