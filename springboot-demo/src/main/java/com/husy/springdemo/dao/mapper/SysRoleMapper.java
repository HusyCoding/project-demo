package com.ycxc.admin.dao.ycxcadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ycxc.admin.dao.ycxcadmin.entity.SysRole;

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
