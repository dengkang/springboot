package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

//@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableJms
@PropertySource({"classpath:/application.properties"})
//@PropertySource({"classpath:/application.properties","classpath:/redis.properties"})
//@EnableDiscoveryClient
//暂时去掉数据库加载
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}
}
