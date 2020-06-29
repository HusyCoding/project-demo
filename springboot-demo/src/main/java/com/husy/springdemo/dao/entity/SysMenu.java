package com.ycxc.admin.dao.ycxcadmin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("menu_id")
    private Integer menuId;

    /**
     * 菜单编码
     */
    @TableField("menu_code")
    private String menuCode;

    /**
     * 父菜单编码
     */
    @TableField("parent_code")
    private String parentCode;

    /**
     * 菜单级别，0:一级，1:二级，2:三级，3:四级（功能按钮级别）
     */
    @TableField("menu_level")
    private Integer menuLevel;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单授权码(多个用逗号分隔，如：user:list,user:create)
     */
    @TableField("permission")
    private String permission;

    /**
     * 菜单排序
     */
    @TableField("menu_order")
    private Integer menuOrder;

    /**
     * 是否展开  0：不展开  1：展开
     */
    @TableField("is_spread")
    private Boolean isSpread;

    /**
     * 状态,0:禁用,1:启用
     */
    @TableField("status")
    private Boolean status;

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

    /**
     * 0-未删除，1-已删除
     */
    @TableField("is_deleted")
    private Boolean isDeleted;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        ", menuCode=" + menuCode +
        ", parentCode=" + parentCode +
        ", menuLevel=" + menuLevel +
        ", menuName=" + menuName +
        ", permission=" + permission +
        ", menuOrder=" + menuOrder +
        ", isSpread=" + isSpread +
        ", status=" + status +
        ", createTime=" + createTime +
        ", createId=" + createId +
        ", updateTime=" + updateTime +
        ", updateId=" + updateId +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
