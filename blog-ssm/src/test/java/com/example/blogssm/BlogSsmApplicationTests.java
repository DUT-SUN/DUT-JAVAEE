package com.example.blogssm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

//@SpringBootTest
class BlogSsmApplicationTests {

//    @Test
//    void contextLoads() {
//    }
public static void main(String[]args){
String password="123456";
String mdString=new String(
        DigestUtils.md5DigestAsHex(password.getBytes())
);
    System.out.println(mdString);
}

}
