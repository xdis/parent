package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 和解信息输出(按钮，和解申请，调节协议申请信息)
 */
public class CompromiseInfoVO {
	
	/**
	 * 和解按钮
	 */
	@ApiModelProperty("和解按钮")
	private CompromiseMenuVO compromiseMenuVO;
	
	/**
	 * 协议申请
	 */
	@ApiModelProperty("和解按钮")
	private ProtocolInfoVO protocolInfoVO;
	
	/**
	 * 和解申请
	 */
	@ApiModelProperty("和解申请")
	private List<CompromiseApplyInfoVO> applyInfoVOs;

	public CompromiseMenuVO getCompromiseMenuVO() {
		return compromiseMenuVO;
	}

	public void setCompromiseMenuVO(CompromiseMenuVO compromiseMenuVO) {
		this.compromiseMenuVO = compromiseMenuVO;
	}

	public ProtocolInfoVO getProtocolInfoVO() {
		return protocolInfoVO;
	}

	public void setProtocolInfoVO(ProtocolInfoVO protocolInfoVO) {
		this.protocolInfoVO = protocolInfoVO;
	}

	public List<CompromiseApplyInfoVO> getApplyInfoVOs() {
		return applyInfoVOs;
	}

	public void setApplyInfoVOs(List<CompromiseApplyInfoVO> applyInfoVOs) {
		this.applyInfoVOs = applyInfoVOs;
	}

	@Override
	public String toString() {
		return "CompromiseInfoVO [compromiseMenuVO=" + compromiseMenuVO
				+ ", protocolInfoVO=" + protocolInfoVO + ", applyInfoVOs="
				+ applyInfoVOs + "]";
	}
	
}
