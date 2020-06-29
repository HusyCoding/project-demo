package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husy.springdemo.dao.entity.SysMenu;
import com.husy.springdemo.dao.mapper.SysMenuMapper;
import com.husy.springdemo.service.mybatisplus.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Override
    public List<SysMenu> listMenusByRoleId(String sysRoleId) {
        return baseMapper.listMenusByRoleId(sysRoleId);
    }
}
