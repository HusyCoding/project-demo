package com.husy.springdemo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.husy.springdemo.dao.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 系统菜单 Mapper 接口
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> listMenusByRoleId(Integer sysRoleId);
}
