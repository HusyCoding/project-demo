package com.husy.springdemo.service.mybatisplus;

import com.baomidou.mybatisplus.extension.service.IService;
import com.husy.springdemo.dao.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 根据ID 获取用户的角色列表
     * @param sysUserId
     * @return
     */
    List<SysRole> listRolesByUserId(String sysUserId);
}
