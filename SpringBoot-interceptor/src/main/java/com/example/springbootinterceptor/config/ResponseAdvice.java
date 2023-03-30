package com.example.springbootinterceptor.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.xml.ws.Response;
import java.util.HashMap;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/30  8:12
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Autowired
     private ObjectMapper objectMapper;
    /**
    * @explain 这个方法为true执行重写的方法
    * @param returnType
    * @param converterType
    * @return boolean
    * @author DUT-SUN
    * @date   2023/3/30
    */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        HashMap<String,Object> result=new HashMap<>();
        result.put("code",200);
        result.put("data",body);
        result.put("msg","");
        if(body instanceof String){
            try {
                return objectMapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
