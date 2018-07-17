package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.ServerSocket;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class redisTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {

        //redisTemplate.opsForValue().set("client","hehe1");
      /*  redisTemplate.opsForHash().put("user:1","age","40");
        List<String> list = redisTemplate.boundHashOps("user:1").values();
        for(String s:list){
            System.out.println(s);
        }*/
        //redisTemplate.opsForList().leftPush("list2","我是谁 no");
    /*   redisTemplate.execute(new RedisCallback<String>() {

           @Override
           public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
               ((StringRedisConnection)redisConnection).setNX("111","111");
               return null;
           }
       });*/
    /*   List<Object> txResults = redisTemplate.execute(new SessionCallback<List<Object>>() {

           @Override
           public  List<Object> execute(RedisOperations redisOperations) throws DataAccessException {
               redisOperations.multi();
               redisOperations.opsForList().leftPush("2","22");

               return redisOperations.exec();
           }
       });*/
        redisTemplate.opsForHash().put("user:1","age","30");
       // System.out.println(listOperations.leftPop("list1"));
    }
}
