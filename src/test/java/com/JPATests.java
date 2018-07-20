package com;

import com.example.bean.TUser;
import com.example.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
//@WebAppConfiguration(这里不能加webAppConfiguration标签)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JPATests {


	@Autowired
	private UserRepository repository;



	@Test
	public void test() throws Exception {
		TUser user = new TUser();
		user.setUsername("www");
		user.setPassword("1111");
		user.setEmail("xxx@ssd.com");
		repository.save(user);

	}












}
