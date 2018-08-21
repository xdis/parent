package com.zyxy.common.vo;

/**
 * 代理委托案件当事人验证VO
 */
public class CaseLitigantValidVO {

	
	private String propName;
	
	private String propCardId;
	
	private String defeName;
	
	private String defeCardId;

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropCardId() {
		return propCardId;
	}

	public void setPropCardId(String propCardId) {
		this.propCardId = propCardId;
	}

	public String getDefeName() {
		return defeName;
	}

	public void setDefeName(String defeName) {
		this.defeName = defeName;
	}

	public String getDefeCardId() {
		return defeCardId;
	}

	public void setDefeCardId(String defeCardId) {
		this.defeCardId = defeCardId;
	}

	@Override
	public String toString() {
		return "CaseLitigantValidVO [propName=" + propName + ", propCardId="
				+ propCardId + ", defeName=" + defeName + ", defeCardId="
				+ defeCardId + "]";
	}
	
}
