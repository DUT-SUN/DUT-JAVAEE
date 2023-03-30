package com.example.springbootinterceptor.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/29  23:48
 */
@ControllerAdvice
@ResponseBody
public class MyExHandler {
    @ExceptionHandler(NullPointerException.class)
    public HashMap<String, Object> nullException(NullPointerException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", -1);
        result.put("msg", "空指针异常" + e.getMessage());//错误码的描述信息
        result.put("data", null);
        return result;
    }

    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> nullException(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", -1);
        result.put("msg", "异常" + e.getMessage());//错误码的描述信息
        result.put("data", null);
        return result;
    }
}
