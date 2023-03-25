package com.example.springboot_first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/24  9:29
 */
@RestController
//@PropertySource(value = "application.properties",encoding = "uft-8")
public class Hello {
    @Value("${myname}")
    private String name;
    @Value("${mytest}")
    private String name1;
    @Value("${str1}")
    private String str1;
    @Value("${str2}")
    private String str2;
    @Value("${str3}")
    private String str3;
    @Autowired
    private Student student;
    @PostConstruct
    public  void printString(){
//        System.out.println(str1);
//        System.out.println(str2);
//        System.out.println(str3);
        System.out.println(student);
    }
    @RequestMapping("/hi")//url路由注册
    public String sayHi(String name){
        if(!StringUtils.hasLength(name)){
            name="张三";
        }
        return "你好:"+name;
    }
    @RequestMapping("/getConfig")
    public String getConfig(){
        return "name:"+name+"name1:"+name1;
    }


}
