package com.husy.springdemo.dao.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer menuId;

    /**
     * 父菜单ID
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单级别，0:一级，1:二级，2:三级，3:四级
     */
    private Integer menuLevel;

    /**
     * 菜单排序
     */
    private Integer menuOrder;

    /**
     * 是否展开  0：不展开  1：展开
     */
    private Boolean isSpread;

    /**
     * 状态,0:禁用,1:启用
     */
    private Integer status;

    /**
     * 菜单授权码(多个用逗号分隔，如：user:list,user:create)
     */
    private String permission;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户
     */
    private Integer createId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户
     */
    private Integer updateId;

    /**
     * 是否已删除：0-未删除，1-已删除
     */
    private Boolean isDeleted;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }
    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }
    public Boolean getSpread() {
        return isSpread;
    }

    public void setSpread(Boolean isSpread) {
        this.isSpread = isSpread;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
            "menuId=" + menuId +
            ", parentId=" + parentId +
            ", menuName=" + menuName +
            ", menuLevel=" + menuLevel +
            ", menuOrder=" + menuOrder +
            ", isSpread=" + isSpread +
            ", status=" + status +
            ", permission=" + permission +
            ", createTime=" + createTime +
            ", createId=" + createId +
            ", updateTime=" + updateTime +
            ", updateId=" + updateId +
            ", isDeleted=" + isDeleted +
        "}";
    }
}
