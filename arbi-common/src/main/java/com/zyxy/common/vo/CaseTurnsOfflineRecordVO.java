package com.zyxy.common.vo;

import java.util.List;

import com.zyxy.common.domain.CaseTurnsOfflineRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *	案件转线下VO
 */
@ApiModel(value="案件转线下VO")
public class CaseTurnsOfflineRecordVO {
	/**
     * 案件转线下记录信息
     */
    @ApiModelProperty("案件转线下记录信息")
    private CaseTurnsOfflineRecord caseTurnsOfflineRecord;
    
    /**
     * 案件转线下创建人姓名
     */
    @ApiModelProperty("创建人姓名")
    private String createrName;
    
    /**
     * 当前登录人职务
     */
    @ApiModelProperty("当前登录人职务")
    private String duties;
    
    /**
     * 审批意见记录列表
     */
    @ApiModelProperty("审批意见记录列表")
    private List<ApproveRecordVO> approveRecorList;

	public CaseTurnsOfflineRecord getCaseTurnsOfflineRecord() {
		return caseTurnsOfflineRecord;
	}

	public void setCaseTurnsOfflineRecord(
			CaseTurnsOfflineRecord caseTurnsOfflineRecord) {
		this.caseTurnsOfflineRecord = caseTurnsOfflineRecord;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public List<ApproveRecordVO> getApproveRecorList() {
		return approveRecorList;
	}

	public void setApproveRecorList(List<ApproveRecordVO> approveRecorList) {
		this.approveRecorList = approveRecorList;
	}
}
