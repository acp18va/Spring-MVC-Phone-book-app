package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("Vijeta");
		u.setPhone("9717295819");
		u.setAddress("Allen Court");
		u.setPassword("v123");
		u.setRole(1);
		u.setLoginName("VijetaAgrawal");
		u.setEmail("V@gmail.com");
		u.setLoginStatus(1);
		userDAO.save(u);
		System.out.println("Info saved in database");

	}

}
