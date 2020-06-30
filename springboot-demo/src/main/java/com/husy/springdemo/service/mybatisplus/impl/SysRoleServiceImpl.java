package com.husy.springdemo.service.mybatisplus.impl;

import com.husy.springdemo.dao.entity.SysRole;
import com.husy.springdemo.dao.mapper.SysRoleMapper;
import com.husy.springdemo.service.mybatisplus.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public List<SysRole> listRolesByUserId(Integer sysUserId) {
        return baseMapper.listRolesByUserId(sysUserId);
    }
}
