package com.example.mybatisdemo.Mapper;

import com.example.mybatisdemo.VO.AriticleInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
 *
 * @author SUN
 * @date 2023/03/28  10:01
 */
@SpringBootTest
class AriticleMapperTest {

    @Autowired
    private AriticleMapper ariticleMapper;
    @Test
    void getByID() {
        AriticleInfoVO ariticleInfoVO=ariticleMapper.getByID(1);
        System.out.println(ariticleInfoVO);
    }
}