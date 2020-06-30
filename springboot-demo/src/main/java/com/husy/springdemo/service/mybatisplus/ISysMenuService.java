package com.husy.springdemo.service.mybatisplus;

import com.husy.springdemo.dao.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 根据角色ID 获取用户的菜单列表
     * @param sysRoleId
     * @return
     */
    List<SysMenu> listMenusByRoleId(Integer sysRoleId);
}
