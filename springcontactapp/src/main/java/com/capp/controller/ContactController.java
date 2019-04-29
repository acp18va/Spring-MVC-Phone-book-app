/**
 * 
 */
package com.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capp.domain.Contact;
import com.capp.service.ContactService;

/**
 * @author vijetaagrawal
 *
 */

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;


	@RequestMapping(value = "/user/contact_form")
	public String contactForm(Model m) {
		Contact contact = new Contact();
		m.addAttribute("command", contact);
		return "contact_form"; 
		
}
	
	@RequestMapping(value = "/user/save_contact")
	public String saveContact(@ModelAttribute("command") Contact c, HttpSession session, Model m) {
		try {
			Integer userId =(Integer) session.getAttribute("userId");
			c.setUserId(userId);//FK logged in UserId
			contactService.save(c);
			return "redirect:clist?act=sv";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("err", "Failed to save contact");
			return "contact_form";
		} 
		
}

	@RequestMapping(value = "/user/clist")
	public String contactList(Model m) {
		return "clist"; 
		
}
}
