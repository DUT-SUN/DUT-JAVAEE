package com.example.blogssm.service;

import com.example.blogssm.entity.UserInfo;
import com.example.blogssm.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/13  19:06
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int reg(UserInfo userInfo){
        return userMapper.reg(userInfo);
    }
    public UserInfo getUserByName(String username){return userMapper.getUserByName(username);}

    public UserInfo getUserById( Integer id){return userMapper.getUserById(id);}
}
