package com;

import com.example.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MQTest {
    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() {

        Destination destination = new ActiveMQQueue("test.queue");
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producer.sendMessage(destination,"消息"+i);
        }


    }
}
