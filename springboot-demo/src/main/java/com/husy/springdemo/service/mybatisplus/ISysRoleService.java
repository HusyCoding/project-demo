package com.husy.springdemo.service.mybatisplus;

import com.husy.springdemo.dao.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统角色表 服务类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 根据ID 获取用户的角色列表
     * @param sysUserId
     * @return
     */
    List<SysRole> listRolesByUserId(Integer sysUserId);
}
