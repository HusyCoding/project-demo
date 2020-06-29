package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husy.springdemo.dao.entity.EnterpriseServiceUser;
import com.husy.springdemo.dao.mapper.EnterpriseServiceUserMapper;
import com.husy.springdemo.service.mybatisplus.IEnterpriseServiceUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业服务人员关联中间表(企业绑定一个人员,人员绑定多家企业) 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
@Service
public class EnterpriseServiceUserServiceImpl extends ServiceImpl<EnterpriseServiceUserMapper, EnterpriseServiceUser> implements IEnterpriseServiceUserService {

}
