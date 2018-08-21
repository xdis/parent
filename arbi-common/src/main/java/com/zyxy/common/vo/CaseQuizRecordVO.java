package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *   提问记录VO
 */
@ApiModel(value ="提问记录VO")
public class CaseQuizRecordVO {
    /**
     *   编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     *   问题内容
     */
    @ApiModelProperty("问题内容")
    private String quizContent;

    /**
     *   回答内容
     */
    @ApiModelProperty("回答内容")
    private String quizAnswer;

    /**
     *   被申请人回答内容
     */
    @ApiModelProperty("被申请人回答内容")
    private String respondentAnswer;

    /**
     *   回答时间
     */
    @ApiModelProperty(value = "回答时间")
    private Date answerTime;

    /**
     *   被申请人回答时间
     */
    @ApiModelProperty(value = "被申请人回答时间")
    private Date respondentAnswerTime;

    /**
     * 提问时间
     */
    @ApiModelProperty(value = "提问时间")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuizContent() {
        return quizContent;
    }

    public void setQuizContent(String quizContent) {
        this.quizContent = quizContent;
    }

    public String getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswer(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }

    public String getRespondentAnswer() {
        return respondentAnswer;
    }

    public void setRespondentAnswer(String respondentAnswer) {
        this.respondentAnswer = respondentAnswer;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Date getRespondentAnswerTime() {
        return respondentAnswerTime;
    }

    public void setRespondentAnswerTime(Date respondentAnswerTime) {
        this.respondentAnswerTime = respondentAnswerTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}