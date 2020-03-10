package com;

import com.example.bean.TUser;
import com.example.dao.UserRepository;
import com.example.service.TransactionTestService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//@WebAppConfiguration(这里不能加webAppConfiguration标签)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JPATests {


	@Autowired
	private UserRepository repository;
	@Autowired
	private TransactionTestService service;


	@Autowired
	StringEncryptor encryptor;

	@Test
	public void getPassword(){
		String password = encryptor.encrypt("123456");
		System.out.println(password);
	}

	@Test
	public void test() throws Exception {
		TUser user = new TUser();
		user.setUsername("www");
		user.setPassword("1111");
		user.setEmail("xxx@ssd.com");
		repository.save(user);

	}

	@Test
	public void transactionMethod() throws Exception {


			service.transactionMethod("transactionMethod5");




	}


	@Test
	public void nestingTransactionMethod() throws Exception {
		 service.nestingTransactionMethod("nestingTransactionMethod6");

	}













}
