package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husy.springdemo.dao.entity.UserToken;
import com.husy.springdemo.dao.mapper.UserTokenMapper;
import com.husy.springdemo.service.mybatisplus.IUserTokenService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 移动端token表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements IUserTokenService {

}
