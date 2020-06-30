package com.husy.springdemo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.husy.springdemo.dao.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 系统菜单 Mapper 接口
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 通过角色ID获取菜单
     * @param sysRoleId
     * @return
     */
    List<SysMenu> listMenusByRoleId(String sysRoleId);
}
