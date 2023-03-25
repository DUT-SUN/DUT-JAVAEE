package com.example.springboot_first.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/25  14:58
 */
@RequestMapping("/user")
@Controller
@ResponseBody//用来设置这个类所有方法都是返回数据而非页面
public class UserController {
    //写日志
    //1.得到日志对象
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/hi")
    public String sayHi(){
        //2.写日志
        logger.trace("我是trace");
        logger.debug("我是调试日志");
        logger.info("我是info");
        logger.error("我是error");
        logger.warn("我是warn");
        return "Hi,Spring boot";
    }
}
