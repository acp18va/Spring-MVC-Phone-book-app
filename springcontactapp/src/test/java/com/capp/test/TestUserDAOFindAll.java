package com.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOFindAll {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		
		List<User> users = userDAO.findAll();
		for (User u : users) {
             System.out.println(u.getUserid()+ " " + u.getName()+ " "+ u.getRole());
             
		}


		
		

	}

}