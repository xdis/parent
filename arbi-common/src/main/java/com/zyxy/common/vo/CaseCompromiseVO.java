package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 案件和解信息
 */
@ApiModel("案件和解信息")
public class CaseCompromiseVO {

    /**
     * 状态,0- 无和解申请,1- 和解申请秘书审核中,2- 和解申请仲裁员审核中,3- 等待开始和解,4- 和解完成
     */
    @ApiModelProperty("状态,0- 无和解申请,1- 和解申请秘书审核中,2- 和解申请仲裁员审核中,3- 等待开始和解,4- 和解完成")
    private String status;

    /**
     * 和解沟通记录
     */
    @ApiModelProperty("和解沟通记录")
    private List<ArgueRecordVO> record;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ArgueRecordVO> getRecord() {
        return record;
    }

    public void setRecord(List<ArgueRecordVO> record) {
        this.record = record;
    }
}
