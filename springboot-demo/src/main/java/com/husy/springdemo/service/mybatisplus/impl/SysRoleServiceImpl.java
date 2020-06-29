package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husy.springdemo.dao.entity.SysRole;
import com.husy.springdemo.dao.mapper.SysRoleMapper;
import com.husy.springdemo.service.mybatisplus.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public List<SysRole> listRolesByUserId(String sysUserId) {
        return baseMapper.listRolesByUserId(sysUserId);
    }
}
