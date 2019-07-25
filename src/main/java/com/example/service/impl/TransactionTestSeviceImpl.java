package com.example.service.impl;

import com.example.bean.TUser;
import com.example.dao.UserRepository;
import com.example.service.TransactionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionTestSeviceImpl implements TransactionTestService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class) //如果不加rollbackFor = Exception.class 只能在RuntimeException异常才会回滚
    public void transactionMethod(String name){

            //save user with transaction
            TUser user = new TUser();
            user.setPassword("1111");
            user.setUsername(name);
            userRepository.save(user);

            //throw new RuntimeException("transactionMethod error");


    }

    @Override
    public void nestingTransactionMethod(String name)  {

        //直接调用普通方法是不会生成代理类的，有注解的方法调用时会产生代理类，所以本方法里面嵌套代有事务注解的方法，事务是失效的

        //do something 前抛异常方法不会执行
        /*if(1!=0)
            throw new RuntimeException(" nestingTransactionMethod something is wrong!");*/

        //save user ，
        transactionMethod(name);
        // 方法已经执行 在抛异常不会回滚
        if(1!=0)
            throw new RuntimeException(" nestingTransactionMethod something is wrong!");
    }
}
