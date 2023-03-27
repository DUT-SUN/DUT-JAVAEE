package com.example.mybatisdemo.Mapper;

import com.example.mybatisdemo.Entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/27  13:03
 */
@Mapper
public interface UserMapper {
    Userinfo getUserById(@Param("id") Integer id);
    List<Userinfo> getAll();
   int add (Userinfo userinfo);
    int add2 (Userinfo userinfo);
    int updateUserName(Userinfo userinfo);
    List<Userinfo> getUserByName(@Param("username")String username);
}
