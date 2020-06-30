package com.husy.springdemo.service.mybatisplus;

import com.baomidou.mybatisplus.extension.service.IService;
import com.husy.springdemo.dao.entity.SysUser;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 根据账户名称获取用户
     * @param username
     * @return
     */
    SysUser getUserByName(String username);
}
