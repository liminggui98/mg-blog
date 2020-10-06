package org.mg.blog.system;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动入口
 *
 * @since 2020-05-29
 */
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2Doc
@EnableSwagger2
public class SystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class);
    }
}
