package com.example.mybatisdemo.Mapper;

import com.example.mybatisdemo.Entity.Userinfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ��������
 * <p>
 * �������أ������ٳ�
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
        //����mybatis��ӷ���
        int result= userMapper.add(userinfo);
        System.out.println("���: "+result);
        Assertions.assertEquals(1,result);
        int id=userinfo.getId();
        System.out.println("ID��"+id);
    }

    @Test
    void add2() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("123");
        userinfo.setPassword("123");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        //����mybatis��ӷ���
        int result= userMapper.add2(userinfo);
        System.out.println("���: "+result);
        int id=userinfo.getId();
        System.out.println("ID��"+id);
    }

    @Test
    void getUserByName() {
        List<Userinfo>list=userMapper.getUserByName("�θ�");
        System.out.println("��ѯ����Ϊ"+list.size());
    }
    @Test
    void getListByOrder() {
        List<Userinfo>list=userMapper.getListByOrder("desc");
        System.out.println(list);
    }
    @Test
    void login() {
        String username="admin";
        String password="admin";
//' or 1='1
        Userinfo userinfo=userMapper.login(username,password);
        System.out.println("��¼״̬:"+((userinfo==null)?"��¼ʧ��":"��¼�ɹ�"));
    }
    @Test
    void getListByName() {
        String username="d";
        System.out.println(userMapper.getListByName(username));
    }

    @Test
    void add3() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("����");
        userinfo.setPassword("13232");
        userinfo.setPhoto(null);
        int result=userMapper.add3(userinfo);
        System.out.println(result);
    }

    @Test
    void add4() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("hxyyzj");
        userinfo.setPassword("123");
        userinfo.setPhoto(null);
        int result=userMapper.add4(userinfo);
        System.out.println(result);
    }

    @Test
    void getListByParam() {
        List<Userinfo> userinfos=userMapper.getListByParam("����",null);
        System.out.println(userinfos);
    }

    @Test
    void update2() {
        Userinfo user=new Userinfo();
        user.setId(7);
        user.setUsername(null);
        user.setPassword("123");
        user.setPhoto("top.png");
        int result=userMapper.update2(user);
        System.out.println(result);
    }

    @Test
    void dels() {
        List<Integer>list=new ArrayList<>();
        list.add(6);
        list.add(7);
        int result=userMapper.dels(list);
        System.out.println(result);
    }
}