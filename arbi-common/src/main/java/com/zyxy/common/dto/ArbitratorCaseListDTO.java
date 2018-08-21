package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * 当事人
 */
@ApiModel(value ="当事人案件列表对象")
public class ArbitratorCaseListDTO extends BasePageDTO {

    /**
     * 搜索关键字
     */
    @ApiModelProperty("搜索关键字")
    private String searchKeyWord;

    /**
     * 状态
     */
    @ApiModelProperty("状态,0- 待提交, 1- 和解中, 2- 答辩中, 3- 裁决中, 4- 已结案，5- 补正")
    private String status;

    /**
     * 被邀请时间开始
     */
    @ApiModelProperty("被邀请时间开始")
    @Pattern(regexp = RegexpConstant.DATE_REGEX)
    private String beInviteDateStart;

    /**
     * 被邀请时间结束
     */
    @ApiModelProperty("被邀请时间结束")
    @Pattern(regexp = RegexpConstant.DATE_REGEX)
    private String beInviteDateEnd;

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public String getBeInviteDateStart() {
        return beInviteDateStart;
    }

    public void setBeInviteDateStart(String beInviteDateStart) {
        this.beInviteDateStart = beInviteDateStart;
    }

    public String getBeInviteDateEnd() {
        return beInviteDateEnd;
    }

    public void setBeInviteDateEnd(String beInviteDateEnd) {
        this.beInviteDateEnd = beInviteDateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
