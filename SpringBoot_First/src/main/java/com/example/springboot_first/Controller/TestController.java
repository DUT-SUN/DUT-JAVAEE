package com.example.springboot_first.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/25  16:30
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @RequestMapping("/tes")
    public  String sayTest(){
        log.trace("Hi,SLF4J");
        return "Hi,SLF4J";
    }
}
