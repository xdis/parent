package com.zyxy.common.vo;

/**
 *当事人--案件信息验证 
 *
 */
public class LitigantCaseInfoValidVO {
	/**
	 * 当事人申请人USER_ID
	 */
	private String proposerId;
	/**
	 * 当事人被申请人USER_ID
	 */
	private String defendantId;
	
	/**
	 * 当事人申请人代理人USER_ID
	 */
	private String proposerAgentId;
	
	/**
	 * 当事人被申请人代理人USER_ID
	 */
	private String defendantAgentId;
	
	/**
	 * 案件有效仲秘书
	 */
	private String arbiSecretaryId;
	
	/**
	 * 案件有效仲裁员
	 */
	private String arbitratorId;

	public String getProposerId() {
		return proposerId;
	}

	public void setProposerId(String proposerId) {
		this.proposerId = proposerId;
	}

	public String getDefendantId() {
		return defendantId;
	}

	public void setDefendantId(String defendantId) {
		this.defendantId = defendantId;
	}

	public String getProposerAgentId() {
		return proposerAgentId;
	}

	public void setProposerAgentId(String proposerAgentId) {
		this.proposerAgentId = proposerAgentId;
	}

	public String getDefendantAgentId() {
		return defendantAgentId;
	}

	public void setDefendantAgentId(String defendantAgentId) {
		this.defendantAgentId = defendantAgentId;
	}
	

	public String getArbiSecretaryId() {
		return arbiSecretaryId;
	}

	public void setArbiSecretaryId(String arbiSecretaryId) {
		this.arbiSecretaryId = arbiSecretaryId;
	}

	public String getArbitratorId() {
		return arbitratorId;
	}

	public void setArbitratorId(String arbitratorId) {
		this.arbitratorId = arbitratorId;
	}

	@Override
	public String toString() {
		return "LitigantCaseInfoValidVO [proposerId=" + proposerId
				+ ", defendantId=" + defendantId + ", proposerAgnentId="
				+ proposerAgentId + ", defendantAgentId=" + defendantAgentId
				+ ", arbiSecretaryId=" + arbiSecretaryId + ", arbitratorId="
				+ arbitratorId + "]";
	}
	
	
	
	
	
}
