package com.example.system;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @Auther: Administrator
 * @Date: 2018/10/24 15:49
 * @Description:
 */
@Component
public class PreDestory {

    @PreDestroy
    public void destory(){
        System.out.println("程序退出");
    }

}
