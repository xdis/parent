package com.zyxy.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyxy.common.domain.CaseDocContent;
import com.zyxy.common.domain.CaseDocContentExample;
import com.zyxy.common.domain.CaseDocContentWithBLOBs;
import com.zyxy.common.dto.ArbitrationCaseDecisionHandleDTO;
import com.zyxy.common.vo.ArbitrationCaseDecisionVO;
import com.zyxy.common.vo.CaseDocContentVO;

public interface CaseDocContentMapper {
    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int countByExample(CaseDocContentExample example);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int deleteByExample(CaseDocContentExample example);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int insert(CaseDocContentWithBLOBs record);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int insertSelective(CaseDocContentWithBLOBs record);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    List<CaseDocContentWithBLOBs> selectByExampleWithBLOBs(CaseDocContentExample example);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    List<CaseDocContent> selectByExample(CaseDocContentExample example);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    CaseDocContentWithBLOBs selectByPrimaryKey(String id);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseDocContentWithBLOBs record, @Param("example") CaseDocContentExample example);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") CaseDocContentWithBLOBs record, @Param("example") CaseDocContentExample example);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseDocContent record, @Param("example") CaseDocContentExample example);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseDocContentWithBLOBs record);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(CaseDocContentWithBLOBs record);

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseDocContent record);
	
    /**
     * 根据案件id查询
     */
    CaseDocContent selectCaseDocContentByCaseId(String caseId);
    
	/**
	 * 按照案件id统计有效的撤案决定书(正/反请求)的数量
	 * @param caseId 案件id
	 * @param docType 文书类型
	 * @return 文书数量
	 */
	int decisionBookNum(@Param("caseId")String caseId,@Param("docType")String docType);
	
	/**
	 * 更新文书内容
	 * @param record 文书内容
	 * @return 更新结果
	 */
	int updateCaseDocContentByDocId(CaseDocContentWithBLOBs record);
	
	/**
	 * 查询当前审批的文书的id(驳回需再次审批的)
	 * @param caseId 案件id
	 * @param approveType 审批类型
	 * @return 文书id
	 */
	String queryApprovingDocId(@Param("caseId")String caseId,@Param("approveType")String approveType);
	
	/**
	 * 查询决定书内容
	 * @param caseId 案件id
	 * @param docType 文书类型
	 * @return 决定书内容
	 */
	ArbitrationCaseDecisionVO queryCaseDecisionContent(@Param("caseId")String caseId,@Param("docType")String docType);
	
	/**
	 * 通过文书ID查询文书内容
	 * @param docId 文书id
	 * @return 文书出具类型
	 */
	CaseDocContentVO queryDocContentByDocId(String docId);

    /**
     * 根据案件Id及类型查询文书内容
     *
     * @param caseId  案件Id
     * @param docType 文书类型
     * @return
     */
    CaseDocContentWithBLOBs queryCaseDocContentByCaseIdAndDocType(@Param("caseId") String caseId, @Param("docType") String docType);
    
    /**
     * 通过busi_id查询文书的出具类型
     * @param busiId 业务id
     * @return 文书出具类型
     */
    String queryValidDocIssueTypeByBusiId(String busiId);
    
    /**
     * 查询审批通过并出具文书的类型为同意模板的审批的业务id
     * @param caseId 案件id
     * @param approveType 审批类型
     * @return 
     */
    String queryApprovePassAndIssueTypeIsPassApproval(@Param("caseId")String caseId,@Param("approveType")String approveType);
}
