package com.example.springboottransaction.controller;

import com.example.springboottransaction.entity.UserInfo;
import com.example.springboottransaction.mapper.UserMapper;
import com.example.springboottransaction.service.LogServcie;
import com.example.springboottransaction.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/30  18:15
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private LogServcie logServcie;
    @Autowired
    private UserService userService;

@RequestMapping("/add")
    public Integer add(UserInfo userInfo){
    if(userInfo==null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())){
        return 0;
    }
    //1.开启事务
    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
    userInfo.setCreatetime(LocalDateTime.now().toString());
    userInfo.setUpdatetime(LocalDateTime.now().toString());
    System.out.println(userInfo);

    int result= userMapper.add(userInfo);
    System.out.println("添加"+result);
    //2.回滚事务
//    transactionManager.rollback(transactionStatus);
    //3.发送事务
//    transactionManager.commit(transactionStatus);
    transactionManager.rollback(transactionStatus);
    return result;
}
/**
* @explain @Transactional自动添加事务,可以修饰到public方法和类,问题在于当有异常在trycatch中时不会事务回滚
* @param userInfo
* @return java.lang.Integer
* @author DUT-SUN
* @date   2023/3/30
*/
@Transactional
    @RequestMapping("/insert")
    public Integer insert(UserInfo userInfo){
        if(userInfo==null || !StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())){
            return 0;
        }
        userInfo.setCreatetime(LocalDateTime.now().toString());
        userInfo.setUpdatetime(LocalDateTime.now().toString());
        System.out.println(userInfo);

        int result= userService.add(userInfo);
        System.out.println("添加"+result);
//        try{
//            int num=1/0;
//        }catch (Exception e){
//            //1.解决方案 抛出异常
////            throw e;
//            //2.打印异常，代码手动回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
    if(result>0){
        logServcie.add();
    }
        return result;
    }
}
