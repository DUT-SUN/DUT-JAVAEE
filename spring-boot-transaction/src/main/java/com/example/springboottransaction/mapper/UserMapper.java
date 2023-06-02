package com.example.springboottransaction.mapper;

import com.example.springboottransaction.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/30  18:23
 */
@Mapper
public interface UserMapper {
    public Integer add(UserInfo userInfo);
}
