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
 * 当属性和表中字段中没有一一对应时，可以使用resultmap或者as解决问题
 */
@Mapper
public interface UserMapper {
    Userinfo getUserById(@Param("id") Integer id);
    List<Userinfo> getAll();
   int add (Userinfo userinfo);
    int add2 (Userinfo userinfo);
    int updateUserName(Userinfo userinfo);
    List<Userinfo> getUserByName(@Param("username")String username);
    List<Userinfo>getListByOrder(@Param("order")String order);
    Userinfo login(@Param("username")String username,@Param("password")String password);
    List<Userinfo>getListByName(@Param("username")String username);
    int add3(Userinfo userinfo);
    int add4(Userinfo userinfo);
    List<Userinfo>getListByParam(String username,String password);
    int update2(Userinfo userinfo);
    int dels(List<Integer>list);


}
