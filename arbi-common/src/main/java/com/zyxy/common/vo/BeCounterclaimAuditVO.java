package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
/**
 * 反请求审核信息对象
 */
@ApiModel(value="反请求审核信息对象")
public class BeCounterclaimAuditVO{
	
	/**
     * 案件当事人基本信息对象
     */
    @ApiModelProperty("案件基本信息对象")
    private ArbitratorCaseBaseInfoVO  arbitratorCaseBaseInfoVO ;
    
    /**
     * 案件审核公共对象 
     */
    @ApiModelProperty("案件审核公共对象")
    private AuditPublicVO  auditPublicVO ;
    
	
	public ArbitratorCaseBaseInfoVO getArbitratorCaseBaseInfoVO() {
		return arbitratorCaseBaseInfoVO;
	}

	public void setArbitratorCaseBaseInfoVO(
			ArbitratorCaseBaseInfoVO arbitratorCaseBaseInfoVO) {
		this.arbitratorCaseBaseInfoVO = arbitratorCaseBaseInfoVO;
	}

	public AuditPublicVO getAuditPublicVO() {
		return auditPublicVO;
	}

	public void setAuditPublicVO(AuditPublicVO auditPublicVO) {
		this.auditPublicVO = auditPublicVO;
	}
	
	

    
}
