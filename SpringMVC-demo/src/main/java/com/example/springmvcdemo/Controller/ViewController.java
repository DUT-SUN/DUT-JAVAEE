package com.example.springmvcdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/26  22:10
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    @RequestMapping("/hi")
    //返回static文件夹下的页面
    public String sayHi(){
        return "/hello.html";
    }
}
