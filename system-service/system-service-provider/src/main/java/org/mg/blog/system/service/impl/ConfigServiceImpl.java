package org.mg.blog.system.service.impl;

import cn.hutool.core.date.DateUtil;
import org.mg.blog.service.impl.BaseServiceImpl;
import org.mg.blog.system.constants.DateConstants;
import org.mg.blog.system.dto.Config;
import org.mg.blog.system.enums.ConfigKeyEnum;
import org.mg.blog.system.mapper.ConfigMapper;
import org.mg.blog.system.service.ConfigService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @since 2020-05-29
 */
@Service
@CacheConfig(cacheNames = "config")
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements ConfigService {
    @Resource
    private ConfigMapper configMapper;

    @Override
    public Map<String, Object> queryConfigs() {
        List<Config> configList = configMapper.selectAll();
        if (CollectionUtils.isEmpty(configList)) {
            return null;
        }
        String updateTimeKey = ConfigKeyEnum.UPDATE_TIME.getKey();
        Map<String, Object> res = new HashMap<>();
        res.put(updateTimeKey, DateUtil.parse("2019-01-01 00:00:00", DateConstants.YYYY_MM_DD_HH_MM_SS_EN));
        configList.forEach((sysConfig) -> {
            res.put(String.valueOf(sysConfig.getConfigKey()), sysConfig.getConfigValue());
            if (sysConfig.getUpdateTime().after(((Date) res.get(updateTimeKey)))) {
                res.put(updateTimeKey, sysConfig.getUpdateTime());
            }
        });
        return res;
    }
}
