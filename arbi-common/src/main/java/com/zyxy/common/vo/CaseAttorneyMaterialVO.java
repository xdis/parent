package com.zyxy.common.vo;

import com.zyxy.common.domain.CaseMat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件代理人材料VO
 */
@ApiModel("案件代理人材料信息")
public class CaseAttorneyMaterialVO {

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String docName;

    /**
     * 文件Id
     */
    @ApiModelProperty("文件Id")
    private String fileId;

    /**
     * 文件类型
     */
    @ApiModelProperty("文件类型")
    private String fileType;

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public static CaseAttorneyMaterialVO convertFormCaseMat(CaseMat caseMat) {
        CaseAttorneyMaterialVO vo = new CaseAttorneyMaterialVO();
        vo.setDocName(caseMat.getDocName());
        vo.setFileId(caseMat.getFileId());
        vo.setFileType(caseMat.getDocType());
        return vo;
    }
}
