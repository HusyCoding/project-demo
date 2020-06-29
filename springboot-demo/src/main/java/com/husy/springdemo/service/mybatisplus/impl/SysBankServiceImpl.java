package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husy.springdemo.dao.entity.SysBank;
import com.husy.springdemo.dao.mapper.SysBankMapper;
import com.husy.springdemo.service.mybatisplus.ISysBankService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 银行信息 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
@Service
public class SysBankServiceImpl extends ServiceImpl<SysBankMapper, SysBank> implements ISysBankService {

}
