package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *	证据列表
 */
@ApiModel("证据列表")
public class EvidenceListVO {
	
	@ApiModelProperty("申请方证据")
	private List<EvidenceVO> proposerEvidences;
	
	@ApiModelProperty("被申请方证据")
	private List<EvidenceVO> defendantEvidences;

	/**
	 * @return the proposerEvidences
	 */
	public List<EvidenceVO> getProposerEvidences() {
		return proposerEvidences;
	}

	/**
	 * @param proposerEvidences the proposerEvidences to set
	 */
	public void setProposerEvidences(List<EvidenceVO> proposerEvidences) {
		this.proposerEvidences = proposerEvidences;
	}

	/**
	 * @return the defendantEvidences
	 */
	public List<EvidenceVO> getDefendantEvidences() {
		return defendantEvidences;
	}

	/**
	 * @param defendantEvidences the defendantEvidences to set
	 */
	public void setDefendantEvidences(List<EvidenceVO> defendantEvidences) {
		this.defendantEvidences = defendantEvidences;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EvidenceListVO [proposerEvidences=" + proposerEvidences
				+ ", defendantEvidences=" + defendantEvidences + "]";
	}
	
}
