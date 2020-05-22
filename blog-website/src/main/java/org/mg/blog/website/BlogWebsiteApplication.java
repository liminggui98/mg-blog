package org.mg.blog.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(value = "org.mg.blog")
public class BlogWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebsiteApplication.class, args);
    }
}
