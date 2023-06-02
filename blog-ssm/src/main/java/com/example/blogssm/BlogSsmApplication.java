package com.example.blogssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

//防止加入security的登录页面
@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
@EnableCaching//开启全局注解缓存
public class BlogSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSsmApplication.class, args);
    }

}
