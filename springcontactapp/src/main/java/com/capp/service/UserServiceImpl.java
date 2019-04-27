package com.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.exception.UserBlockedException;

/**
 * 
 * @author vijetaagrawal
 *
 */

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void register(User u) {
		userDAO.save(u);
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}
	
	

}
