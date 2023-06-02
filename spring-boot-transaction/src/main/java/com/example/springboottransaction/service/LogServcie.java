package com.example.springboottransaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/04  10:06
 */
@Service
public class LogServcie {
    @Transactional(propagation = Propagation.REQUIRED)
    public int add(){
        try{
            int num=10/0;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 1;
    }
}
