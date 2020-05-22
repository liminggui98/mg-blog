package org.mg.blog.blogadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 应用启动类
 */
@EnableCaching
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "org.mg.blog")
public class BlogAdminApplication {

    /**
     * 应用启动入口
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }
}
