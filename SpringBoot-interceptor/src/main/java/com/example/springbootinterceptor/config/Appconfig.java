package com.example.springbootinterceptor.config;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/29  23:06
 */
@Configuration
public class Appconfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//      registry.addInterceptor(new LoginInterceptor())
//              .addPathPatterns("/**")//拦截所有请求
//              .excludePathPatterns("/user/reg")
//              .excludePathPatterns("/user/login")
//              .excludePathPatterns("/**/*.html");
//
//    }

 /**
 * @explain用来给所有页面添加前缀
 * @param configurer
 * @return void
 * @author DUT-SUN
 * @date   2023/3/29
 */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("/niuma",c->true);
//    }
}
