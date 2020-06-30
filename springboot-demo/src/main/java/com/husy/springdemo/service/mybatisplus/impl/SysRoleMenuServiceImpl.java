package com.husy.springdemo.service.mybatisplus.impl;

import com.husy.springdemo.dao.entity.SysRoleMenu;
import com.husy.springdemo.dao.mapper.SysRoleMenuMapper;
import com.husy.springdemo.service.mybatisplus.ISysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

}
