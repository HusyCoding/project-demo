package com.husy.springdemo.web.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.husy.springdemo.common.constant.ResponseCode;
import com.husy.springdemo.domain.ResponseEntity;
import com.husy.springdemo.domain.form.LoginForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 *
 * @author husy
 * @version 1.0
 * @date 2019/8/1 14:52
 */
@RestController
@RequestMapping("/")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("login")
    public ResponseEntity login(@Valid @RequestBody LoginForm form) {
        logger.debug("开始登录......");

        // 拿到当前用户(可能还是游客，没有登录)
        Subject currentUser = SecurityUtils.getSubject();
        // 如果这个用户没有登录,进行登录功能
        if (!currentUser.isAuthenticated()) {
            try {
                // 验证身份和登陆
                UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(form.getUsername(), DigestUtil.md5Hex(form.getPassword()));
                currentUser.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                return ResponseEntity.fail(ResponseCode.DATA_NOT_FOUND);
            } catch (IncorrectCredentialsException e) {
                return ResponseEntity.fail(ResponseCode.LOGIN_FAILED_AUTHORIZATION);
            } catch (LockedAccountException e) {
                return ResponseEntity.fail(ResponseCode.INVALID_ACCOUNT);
            } catch (AuthenticationException e) {
                return ResponseEntity.error();
            }
        }
        // 封装返回对象
        Map<String, Object> resultInfo = new HashMap<>(5);
        resultInfo.put("token", SecurityUtils.getSubject().getSession().getId().toString());
        return ResponseEntity.data(resultInfo);
    }

    @RequestMapping("logout")
    public ResponseEntity loginOut() {
        // 用户登出
        SecurityUtils.getSubject().logout();
        return ResponseEntity.success();
    }

    @RequestMapping("/un_auth")
    public ResponseEntity unAuth() {
        return ResponseEntity.fail(ResponseCode.ACCOUNT_UNAUTHORIZED);
    }

    @RequestMapping("/unauthorized")
    public ResponseEntity unauthorized() {
        return ResponseEntity.fail(ResponseCode.PERMISSION_DENIED_AUTHORIZATION);
    }
}
