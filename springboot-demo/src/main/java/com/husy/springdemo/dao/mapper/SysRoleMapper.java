package com.husy.springdemo.dao.mapper;

import com.husy.springdemo.dao.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> listRolesByUserId(Integer sysUserId);
}
