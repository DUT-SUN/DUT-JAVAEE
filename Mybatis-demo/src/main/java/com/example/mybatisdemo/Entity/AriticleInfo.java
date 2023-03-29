package com.example.mybatisdemo.Entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/28  9:48
 */
@Data
public class AriticleInfo implements Serializable {
    private final long serializableId=1L;
    private String username;
    private int id;
    private String title;
    private String createtime;
    private String updatetime;
    private int uid;
    private int rcount;
}
