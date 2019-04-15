package com.capp.dao;


import java.util.List;

import com.capp.domain.User;

public interface UserDAO {
	
	public void save(User u); // save the user object
	public void update(User u); // update the user object
	public void delete(User u); // delete the user object
	public void delete(Integer userId); // delete the user by its userId
	public User findById(Integer userId); // find the user by its userId
	public List<User> findAll();
	public List<User> findByProperty(String propName, Object propValue);

}
