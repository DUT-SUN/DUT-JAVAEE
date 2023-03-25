package com.example.springboot_first;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/25  11:19
 */
@Component
@ConfigurationProperties("student")
@Data
public class Student {
    private int id;
    private String name;
    private int age;
}
