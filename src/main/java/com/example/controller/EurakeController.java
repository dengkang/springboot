package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @Auther: Administrator
 * @Date: 2019/1/12 15:26
 * @Description:
 */
@RestController
public class EurakeController {
    private final Logger logger = Logger.getLogger(getClass().toString());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/helloEurake",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
        return "hello Eurake!";
    }
}
