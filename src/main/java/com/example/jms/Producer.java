package com.example.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
@Service("producer")
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    public void sendMessage(Destination destination, final String message){
        try{
            jmsMessagingTemplate.convertAndSend(destination,message);
        }catch(Exception e){

        }

    }

}
