package com.husy.springdemo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.husy.springdemo.dao.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> listRolesByUserId(String sysUserId);
}
