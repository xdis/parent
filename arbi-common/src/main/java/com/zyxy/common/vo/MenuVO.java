package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("页面按钮")
public class MenuVO {

    /**
     *
     */
    @ApiModelProperty("菜单ID")
    private String menuId;

    /**
     *
     */
    @ApiModelProperty("菜单名")
    private String menuName;

    public MenuVO() {
	}

	public MenuVO(String menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuVO menuVO = (MenuVO) o;

        if (!menuId.equals(menuVO.menuId)) return false;
        return menuName.equals(menuVO.menuName);
    }

    @Override
    public int hashCode() {
        int result = menuId.hashCode();
        result = 31 * result + menuName.hashCode();
        return result;
    }
}
