package com.zyxy.common.mapper;

import com.zyxy.common.vo.doc.CaseDocAgentVO;
import com.zyxy.common.vo.doc.CaseDocLitigantVO;
import org.apache.ibatis.annotations.Param;

public interface CaseDocCommMapper {

    /**
     * 查询当事人信息
     *
     * @param caseId       案件Id
     * @param requestType  请求类型
     * @param litigantType 当事人类型
     * @return
     */
    CaseDocLitigantVO queryLitigantInfo(@Param("caseId") String caseId, @Param("requestType") String requestType, @Param("litigantType") String litigantType);

    /**
     * 查询当事人信息
     *
     * @param caseId       案件Id
     * @param requestType  请求类型
     * @param litigantType 当事人类型
     * @return
     */
    CaseDocAgentVO queryAgentInfo(@Param("caseId") String caseId, @Param("requestType") String requestType, @Param("litigantType") String litigantType);
}
