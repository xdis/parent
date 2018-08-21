package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.zyxy.common.vo.doc.CaseDocLitigantVO;

/**
 * 变更仲裁申请书
 */
public class ChangeRequestApplyDocVO {
	
	/**
	 * 申请人
	 */
	@ApiModelProperty("申请人")
	private CaseDocLitigantVO proposer;
	
	/**
	 * 被申请人
	 */
	@ApiModelProperty("被申请人")
	private CaseDocLitigantVO defendant;
	
	/**
	 * 请求事项
	 */
	@ApiModelProperty("请求事项")
	private String requestItem;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实与理由")
	private String factReason;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private Date applyTime;

	public CaseDocLitigantVO getProposer() {
		return proposer;
	}

	public void setProposer(CaseDocLitigantVO proposer) {
		this.proposer = proposer;
	}

	public CaseDocLitigantVO getDefendant() {
		return defendant;
	}

	public void setDefendant(CaseDocLitigantVO defendant) {
		this.defendant = defendant;
	}

	public String getRequestItem() {
		return requestItem;
	}

	public void setRequestItem(String requestItem) {
		this.requestItem = requestItem;
	}

	public String getFactReason() {
		return factReason;
	}

	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "ChangeRequestApplyDocVO [proposer=" + proposer + ", defendant="
				+ defendant + ", requestItem=" + requestItem + ", factReason="
				+ factReason + ", applyTime=" + applyTime + "]";
	}
	
}
