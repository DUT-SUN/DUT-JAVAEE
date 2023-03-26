package com.example.springmvcdemo.Controller;

import com.example.springmvcdemo.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/25  23:04
 */
@RequestMapping("/test")
@RestController//让框架启动时加载当前类（只有加载的类别人才能访问）
@Slf4j
public class TestController {
//    @RequestMapping(value = "/hi",method = RequestMethod.POST)
//    @GetMapping("/hi")
    @PostMapping("/hi")
    public String sayHi(){
        return "Hi,Spring Boot";
    }
//一定要传包装类而不是基础类，因为如果你要传基础类型的时候，但是没有传的时候就会报错，而包装类型只是会提醒你值为空
    @GetMapping("/num")
    public  String getNum(Integer num){
        return "num:"+num;
    }
    @GetMapping("/showuser")
    public String showUser(User user){
        return user.toString();
    }
    @GetMapping("/getTime")
    public  String getTime(@RequestParam(value = "t1",required = false) String startTime,@RequestParam("t2") String endTime){
        return "开始时间:"+startTime+"结束时间"+endTime;
    }
    @PostMapping("/getUser")
    public String getUser(@RequestBody User user){
        return user.toString();
    }
    @RequestMapping("/login/{username}/{password}")
    public String Login(@PathVariable String username,@PathVariable String password){
        return username +"+" + password;

    }
@RequestMapping("/upfile")
    public String upfile(@RequestPart("myfile") MultipartFile file) throws IOException {
    String path="E:\\DUT-JAVAEE\\SpringMVC-demo\\src\\main\\java\\com\\example\\springmvcdemo\\images\\img.png";
    file.transferTo(new File(path));
        return path;
    }
    @RequestMapping("/myupfile")
    public String myUpflie(@RequestPart("myfile") MultipartFile file) throws IOException {
        String path="E:\\DUT-JAVAEE\\SpringMVC-demo\\src\\main\\java\\com\\example\\springmvcdemo\\images\\";
        path+= UUID.randomUUID().toString().replace("-","");
        path+=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        file.transferTo(new File(path));
        return path;
    }
    @GetMapping("/getparam")
    public String getParam(HttpServletRequest request)
    {
        return request.getParameter("username")+request.getHeader("User-Agent");
    }
    //Servlet写法
    @RequestMapping("getck")
    public String getCookie(HttpServletRequest request){
        Cookie[]cookies=request.getCookies();
        for( Cookie item:cookies){
            log.error(item.getName()+item.getValue());
        }
        return "getck";

    }
    @RequestMapping("getck2")
    public String getCookie2(@CookieValue("zhangsan")String val){
        return "Cookie Value:"+val;
    }
    @RequestMapping("getUa")
    public  String getUa(@RequestHeader("User-Agent")String useragent){
        return useragent;
    }
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request){
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("Userinfo","Userinfo");
        return "set session success";
    }
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){
        HttpSession httpSession=request.getSession(false);
        if(httpSession!=null&& httpSession.getAttribute("Userinfo")!=null ){
            return (String) httpSession.getAttribute("Userinfo");
        }else{
            return" Session 不存在";
        }
    }
    //拿到session的数据
    @RequestMapping("/getSession2")
    public  String getSession2(@SessionAttribute(value = "Userinfo",required = false)String userInfo){
              return userInfo;
    }
    @RequestMapping("/respJson")
    public HashMap<String,String> respJson(){
        HashMap<String,String>map=new HashMap<>();
        map.put("JAVA","NB");
        return map;
    }

}
