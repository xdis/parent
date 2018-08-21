package com.zyxy.common.mapper;

import java.util.List;
import java.util.Map;

public interface CaseFlowMapper {

    List<String> queryReplyExpireCase();

    List<String> queryPayExpireCase();

    List<String> queryOffsetExpireCase();

    List<Map<String, String>> queryReplyExpireNoticeCase();

    List<String> queryReplyExpireNotSelectArbitratorCase();

    List<Map<String, String>> queryPayingCase();

    int compromiseStart();

    List<String> queryCompromiseOverCase();

    List<Map<String, String>> queryBeRequestPayingCase();

    List<Map<String, String>> queryBeRequestExpireCase();

    List<Map<String, String>> queryChangeRequestPayingCase();

    List<Map<String, String>> queryChangeRequestExpireCase();
}
