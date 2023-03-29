package com.example.mybatisdemo.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/27  13:00
 */
@Data
@Component
public class Userinfo implements Serializable {
    private final long serializableId=1L;
    private int id;
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
