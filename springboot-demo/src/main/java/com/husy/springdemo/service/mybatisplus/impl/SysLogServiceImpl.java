package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husy.springdemo.dao.entity.SysLog;
import com.husy.springdemo.dao.mapper.SysLogMapper;
import com.husy.springdemo.service.mybatisplus.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统操作日志表 服务实现类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
