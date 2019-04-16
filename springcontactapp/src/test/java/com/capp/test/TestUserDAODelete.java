package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);

		userDAO.delete(1);
		System.out.println("Data Deleted");

	}

}