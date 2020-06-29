package com.husy.springdemo.web.config;

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

/**
 * shiro 用户认证和授权
 *
 * @author: husy
 * @date: 2020/6/20 17:21
 */
public class ShiroRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    SystemUserService systemUserService;

    @Autowired
    SystemRoleService systemRoleService;

    /**
     * 授权：验证权限时调用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");

        SystemUser user = systemUserService.findUserByName(name);
        // 获取用户第二种方式
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();

        // 获取用户角色
        List<SystemRole> roleList = systemRoleService.findRoleByUserId(user.getUserId());
        // 获取用户所有菜单功能权限
        List<SystemRole> menuList = systemMenuService.findMenuByRoles(roleList);

        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        for (SystemRole role : roleList) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleCode());
            for (SysPermis permis: role.getPermissions()) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permis.getPermis());
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
        SystemUser systemUser = systemUserService.findUserByName(username);

        if (null == systemUser) {
            throw new UnknownAccountException();
        }
        if(systemUser.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }

        logger.info("---------------- Shiro 凭证认证成功 ----------------------");
        return new SimpleAuthenticationInfo(systemUser, password, getName());
    }
}
