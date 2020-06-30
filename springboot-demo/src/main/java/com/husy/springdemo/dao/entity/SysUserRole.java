package com.husy.springdemo.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户与角色对应关系
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_role_id")
    private String userRoleId;

    /**
     * 用户ID
     */
    @TableField("sys_user_id")
    private String sysUserId;

    /**
     * 角色ID
     */
    @TableField("sys_role_id")
    private String sysRoleId;

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

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }
    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }
    public String getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId;
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

    @Override
    public String toString() {
        return "SysUserRole{" +
        "userRoleId=" + userRoleId +
        ", sysUserId=" + sysUserId +
        ", sysRoleId=" + sysRoleId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", deleteTime=" + deleteTime +
        ", createId=" + createId +
        ", updateId=" + updateId +
        ", deleteId=" + deleteId +
        ", deleted=" + deleted +
        "}";
    }
}
