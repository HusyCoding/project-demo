package com.ycxc.admin.dao.ycxcadmin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId("sys_role_id")
    private String sysRoleId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @TableField("remark")
    private String remark;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 删除时间
     */
    @TableField("delete_time")
    private Date deleteTime;

    /**
     * 创建用户
     */
    @TableField("create_id")
    private String createId;

    /**
     * 更新用户
     */
    @TableField("update_id")
    private String updateId;

    /**
     * 删除用户
     */
    @TableField("delete_id")
    private String deleteId;

    /**
     * 0-未删除，1-已删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 城市区域权限
     */
    @TableField("city_permissions")
    private String cityPermissions;

    /**
     * 角色类型：1超级管理员，0普通角色
     */
    @TableField("role_type")
    private Integer roleType;

    /**
     * 数据可见范围,0：全部（默认），1：选的城市
     */
    @TableField("data_range")
    private Boolean dataRange;

    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }
    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public String getCityPermissions() {
        return cityPermissions;
    }

    public void setCityPermissions(String cityPermissions) {
        this.cityPermissions = cityPermissions;
    }
    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
    public Boolean getDataRange() {
        return dataRange;
    }

    public void setDataRange(Boolean dataRange) {
        this.dataRange = dataRange;
    }

    @Override
    public String toString() {
        return "SysRole{" +
        "sysRoleId=" + sysRoleId +
        ", roleName=" + roleName +
        ", remark=" + remark +
        ", sort=" + sort +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", deleteTime=" + deleteTime +
        ", createId=" + createId +
        ", updateId=" + updateId +
        ", deleteId=" + deleteId +
        ", deleted=" + deleted +
        ", cityPermissions=" + cityPermissions +
        ", roleType=" + roleType +
        ", dataRange=" + dataRange +
        "}";
    }
}
