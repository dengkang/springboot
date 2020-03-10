package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;

  /*  @Autowired
    private Producer producer;*/

    //private final Destination destination = new ActiveMQQueue("test.queue");
    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }

    @RequestMapping("/sendmsg")
    public String sendMsg(){
        MsgThread mt = new MsgThread();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();

        return "send success";
    }

    class MsgThread implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<500;i++){
               // producer.sendMessage(destination,Thread.currentThread().getName()+",发送消息："+i);
            }
        }
    }
}
