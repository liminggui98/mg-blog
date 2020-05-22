package org.mg.blog.blogadmin.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateModelException;
import org.mg.blog.blogadmin.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static org.mg.blog.constants.BlogConstants.CAN_REGISTER_FLAG;
import static org.mg.blog.constants.BlogConstants.CONFIG;

/**
 * FreeMarker 全局配置
 */
@Configuration
public class FreemarkerConfig {
    @Autowired
    freemarker.template.Configuration configuration;

    @Autowired
    private ConfigService configService;

    /**
     * 配置 Freemarker 共享全局变量
     */
    @PostConstruct
    public void handleFreemarkerConf() throws TemplateModelException {
        configuration.setSharedVariable(CONFIG, configService.query());
        configuration.setSharedVariable(CAN_REGISTER_FLAG, true);
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
