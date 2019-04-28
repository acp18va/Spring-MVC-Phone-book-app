package com.capp.command;

import com.capp.domain.User;

public class UserCommand {

	User user;  // here we have re-used the domain class of user, instead of again writing all the properties
	// required for registration form.
	//TODO add more field if required

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
