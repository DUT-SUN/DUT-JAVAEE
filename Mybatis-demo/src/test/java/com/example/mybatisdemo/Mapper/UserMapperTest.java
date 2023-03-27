package com.example.mybatisdemo.Mapper;

import com.example.mybatisdemo.Entity.Userinfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/27  16:49
 */
@SpringBootTest
@Transactional
class UserMapperTest {
@Autowired
private UserMapper userMapper;
    @Test
    void getUserById() {
        Userinfo userinfo=userMapper.getUserById(1);
        System.out.println(userinfo);
        Assertions.assertEquals("admin",userinfo.getUsername());
    }

    @Test
    void add() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("123");
        userinfo.setPassword("123");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        //调用mybatis添加方法
        int result= userMapper.add(userinfo);
        System.out.println("添加: "+result);
        Assertions.assertEquals(1,result);
        int id=userinfo.getId();
        System.out.println("ID："+id);
    }

    @Test
    void add2() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("123");
        userinfo.setPassword("123");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        //调用mybatis添加方法
        int result= userMapper.add2(userinfo);
        System.out.println("添加: "+result);
        int id=userinfo.getId();
        System.out.println("ID："+id);
    }

    @Test
    void getUserByName() {
        List<Userinfo>list=userMapper.getUserByName("涛哥");
        System.out.println("查询条数为"+list.size());
    }
}