package com.example.jms;

//@Component
public class Consumer {
    //@JmsListener(destination ="test.queue")
    public void receiveQueue(String text){
        System.out.println("收到消息:"+text);
    }

}
