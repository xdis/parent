package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseDocExample;

import java.util.Date;
import java.util.List;

import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.dto.CaseDocDTO;
import com.zyxy.common.vo.CaseDocVO;
import com.zyxy.common.vo.CaseDocumentsVO;
import com.zyxy.common.vo.DocumentContentVO;

import org.apache.ibatis.annotations.Param;

public interface CaseDocMapper {
    /**
     * case_doc
     * @mbggenerated
     */
    int countByExample(CaseDocExample example);

    /**
     * case_doc
     * @mbggenerated
     */
    int deleteByExample(CaseDocExample example);

    /**
     * case_doc
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_doc
     * @mbggenerated
     */
    int insert(CaseDoc record);

    /**
     * case_doc
     * @mbggenerated
     */
    int insertSelective(CaseDoc record);

    /**
     * case_doc
     * @mbggenerated
     */
    List<CaseDoc> selectByExample(CaseDocExample example);

    /**
     * case_doc
     * @mbggenerated
     */
    CaseDoc selectByPrimaryKey(String id);

    /**
     * case_doc
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseDoc record,
            @Param("example") CaseDocExample example);

    /**
     * case_doc
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseDoc record,
            @Param("example") CaseDocExample example);

    /**
     * case_doc
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseDoc record);

    /**
     * case_doc
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseDoc record);

    /**************手动添加的方法*****************/
    CaseDocVO queryCaseDoc(CaseDocDTO formData);
    
    /**
     * 查询并返回案件文书对象
     * @param caseId 案件id
     * @param docType 文书类型
     * @param status 文书状态
     * @param saveDraft 是否为草稿
     * @return
     */
	DocumentContentVO queryDocuments(@Param("caseId") String caseId,
			@Param("docType") String docType,@Param("status") String status,@Param("saveDraft") String saveDraft);
	

	/**
	 * 根据案件Id查询出回避决定书
	 * @param busiId 业务Id
	 * @param docType 文书类型
	 * @return
	 */
	DocumentContentVO queryCaseDocByBusiId(@Param("busiId") String busiId,@Param("docType") String docType);

	/**
	 * 根据案件id和文书类型，查询文书内容、请求信息
	 * @param caseDocDTO 
	 * @return
	 */
	CaseDocumentsVO selectCaseDoc(CaseDocDTO caseDocDTO);
	
	/**
	 *  仲裁委查询并返回裁决书案件文书对象
	 * @param busiId 审批Id
	 * @param saveDraft 是否为草稿
	 * @return
	 */
	CaseDocVO queryCaseDocbusiId(@Param("busiId") String busiId,@Param("saveDraft") String saveDraft);
	
    /**
     * 查询审批id(主任/副主任驳回仍需审批并且仍在进行中的相关审批)
     * @param caseId 案件id
     * @param docType 文书类型
     * @return 文书id
     */
    String queryCaseDocId(@Param("caseId")String caseId,@Param("docType")String docType);


	/**
	 * g
	 * @param avoidUserId
	 * @return
	 */
	Date selectTimeByUserId(@Param("avoidUserId")String avoidUserId);

	/**
	 * 根据案件id和文书类型查询出文书
	 * @param caseId
	 * @param docType
	 * @return
	 */
	DocumentContentVO selectCaseJurisDisByCaseIdAndDocType(@Param("caseId")String caseId,@Param("docType") String docType);

	DocumentContentVO selectDocumentByBussId(@Param("busiId") String busiId);


	/**
	 * 根据案件id和文书类型获取合同协议相关数据
	 * @param caseDocDTO
	 * @return
	 */
	CaseInfo queryCaseInfo(CaseDocDTO caseDocDTO);
	
	/**
	 * 通过审批id查询文书内容
	 * @param approveId 审批id
	 * @return 文书内容
	 */
	CaseDoc queryCaseDocByApproveId(String approveId);
	
	/**
	 * 通过请求id，文书类型查询有效文书
	 * @param requestId 请求id
	 * @param docType 文书类型
	 * @return 有效文书
	 */
	CaseDoc queryValidDocByRequestIdAndDocType(@Param("requestId")String requestId,@Param("docType")String docType);
}