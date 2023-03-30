package com.example.springbootinterceptor.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/29  19:28
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
    * @explain  ture成功执行后面逻辑
    * @param request
    * @param response
    * @param handler
    * @return boolean
    * @author DUT-SUN
    * @date   2023/3/29
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //用户登录业务判断
        HttpSession session=request.getSession(false);
        if(session!=null && session.getAttribute("userinfo")!=null){
            //说明用户已经登录
            return true;
        }
        //可以重定向页面
        response.sendRedirect("/login.html");
        return false;
    }
}
