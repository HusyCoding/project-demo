package com.husy.springdemo.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统角色与菜单对应关系
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;

    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Integer menuId;

    /**
     * 选中状态：0未选中,1选中,2半选
     */
    @TableField("check_state")
    private Integer checkState;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 创建用户
     */
    @TableField("create_id")
    private String createId;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 更新用户
     */
    @TableField("update_id")
    private String updateId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
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
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
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
