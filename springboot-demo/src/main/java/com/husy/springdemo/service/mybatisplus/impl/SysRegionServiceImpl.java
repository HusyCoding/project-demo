package com.husy.springdemo.service.mybatisplus.impl;

import com.husy.springdemo.dao.entity.SysRegion;
import com.husy.springdemo.dao.mapper.SysRegionMapper;
import com.husy.springdemo.service.mybatisplus.ISysRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 区域信息:
第一、二位表示省（自治区、直辖市、特别行政区）。
第三、四位表示市（地区、自治州、盟及国家直辖市所属市辖区和县的汇总码）。其中，01-20，51-70表示省直辖市；21-50表示地区（自治州、盟）；90表示省直辖县级行政区。
第五、六位表示县（市辖区、县级市、旗）。01-20表示市辖区或地区（自治州、盟）辖县级市；21-70表示县（旗）；81-99表示省直辖县级市；71-80表示工业园区或者经济开发区。 服务实现类
 * </p>
 *
 * @author husy
 * @since 2020-06-30
 */
@Service
public class SysRegionServiceImpl extends ServiceImpl<SysRegionMapper, SysRegion> implements ISysRegionService {

}
