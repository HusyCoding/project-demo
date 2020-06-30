package com.husy.springdemo.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sys_user_id")
    private String sysUserId;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 显示名
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 头像
     */
    @TableField("icon")
    private String icon;

    /**
     * 盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 状态  0：正常   1：禁用
     */
    @TableField("status")
    private Integer status;

    /**
     * 0：普通用户，1：管理员
     */
    @TableField("user_type")
    private Integer userType;

    /**
     * 数据查询方式 0：前缀查询，1：模糊查询
     */
    @TableField("query_type")
    private Integer queryType;

    @TableField("department_id")
    private String departmentId;

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

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
        return "SysUser{" +
        "sysUserId=" + sysUserId +
        ", username=" + username +
        ", password=" + password +
        ", nickname=" + nickname +
        ", icon=" + icon +
        ", salt=" + salt +
        ", email=" + email +
        ", mobile=" + mobile +
        ", status=" + status +
        ", userType=" + userType +
        ", queryType=" + queryType +
        ", departmentId=" + departmentId +
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
