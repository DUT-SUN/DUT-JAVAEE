package com.example.mybatisdemo.Service;

import com.example.mybatisdemo.Entity.Userinfo;
import com.example.mybatisdemo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/27  15:23
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Userinfo getUserbyId(Integer id){
        return userMapper.getUserById(id);
    }
    public int updateUserName(Userinfo userinfo){
        return userMapper.updateUserName(userinfo);
    }
}
