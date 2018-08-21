package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 案件文书对象
 */
@ApiModel(value="案件文书")
public class CaseDocumentsVO {
	@ApiModelProperty(value="文书名")
    private String docName;
	
	@ApiModelProperty(value="文书年编号")
    private String docYearNumber;
	
	@ApiModelProperty(value="文书序列号")
    private String docSerialNumber;
	
	@ApiModelProperty(value="文书类型")
    private String docType;
	
	@ApiModelProperty(value = "正文")
    private String bodyText;
	
	@ApiModelProperty(value = "意见")
    private String opinion;
	
	@ApiModelProperty(value = "最终决定")
    private String finalDecision;
	
	@ApiModelProperty(value = "出具时间")
    private Date issusTime;
	
	@ApiModelProperty(value = "秘书名称")
    private String secretaryName;
	
	@ApiModelProperty(value = "仲裁员名称")
    private String arbitratorName;
	
	@ApiModelProperty("案件仲裁员类型，0-指派，1-选定")
	private String caseArbiType;
	
	@ApiModelProperty(value = "仲裁请求")
    private String arbClaim;
	
	@ApiModelProperty(value = "事实")
    private String fact;
	
	@ApiModelProperty(value = "理由")
    private String reason;
	
	@ApiModelProperty(value = "受理费")
    private BigDecimal caseAdmissibleAmount;
	
	@ApiModelProperty(value = "处理费")
    private BigDecimal caseHandlingAmount;
	
	@ApiModelProperty(value="申请人姓名")
    private String propName;

    @ApiModelProperty(value="申请人性别")
    private String propSex;
    
    @ApiModelProperty(value="申请人民族")
    private String propEthnic;

    @ApiModelProperty(value="申请人地址")
    private String propAddress;

    @ApiModelProperty(value="申请人身份证")
    private String propCardId;
    
    @ApiModelProperty(value="申请人出生日期")
    private String propBirthday;
    
    @ApiModelProperty(value="申请人法人名称")
    private String propCertName;
    
    @ApiModelProperty(value="申请人法人职务")
    private String propCertDuties;
    
    @ApiModelProperty(value="申请人类型。0- 个人，1- 企业")
    private String propType;
    
    @ApiModelProperty(value="被申请人姓名")
    private String depeName;

    @ApiModelProperty(value="被申请人性别")
    private String depeSex;

    @ApiModelProperty(value="被申请人民族")
    private String depeEthnic;

    @ApiModelProperty(value="被申请人地址")
    private String depeAddress;

    @ApiModelProperty(value="被申请人身份证")
    private String depeCardId;
    
    @ApiModelProperty(value="被请人出生日期")
    private String depeBirthday;
    
    @ApiModelProperty(value="被申请人法人名称")
    private String depeCertName;
    
    @ApiModelProperty(value="被申请人法人职务")
    private String depeCertDuties;
    
    @ApiModelProperty(value="被申请人类型。0- 个人，1- 企业")
    private String deptType;

	public String getArbClaim() {
		return arbClaim;
	}

	public void setArbClaim(String arbClaim) {
		this.arbClaim = arbClaim;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getIssusTime() {
		return issusTime;
	}

	public void setIssusTime(Date issusTime) {
		this.issusTime = issusTime;
	}

	public String getSecretaryName() {
		return secretaryName;
	}

	public void setSecretaryName(String secretaryName) {
		this.secretaryName = secretaryName;
	}

	public String getArbitratorName() {
		return arbitratorName;
	}

	public void setArbitratorName(String arbitratorName) {
		this.arbitratorName = arbitratorName;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getFinalDecision() {
		return finalDecision;
	}

	public void setFinalDecision(String finalDecision) {
		this.finalDecision = finalDecision;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocYearNumber() {
		return docYearNumber;
	}

	public void setDocYearNumber(String docYearNumber) {
		this.docYearNumber = docYearNumber;
	}

	public String getDocSerialNumber() {
		return docSerialNumber;
	}

	public void setDocSerialNumber(String docSerialNumber) {
		this.docSerialNumber = docSerialNumber;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropSex() {
		return propSex;
	}

	public void setPropSex(String propSex) {
		this.propSex = propSex;
	}

	public String getPropEthnic() {
		return propEthnic;
	}

	public void setPropEthnic(String propEthnic) {
		this.propEthnic = propEthnic;
	}

	public String getPropAddress() {
		return propAddress;
	}

	public void setPropAddress(String propAddress) {
		this.propAddress = propAddress;
	}

	public String getPropCardId() {
		return propCardId;
	}

	public void setPropCardId(String propCardId) {
		this.propCardId = propCardId;
	}

	public String getDepeName() {
		return depeName;
	}

	public void setDepeName(String depeName) {
		this.depeName = depeName;
	}

	public String getDepeSex() {
		return depeSex;
	}

	public void setDepeSex(String depeSex) {
		this.depeSex = depeSex;
	}

	public String getDepeEthnic() {
		return depeEthnic;
	}

	public void setDepeEthnic(String depeEthnic) {
		this.depeEthnic = depeEthnic;
	}

	public String getDepeAddress() {
		return depeAddress;
	}

	public void setDepeAddress(String depeAddress) {
		this.depeAddress = depeAddress;
	}

	public String getDepeCardId() {
		return depeCardId;
	}

	public void setDepeCardId(String depeCardId) {
		this.depeCardId = depeCardId;
	}

	public String getPropCertName() {
		return propCertName;
	}

	public void setPropCertName(String propCertName) {
		this.propCertName = propCertName;
	}

	public String getPropCertDuties() {
		return propCertDuties;
	}

	public void setPropCertDuties(String propCertDuties) {
		this.propCertDuties = propCertDuties;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	public String getDepeCertName() {
		return depeCertName;
	}

	public void setDepeCertName(String depeCertName) {
		this.depeCertName = depeCertName;
	}

	public String getDepeCertDuties() {
		return depeCertDuties;
	}

	public void setDepeCertDuties(String depeCertDuties) {
		this.depeCertDuties = depeCertDuties;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getPropBirthday() {
		return propBirthday;
	}

	public void setPropBirthday(String propBirthday) {
		this.propBirthday = propBirthday;
	}

	public String getDepeBirthday() {
		return depeBirthday;
	}

	public void setDepeBirthday(String depeBirthday) {
		this.depeBirthday = depeBirthday;
	}

	public String getCaseArbiType() {
		return caseArbiType;
	}

	public void setCaseArbiType(String caseArbiType) {
		this.caseArbiType = caseArbiType;
	}

	public BigDecimal getCaseAdmissibleAmount() {
		return caseAdmissibleAmount;
	}

	public void setCaseAdmissibleAmount(BigDecimal caseAdmissibleAmount) {
		this.caseAdmissibleAmount = caseAdmissibleAmount;
	}

	public BigDecimal getCaseHandlingAmount() {
		return caseHandlingAmount;
	}

	public void setCaseHandlingAmount(BigDecimal caseHandlingAmount) {
		this.caseHandlingAmount = caseHandlingAmount;
	}
}
