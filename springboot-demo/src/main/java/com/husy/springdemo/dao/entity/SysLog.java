package com.husy.springdemo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统操作日志表
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    /**
     * 业务名称，一般记录菜单模块名称
     */
    @TableField("business_name")
    private String businessName;

    /**
     * 1:新增、2:删除、3:修改
     */
    @TableField("action")
    private Integer action;

    /**
     * 操作账户ID
     */
    @TableField("operator_id")
    private String operatorId;

    /**
     * 请求客户端IP
     */
    @TableField("ip")
    private Long ip;

    /**
     * 请求服务URI
     */
    @TableField("uri")
    private String uri;

    /**
     * 请求方式
     */
    @TableField("method")
    private String method;

    /**
     * 请求参数
     */
    @TableField("content")
    private String content;

    /**
     * 请求时间
     */
    @TableField("access_time")
    private Date accessTime;

    /**
     * 请求耗时（毫秒）
     */
    @TableField("cost_time")
    private Integer costTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    public Long getIp() {
        return ip;
    }

    public void setIp(Long ip) {
        this.ip = ip;
    }
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }
    public Integer getCostTime() {
        return costTime;
    }

    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return "SysLog{" +
        "logId=" + logId +
        ", businessName=" + businessName +
        ", action=" + action +
        ", operatorId=" + operatorId +
        ", ip=" + ip +
        ", uri=" + uri +
        ", method=" + method +
        ", content=" + content +
        ", accessTime=" + accessTime +
        ", costTime=" + costTime +
        "}";
    }
}
