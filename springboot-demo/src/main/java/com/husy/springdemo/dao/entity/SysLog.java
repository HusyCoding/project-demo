package com.husy.springdemo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 系统操作日志表
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    /**
     * 业务名称，一般记录菜单模块名称
     */
    private String businessName;

    /**
     * 0:DB查询、1:DB新增、2:DB删除、3:DB修改
     */
    private Integer action;

    /**
     * 操作账户ID
     */
    private Integer operatorId;

    /**
     * 请求客户端IP
     */
    private Integer ip;

    /**
     * 请求服务URI
     */
    private String uri;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求参数
     */
    private String content;

    /**
     * 请求时间
     */
    private Date accessTime;

    /**
     * 请求耗时（毫秒）
     */
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
    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
    public Integer getIp() {
        return ip;
    }

    public void setIp(Integer ip) {
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
