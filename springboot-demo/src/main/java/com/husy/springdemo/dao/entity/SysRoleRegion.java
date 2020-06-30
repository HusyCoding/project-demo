package com.husy.springdemo.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 系统角色权限区域关系表
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class SysRoleRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;

    /**
     * 区域编码
     */
    @TableField("region_code")
    private String regionCode;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public String toString() {
        return "SysRoleRegion{" +
        "roleId=" + roleId +
        ", regionCode=" + regionCode +
        "}";
    }
}
