package com.example.springaop.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/29  14:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hi")
    public String sayHi(String name){
return      "hi,"+name;
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
