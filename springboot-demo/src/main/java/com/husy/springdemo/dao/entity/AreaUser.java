package com.ycxc.admin.dao.ycxcadmin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 区域运营人员
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class AreaUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("area_user_id")
    private String areaUserId;

    /**
     * 企业id
     */
    @TableField("enterprise_id")
    private String enterpriseId;

    /**
     * 工号
     */
    @TableField("work_no")
    private String workNo;

    /**
     * 用户名
     */
    @TableField("area_user_name")
    private String areaUserName;

    /**
     * 主管上级
     */
    @TableField("parent_user_id")
    private String parentUserId;

    /**
     * 人员级别:1普通运营，2运营主管，3区域经理
     */
    @TableField("user_grade")
    private Integer userGrade;

    /**
     * 手机号
     */
    @TableField("area_user_phone")
    private String areaUserPhone;

    /**
     * 入职时间
     */
    @TableField("entry_time")
    private Date entryTime;

    /**
     * 用户照片
     */
    @TableField("user_avatar")
    private String userAvatar;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 删除（1未删除 2已删除）
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public String getAreaUserId() {
        return areaUserId;
    }

    public void setAreaUserId(String areaUserId) {
        this.areaUserId = areaUserId;
    }
    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }
    public String getAreaUserName() {
        return areaUserName;
    }

    public void setAreaUserName(String areaUserName) {
        this.areaUserName = areaUserName;
    }
    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }
    public Integer getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }
    public String getAreaUserPhone() {
        return areaUserPhone;
    }

    public void setAreaUserPhone(String areaUserPhone) {
        this.areaUserPhone = areaUserPhone;
    }
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AreaUser{" +
        "areaUserId=" + areaUserId +
        ", enterpriseId=" + enterpriseId +
        ", workNo=" + workNo +
        ", areaUserName=" + areaUserName +
        ", parentUserId=" + parentUserId +
        ", userGrade=" + userGrade +
        ", areaUserPhone=" + areaUserPhone +
        ", entryTime=" + entryTime +
        ", userAvatar=" + userAvatar +
        ", city=" + city +
        ", remark=" + remark +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        "}";
    }
}
