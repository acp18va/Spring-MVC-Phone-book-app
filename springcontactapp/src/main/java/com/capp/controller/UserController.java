
package com.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capp.command.LoginCommand;
import com.capp.command.UserCommand;
import com.capp.domain.User;
import com.capp.exception.UserBlockedException;
import com.capp.service.UserService;

/**
 * @author vijetaagrawal
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = {"/","/index"})
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index"; // JSP - /WEB-INF/view/index.jsp
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			if(loggedInUser==null) {
				//Add error message and go back to login - form
				m.addAttribute("err", "Login Failed! Enter Valid Credentials.");
				return "index";	
			}
			else {
				//Success
				//Check the role and redirect to a appropriate dashboard
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					//add user detail in session (assign session to logged in user)
					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";
				}
				else if(loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					//add user detail in session (assign session to logged in user)
					addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				}
				else {
					//Add error message and go back to login - form
					m.addAttribute("err", "Invalid User ROLE");
					return "index";	
				}
				
			}
		} catch (UserBlockedException e) {
			//Add error message and go back to login - form
		m.addAttribute("err", e.getMessage());
		return "index";
		}
		
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo"; // JSP - /WEB-INF/view/index.jsp
	
	}
	
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		return "dashboard_user"; // JSP - /WEB-INF/view/index.jsp
	
	}
	
	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard() {
		return "dashboard_admin"; // JSP - /WEB-INF/view/index.jsp
	
	}
	
	@RequestMapping(value = "/reg_form")
	public String RegistrationForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		
		return "reg_form";
		
	}
	
	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
		try {
			User user = cmd.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			return "redirect:index?act=reg";
		} catch (DuplicateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("err", "Username is already registered. Please select another Username.");
			return "reg_form";
		}
		
	}
	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", "u");
		session.setAttribute("userId", u.getUserid());
		session.setAttribute("role", u.getRole());
		
	}


}
