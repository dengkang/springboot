package com;

import com.example.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Destination;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableJms
@PropertySource({"classpath:/application.properties","classpath:/redis.properties"})

@EnableDiscoveryClient
//暂时去掉数据库加载
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}
}
