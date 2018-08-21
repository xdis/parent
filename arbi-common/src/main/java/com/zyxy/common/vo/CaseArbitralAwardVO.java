package com.zyxy.common.vo;

import com.zyxy.common.vo.doc.CaseDocHeadVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 案件裁决书内容
 */
@ApiModel(value = "案件裁决书内容")
public class CaseArbitralAwardVO {

    /**
     * 案件当事人及代理人信息
     */
    @ApiModelProperty("案件当事人及代理人信息")
    private CaseDocHeadVO caseDocHead;

    /**
     * 案号
     */
    @ApiModelProperty("案号")
    private String caseNo;

    /**
     * 仲裁协议签订方式，0- 合同约定仲裁条款，1- 单独仲裁协议
     */
    @ApiModelProperty("仲裁协议签订方式，0- 合同约定仲裁条款，1- 单独仲裁协议")
    private String protocolMode;

    /**
     * 仲裁协议签订时间
     */
    @ApiModelProperty("仲裁协议签订时间")
    private Date signTime;

    /**
     * 案件受理时间
     */
    @ApiModelProperty("案件受理时间")
    private Date caseAcceptanceTime;

    /**
     * 合同名称
     */
    @ApiModelProperty("合同名称")
    private String protocolName;

    /**
     * 案由
     */
    @ApiModelProperty("案由")
    private String caseType;

    /**
     * 仲裁员选定类型,1- 当事人指定,0- 系统指派/主任指定
     */
    @ApiModelProperty("仲裁员选定类型,1- 当事人指定,0- 系统指派/主任指定")
    private String arbitratorType;

    /**
     * 组庭时间
     */
    @ApiModelProperty("组庭时间")
    private Date arbitratorGroupTime;

    /**
     * 仲裁员名称
     */
    @ApiModelProperty("仲裁员名称")
    private String arbitratorName;

    /**
     * 本请求仲裁请求
     */
    @ApiModelProperty("本请求仲裁请求")
    private String requestArbClaim;

    /**
     * 本请求事实与理由
     */
    @ApiModelProperty("本请求事实与理由")
    private String requestFact;

    /**
     * 本请求答辩内容
     */
    @ApiModelProperty("本请求答辩内容")
    private String requestReply;

    /**
     * 本请求是否有仲裁请求变更
     */
    @ApiModelProperty("本请求是否有仲裁请求变更")
    private boolean requestChange;

    /**
     * 本请求仲裁请求变更时间
     */
    @ApiModelProperty("本请求仲裁请求变更时间")
    private Date requestChangeTime;

    /**
     * 本请求仲裁请求变更请求
     */
    @ApiModelProperty("本请求仲裁请求变更请求")
    private String requestChangeRequest;

    /**
     * 本请求仲裁请求变更事实与理由
     */
    @ApiModelProperty("本请求仲裁请求变更事实与理由")
    private String requestChangeFactReason;

    /**
     * 本请求仲裁请求变更答辩内容
     */
    @ApiModelProperty("本请求仲裁请求变更答辩内容")
    private String requestChangeReply;

    /**
     * 是否有反请求
     */
    @ApiModelProperty("是否有反请求")
    private boolean haveBackRequest;

    /**
     * 反请求仲裁请求
     */
    @ApiModelProperty("反请求仲裁请求")
    private String backRequestArbClaim;

    /**
     * 反请求事实与理由
     */
    @ApiModelProperty("反请求事实与理由")
    private String backRequestFact;

    /**
     * 反请求答辩内容
     */
    @ApiModelProperty("反请求答辩内容")
    private String backRequestReply;

    /**
     * 反请求是否有仲裁请求变更
     */
    @ApiModelProperty("反请求是否有仲裁请求变更")
    private boolean backRequestChange;

    /**
     * 反请求仲裁请求变更时间
     */
    @ApiModelProperty("反请求仲裁请求变更时间")
    private Date backRequestChangeTime;

    /**
     * 反请求仲裁请求变更请求
     */
    @ApiModelProperty("反请求仲裁请求变更请求")
    private String backRequestChangeRequest;

