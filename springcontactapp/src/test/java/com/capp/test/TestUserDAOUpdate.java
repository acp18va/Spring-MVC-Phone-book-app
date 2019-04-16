package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setUserid(2);
		u.setName("Sanika_Patil");
		u.setPhone("9890368940_0000");
		u.setAddress("Jalgaon_Sheffield");
		u.setRole(1);
		u.setEmail("S@gmail.com");
		u.setLoginStatus(1);
		userDAO.update(u);
		System.out.println("Data Updated");

	}

}