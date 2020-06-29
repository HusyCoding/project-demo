package com.husy.springdemo.service.mybatisplus.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husy.springdemo.dao.entity.BusCertificateQaRule;
import com.husy.springdemo.dao.mapper.BusCertificateQaRuleMapper;
import com.ycxc.admin.domain.query.CertificateApiQuery;
import com.husy.springdemo.service.mybatisplus.IBusCertificateQaRuleService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 合格证质保卡规则表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-06-28
 */
@Service
public class BusCertificateQaRuleServiceImpl extends ServiceImpl<BusCertificateQaRuleMapper, BusCertificateQaRule> implements IBusCertificateQaRuleService {
    @Override
    public Map<String, Object> queryRepairCertificateQa(CertificateApiQuery query) {
        return baseMapper.queryRepairCertificateQa(query);
    }
}