    /**
     * 反请求仲裁请求变更事实与理由
     */
    @ApiModelProperty("反请求仲裁请求变更事实与理由")
    private String backRequestChangeFactReason;

    /**
     * 反请求仲裁请求变更答辩内容
     */
    @ApiModelProperty("反请求仲裁请求变更答辩内容")
    private String backRequestChangeReply;

    /**
     * 申请人是否举证
     */
    @ApiModelProperty("申请人是否举证")
    private boolean applicantProof;

    /**
     * 申请人举证证据
     */
    @ApiModelProperty("申请人举证证据")
    private String applicantProofMat;

    /**
     * 申请人举证质证意见
     */
    @ApiModelProperty("申请人举证质证意见")
    private String applicantProofOppugn;

    /**
     * 被申请人是否举证
     */
    @ApiModelProperty("被申请人是否举证")
    private boolean beApplicantProof;

    /**
     * 被申请人举证证据
     */
    @ApiModelProperty("被申请人举证证据")
    private String beApplicantProofMat;

    /**
     * 被申请人举证质证意见
     */
    @ApiModelProperty("被申请人举证质证意见")
    private String beApplicantProofOppugn;

    /**
     * 事实认定
     */
    @ApiModelProperty("事实认定")
    private String factFinding;

    /**
     * 仲裁庭意见
     */
    @ApiModelProperty("仲裁庭意见")
    private String arbitralTribunalOpinion;

    /**
     * 最终决定
     */
    @ApiModelProperty("最终决定")
    private String finalDecision;

    /**
     * 落款日期
     */
    @ApiModelProperty("落款日期")
    private Date badgingDate;

    /**
     * 秘书
     */
    @ApiModelProperty("秘书")
    private String secretaryName;

    public CaseDocHeadVO getCaseDocHead() {
        return caseDocHead;
    }

