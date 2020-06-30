package com.husy.springdemo.common.tool;

import com.husy.springdemo.dao.entity.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * 系统用户工具类
 * @author: husy
 */
public class UserTool {

    /**
     * 获取当前用户信息
     * @return
     */
    public static SysUser getUser() {
        return  (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    //TODO 方法二、获取当前用户的数据权限，如区域范围权限

    /**
     * 获取当前用户账户
     * @return
     */
    public static String getAccount() {
        return null;
    }

}
