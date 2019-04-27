package com.capp.service;

import java.util.List;

import com.capp.domain.User;
import com.capp.exception.UserBlockedException;

/**
 * 
 * @author vijetaagrawal
 *
 */
public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;

	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;

	
	
	/**
	 * The method handles user registration task.
	 * 
	 * @param u the new user detail as User object
	 */
	public void register(User u);
	
	/**
	 * The method handles login operation(authentication) using given credentials
	 * 	it returns user object when success and Null when failed
	 * When user account is blocked an exception will be thrown by this method
	 * @param loginName
	 * @param password
	 * @return
	 * @throws com.capp.exception.UserBlockedException when user account is blocked
	 */
	public User login(String loginName, String password) throws UserBlockedException;
	/**
	 * Call this method to get list of registered users
	 * @return
	 */
	
	public List<User> getUserList();
	
	/**
	 * This method changes the user login status for details passed as arguments
	 * @param userId
	 * @param loginStatus
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	
}
