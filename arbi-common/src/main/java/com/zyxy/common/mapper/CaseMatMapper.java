package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseMat;
import com.zyxy.common.domain.CaseMatExample;

import java.util.List;

import com.zyxy.common.dto.CaseAttachmentDTO;
import com.zyxy.common.dto.CaseEvidenceDTO;
import com.zyxy.common.vo.AttachVO;
import com.zyxy.common.vo.CaseEvidenceVO;
import com.zyxy.common.vo.EvidenceVO;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import com.zyxy.common.domain.CaseMatWithBLOBs;

public interface CaseMatMapper {
    /**
     * case_mat
     * @mbggenerated
     */
    int countByExample(CaseMatExample example);
    /**
     * case_mat
     * @mbggenerated
     */
    int deleteByExample(CaseMatExample example);
    /**
     * case_mat
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);
    /**
     * case_mat
     * @mbggenerated
     */
    int insert(CaseMatWithBLOBs record);
    /**
     * case_mat
     * @mbggenerated
     */
    int insertSelective(CaseMatWithBLOBs record);
    /**
     * case_mat
     * @mbggenerated
     */
    List<CaseMatWithBLOBs> selectByExampleWithBLOBs(CaseMatExample example);
    /**
     * case_mat
     * @mbggenerated
     */
    List<CaseMat> selectByExample(CaseMatExample example);
    /**
     * case_mat
     * @mbggenerated
     */
    CaseMatWithBLOBs selectByPrimaryKey(String id);
    /**
     * case_mat
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseMatWithBLOBs record,
            @Param("example") CaseMatExample example);
    /**
     * case_mat
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") CaseMatWithBLOBs record,
            @Param("example") CaseMatExample example);
    /**
     * case_mat
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseMat record,
            @Param("example") CaseMatExample example);
    /**
     * case_mat
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseMatWithBLOBs record);
    /**
     * case_mat
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(CaseMatWithBLOBs record);
    /**
     * case_mat
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseMat record);
    int insertEvidence(@Param("list") List<CaseEvidenceDTO> list, @Param("requestType")String requestType, @Param("caseId") String caseId, @Param("requestId") String requestId,@Param("createrType") String createrType);
    int insertAttachment(@Param("list") List<CaseAttachmentDTO> list, @Param("requestType")String requestType, @Param("caseId") String caseId, @Param("requestId") String requestId);

    /**
     * 证据清单
     * @param caseMat 参数材料类型 请求类型 案件Id
     * @return
     */
    List<EvidenceVO> selectByEvidenceExample(CaseMat caseMat);
    
    /**
     * 插入证据
     * @param list
     * @param requestType
     * @param caseId
     * @param requestId
     * @param matType
     * @param createrType
     * @return
     */
    int insertRejionEvidence(@Param("list") List<CaseEvidenceDTO> list, @Param("requestType")String requestType, 
    		@Param("caseId") String caseId, @Param("requestId") String requestId,
    		@Param("matType") String matType,@Param("createrType") String createrType);

    /**
     * 根据案件ID和证据来源类型查询证据
     * @param caseId
     * @param createrType
     * @return
     */
    List<EvidenceVO> selectEvidencesParam(@Param("caseId") String caseId,
    		@Param("createrType") String createrType);
    
    
    /**
     * 根据审批id查询证据清单
     * @param approveId 案件Id
     * @return
     */
    List<EvidenceVO> selectEvidenceList(@Param("approveId") String approveId);
    
    /**
     * 查询当前案件举证Id
     * @param caseId 案件If
     * @return
     */
    List<EvidenceVO> selectproofEvidenceList(@Param("caseId") String caseId);
    
    
}