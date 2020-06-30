package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.husy.springdemo.dao.entity.SysUser;
import com.husy.springdemo.dao.mapper.SysUserMapper;
import com.husy.springdemo.service.mybatisplus.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public SysUser getUserByName(String username) {
        return baseMapper.selectOne(new QueryWrapper<SysUser>().eq("username",username).eq("deleted",0));
    }
}
