package com.example.springboottransaction.service;

import com.example.springboottransaction.entity.UserInfo;
import com.example.springboottransaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/30  18:33
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Transactional(propagation = Propagation.REQUIRED)
    public  Integer add(UserInfo userInfo){

       int result= userMapper.add(userInfo);
        System.out.println("添加受影响的行数:"+result);
        return result;
    }
}
