package com.zyxy.admin.service;

import com.zyxy.common.dto.CaseJurisDisDTO;
import com.zyxy.common.dto.SaveCaseDocDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitrationCaseJurisDisVO;

/**
 * 管辖权异议service
 */
public interface CaseJurisDisService {

    /**
     * 查询管辖权异议审核业务处理
     * @param jurisApproveId
     * @param userId
     * @return
     */
    BusiExecuteResult<ArbitrationCaseJurisDisVO> queryCaseJurisDisByCaseIdBusiExecute(String jurisApproveId,String userId);


    /**
     * 查询管辖权异议审核业务验证
     * @param jurisApproveId
     * @param userId
     * @return
     */
    BusiValidResult queryCaseJurisDisByCaseIdBusiValid(String jurisApproveId,String userId);

    


    
    /**
     * 保存仲裁协议效力决定书业务验证
     * @param formData
     * @return
     */
    BusiValidResult saveDocAndDocContentBusiValidResult(SaveCaseDocDTO formData);
    
    /**
     * 保存仲裁协议效力决定书业务处理
     * @param formData
     * @return
     */
    BusiExecuteResult saveDocAndDocContentBusiExecuteResult(SaveCaseDocDTO formData);
    
}
