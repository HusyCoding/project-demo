package com.husy.springdemo.dao.entity;

import java.io.Serializable;

/**
 * <p>
 * 区域信息:
第一、二位表示省（自治区、直辖市、特别行政区）。
第三、四位表示市（地区、自治州、盟及国家直辖市所属市辖区和县的汇总码）。其中，01-20，51-70表示省直辖市；21-50表示地区（自治州、盟）；90表示省直辖县级行政区。
第五、六位表示县（市辖区、县级市、旗）。01-20表示市辖区或地区（自治州、盟）辖县级市；21-70表示县（旗）；81-99表示省直辖县级市；71-80表示工业园区或者经济开发区。
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public class SysRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 行政区域编码
     */
    private String regionCode;

    /**
     * 行政区域名称
     */
    private String regionName;

    /**
     * 上级行政区域编码
     */
    private String parentCode;

    /**
     * 行政区域级别：1-省/直辖市; 2-省级市/地级市/州; 3-区/县/县级市
     */
    private Integer regionType;

    /**
     * 是否删除：0-未删除，1-已删除
     */
    private Boolean isDelete;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }
    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "SysRegion{" +
            "regionCode=" + regionCode +
            ", regionName=" + regionName +
            ", parentCode=" + parentCode +
            ", regionType=" + regionType +
            ", isDelete=" + isDelete +
        "}";
    }
}
