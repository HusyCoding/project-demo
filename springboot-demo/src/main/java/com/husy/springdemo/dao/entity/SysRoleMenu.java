package com.husy.springdemo.dao.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 系统角色与菜单对应关系
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 选中状态：0未选中,1选中,2半选
     */
    private Integer checkState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户ID
     */
    private Integer createId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户ID
     */
    private Integer updateId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    @Override
    public String toString() {
        return "SysRoleMenu{" +
            "roleId=" + roleId +
            ", menuId=" + menuId +
            ", checkState=" + checkState +
            ", createTime=" + createTime +
            ", createId=" + createId +
            ", updateTime=" + updateTime +
            ", updateId=" + updateId +
        "}";
    }
}
