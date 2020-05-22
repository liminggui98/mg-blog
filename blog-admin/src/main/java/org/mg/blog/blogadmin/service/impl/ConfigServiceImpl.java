package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.ConfigService;
import org.mg.blog.model.Config;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Override
    public Config query() {
        Config config = new Config();
        config.setSiteName("MG后台管理系统");
        return config;
    }
}
