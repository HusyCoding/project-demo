package com.husy.springdemo.web.shiro;

import com.husy.springdemo.dao.entity.SysMenu;
import com.husy.springdemo.dao.entity.SysRole;
import com.husy.springdemo.dao.entity.SysUser;
import com.husy.springdemo.service.mybatisplus.ISysMenuService;
import com.husy.springdemo.service.mybatisplus.ISysRoleService;
import com.husy.springdemo.service.mybatisplus.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * shiro 用户认证和授权
 *
 * @author: husy
 * @date: 2020/6/20 17:21
 */
public class ShiroRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    @Autowired
    ISysUserService sysUserService;
    @Autowired
    ISysRoleService sysRoleService;
    @Autowired
    ISysMenuService sysMenuService;

    /**
     * 授权：验证权限时调用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
//        SysUser user = systemUserService.findUserByName(name);
        // 获取用户第二种方式
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();

        // 查询用户角色，一个用户可能有多个角色
        List<SysRole> roleList = sysRoleService.listRolesByUserId(user.getUserId());

        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (SysRole role : roleList) {
            //添加角色
//            simpleAuthorizationInfo.addRole(role.getSysRoleId());
            // 根据角色查询权限
            List<SysMenu> sysMenuList = sysMenuService.listMenusByRoleId(role.getRoleId());
            for (SysMenu sysMenu : sysMenuList) {
                simpleAuthorizationInfo.addStringPermission(sysMenu.getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        //获取用户名 密码 第二种方式
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();

        // 查询用户信息
        SysUser sysUser = sysUserService.getUserByName(username);
        if (Objects.isNull(sysUser)) {
            throw new UnknownAccountException();
        }
        if (sysUser.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }
        /*
         * SimpleAuthenticationInfo 对象参数说明：
         * 第一个参数：这里传入的是user对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
         * 第二个参数：密码
         * 第三个参数：realm name
         */
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), getName());
    }
}
