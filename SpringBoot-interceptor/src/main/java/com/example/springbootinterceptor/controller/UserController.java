package com.example.springbootinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/29  19:17
 */
@RestController
@RequestMapping("/user")
public class UserController {
//@GetMapping
//    public String getMethod(){
//        return"执行GET请求";
//    }
@PostMapping
    public String PostMethod(){
       return"执行POST请求";
    }
    @RequestMapping("/getuser")
    public String getUser(){
        System.out.println("执行了getuser");
        Object obj=null;
        obj.hashCode();
        return "get user";
    }
    @RequestMapping("/login")
    public String login(){
        int a=1/0;
        System.out.println("执行了login");
        return "login";
    }
    @RequestMapping("/getnum")
    public Integer getNum(){
        int a= new Random().nextInt(10);
        return a;
    }
}
