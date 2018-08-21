package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 *   和解记录VO
 */
@ApiModel(value ="和解记录VO")
public class CaseArbitrationInfoVO {
    /**
     *   撤案决定书
     */
    @ApiModelProperty(value = "撤案决定书")
    private List<CaseWithdrawDecisionVO> caseWithdrawDecisions;

    /**
     *   和解沟通记录
     */
    @ApiModelProperty(value = "和解沟通记录")
    private List<CaseCompromiseRecordVO> caseCompromiseRecords;

    /**
     *   仲裁答辩
     */
    @ApiModelProperty(value = "仲裁答辩")
    private List<CaseQuizRecordVO> caseQuizRecords;

    public List<CaseWithdrawDecisionVO> getCaseWithdrawDecisions() {
        return caseWithdrawDecisions;
    }

    public void setCaseWithdrawDecisions(List<CaseWithdrawDecisionVO> caseWithdrawDecisions) {
        this.caseWithdrawDecisions = caseWithdrawDecisions;
    }

    public List<CaseCompromiseRecordVO> getCaseCompromiseRecords() {
        return caseCompromiseRecords;
    }

    public void setCaseCompromiseRecords(List<CaseCompromiseRecordVO> caseCompromiseRecords) {
        this.caseCompromiseRecords = caseCompromiseRecords;
    }

    public List<CaseQuizRecordVO> getCaseQuizRecords() {
        return caseQuizRecords;
    }

    public void setCaseQuizRecords(List<CaseQuizRecordVO> caseQuizRecords) {
        this.caseQuizRecords = caseQuizRecords;
    }
}