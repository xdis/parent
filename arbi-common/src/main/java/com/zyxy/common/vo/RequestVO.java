package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 请求列表VO
 */
@ApiModel("请求列表VO")
public class RequestVO {
	
	private List<RequestListVO> requestVO;
	
	private ReplyButtonVO replyButton;
	
	private ReplyButtonVO changeReplyButton;

	public List<RequestListVO> getRequestVO() {
		return requestVO;
	}

	public void setRequestVO(List<RequestListVO> requestVO) {
		this.requestVO = requestVO;
	}

	public ReplyButtonVO getReplyButton() {
		return replyButton;
	}

	public void setReplyButton(ReplyButtonVO replyButton) {
		this.replyButton = replyButton;
	}

	public ReplyButtonVO getChangeReplyButton() {
		return changeReplyButton;
	}

	public void setChangeReplyButton(ReplyButtonVO changeReplyButton) {
		this.changeReplyButton = changeReplyButton;
	}

	@Override
	public String toString() {
		return "RequestVO [requestVO=" + requestVO + ", replyButton="
				+ replyButton + ", changeReplyButton=" + changeReplyButton
				+ "]";
	}

	
	
}
