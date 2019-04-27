package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.service.UserService;

public class TestUserServiceRegister {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService= ctx.getBean(UserService.class);
		
		User u = new User();
		u.setName("Arnav");
		u.setPhone("5555555555");
		u.setAddress("Court");
		u.setPassword("a123");
		u.setRole(UserService.ROLE_ADMIN);
		u.setLoginName("ArnavGoswami");
		u.setEmail("A@gmail.com");
		u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		userService.register(u);
		System.out.println("User registered successfully");

	}

}
