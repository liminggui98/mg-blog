package org.mg.blog.website.config;

import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreemarkerConfiguration {

    @Autowired
    freemarker.template.Configuration configuration;

    /**
     * 配置 Freemarker 共享全局变量
     *
     * @return Freemarker 配置
     */
    @PostConstruct
    public void handleFreemarkerConfiguration() throws TemplateModelException {
    }
}
