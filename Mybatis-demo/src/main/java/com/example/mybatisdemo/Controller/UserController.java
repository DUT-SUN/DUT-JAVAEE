package com.example.mybatisdemo.Controller;

import com.example.mybatisdemo.Entity.Userinfo;
import com.example.mybatisdemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/27  15:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getuserbyid")
    public Userinfo getUserById(Integer id){
        if(id==null)return null;
        else {
            return userService.getUserbyId(id);
        }
    }
    @RequestMapping("/updateusername")
    public int updateUserName(@RequestBody Userinfo userinfo){
       return userService.updateUserName(userinfo);
    }
}