    public void setCaseDocHead(CaseDocHeadVO caseDocHead) {
        this.caseDocHead = caseDocHead;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getProtocolMode() {
        return protocolMode;
    }

    public void setProtocolMode(String protocolMode) {
        this.protocolMode = protocolMode;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Date getCaseAcceptanceTime() {
        return caseAcceptanceTime;
    }

    public void setCaseAcceptanceTime(Date caseAcceptanceTime) {
        this.caseAcceptanceTime = caseAcceptanceTime;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getArbitratorType() {
        return arbitratorType;
    }

    public void setArbitratorType(String arbitratorType) {
        this.arbitratorType = arbitratorType;
    }

    public Date getArbitratorGroupTime() {
        return arbitratorGroupTime;
    }

    public void setArbitratorGroupTime(Date arbitratorGroupTime) {
        this.arbitratorGroupTime = arbitratorGroupTime;
    }

    public String getArbitratorName() {
        return arbitratorName;
    }

    public void setArbitratorName(String arbitratorName) {
        this.arbitratorName = arbitratorName;
    }

    public String getRequestArbClaim() {
        return requestArbClaim;
    }

    public void setRequestArbClaim(String requestArbClaim) {
        this.requestArbClaim = requestArbClaim;
    }

    public String getRequestFact() {
        return requestFact;
    }

    public void setRequestFact(String requestFact) {
        this.requestFact = requestFact;
    }

    public String getRequestReply() {
        return requestReply;
    }

    public void setRequestReply(String requestReply) {
        this.requestReply = requestReply;
    }

    public boolean isRequestChange() {
        return requestChange;
    }

    public void setRequestChange(boolean requestChange) {
        this.requestChange = requestChange;
    }

    public Date getRequestChangeTime() {
        return requestChangeTime;
    }

    public void setRequestChangeTime(Date requestChangeTime) {
        this.requestChangeTime = requestChangeTime;
    }

    public String getRequestChangeRequest() {
        return requestChangeRequest;
    }

    public void setRequestChangeRequest(String requestChangeRequest) {
        this.requestChangeRequest = requestChangeRequest;
    }

    public String getRequestChangeFactReason() {
        return requestChangeFactReason;
    }

    public void setRequestChangeFactReason(String requestChangeFactReason) {
        this.requestChangeFactReason = requestChangeFactReason;
    }

    public String getRequestChangeReply() {
        return requestChangeReply;
    }

    public void setRequestChangeReply(String requestChangeReply) {
        this.requestChangeReply = requestChangeReply;
    }

    public boolean isHaveBackRequest() {
        return haveBackRequest;
    }

    public void setHaveBackRequest(boolean haveBackRequest) {
        this.haveBackRequest = haveBackRequest;
    }

    public String getBackRequestArbClaim() {
        return backRequestArbClaim;
    }

    public void setBackRequestArbClaim(String backRequestArbClaim) {
        this.backRequestArbClaim = backRequestArbClaim;
    }

    public String getBackRequestFact() {
        return backRequestFact;
    }

    public void setBackRequestFact(String backRequestFact) {
        this.backRequestFact = backRequestFact;
    }

    public String getBackRequestReply() {
        return backRequestReply;
    }

    public void setBackRequestReply(String backRequestReply) {
        this.backRequestReply = backRequestReply;
    }

    public boolean isBackRequestChange() {
        return backRequestChange;
    }

    public void setBackRequestChange(boolean backRequestChange) {
        this.backRequestChange = backRequestChange;
    }

    public Date getBackRequestChangeTime() {
        return backRequestChangeTime;
    }

    public void setBackRequestChangeTime(Date backRequestChangeTime) {
        this.backRequestChangeTime = backRequestChangeTime;
    }

    public String getBackRequestChangeRequest() {
        return backRequestChangeRequest;
    }

    public void setBackRequestChangeRequest(String backRequestChangeRequest) {
        this.backRequestChangeRequest = backRequestChangeRequest;
    }

    public String getBackRequestChangeFactReason() {
        return backRequestChangeFactReason;
    }

    public void setBackRequestChangeFactReason(String backRequestChangeFactReason) {
        this.backRequestChangeFactReason = backRequestChangeFactReason;
    }

    public String getBackRequestChangeReply() {
        return backRequestChangeReply;
    }

    public void setBackRequestChangeReply(String backRequestChangeReply) {
        this.backRequestChangeReply = backRequestChangeReply;
    }

    public boolean isApplicantProof() {
        return applicantProof;
    }

    public void setApplicantProof(boolean applicantProof) {
        this.applicantProof = applicantProof;
    }

    public String getApplicantProofMat() {
        return applicantProofMat;
    }

    public void setApplicantProofMat(String applicantProofMat) {
        this.applicantProofMat = applicantProofMat;
    }

    public String getApplicantProofOppugn() {
        return applicantProofOppugn;
    }

    public void setApplicantProofOppugn(String applicantProofOppugn) {
        this.applicantProofOppugn = applicantProofOppugn;
    }

    public boolean isBeApplicantProof() {
        return beApplicantProof;
    }

    public void setBeApplicantProof(boolean beApplicantProof) {
        this.beApplicantProof = beApplicantProof;
    }

    public String getBeApplicantProofMat() {
        return beApplicantProofMat;
    }

    public void setBeApplicantProofMat(String beApplicantProofMat) {
        this.beApplicantProofMat = beApplicantProofMat;
    }

    public String getBeApplicantProofOppugn() {
        return beApplicantProofOppugn;
    }

    public void setBeApplicantProofOppugn(String beApplicantProofOppugn) {
        this.beApplicantProofOppugn = beApplicantProofOppugn;
    }

    public String getFactFinding() {
        return factFinding;
    }

    public void setFactFinding(String factFinding) {
        this.factFinding = factFinding;
    }

    public String getArbitralTribunalOpinion() {
        return arbitralTribunalOpinion;
    }

    public void setArbitralTribunalOpinion(String arbitralTribunalOpinion) {
        this.arbitralTribunalOpinion = arbitralTribunalOpinion;
    }

    public String getFinalDecision() {
        return finalDecision;
    }

    public void setFinalDecision(String finalDecision) {
        this.finalDecision = finalDecision;
    }

    public Date getBadgingDate() {
        return badgingDate;
    }

    public void setBadgingDate(Date badgingDate) {
        this.badgingDate = badgingDate;
    }

    public String getSecretaryName() {
        return secretaryName;
    }

    public void setSecretaryName(String secretaryName) {
        this.secretaryName = secretaryName;
    }
}
