package com.example.mybatisdemo.VO;

import com.example.mybatisdemo.Entity.AriticleInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/28  9:55
 */
@Data
public class AriticleInfoVO extends AriticleInfo implements Serializable {
    private String username;
    private final long serializableId=1L;
    @Override
    public String toString() {
        return "AriticleInfoVO{" +
                "username='" + username + '\'' +
                "} " + super.toString();
    }
}
