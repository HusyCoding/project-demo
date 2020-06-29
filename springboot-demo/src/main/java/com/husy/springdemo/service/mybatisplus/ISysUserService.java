package com.husy.springdemo.service.mybatisplus;

import com.baomidou.mybatisplus.extension.service.IService;
import com.husy.springdemo.dao.entity.SysUser;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 根据账户名称获取用户
     * @param username
     * @return
     */
    SysUser getUserByName(String username);
}
