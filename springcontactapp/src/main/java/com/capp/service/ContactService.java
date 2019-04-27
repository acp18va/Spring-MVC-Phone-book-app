/**
 * 
 */
package com.capp.service;

import java.util.List;

import com.capp.domain.Contact;

/**
 * The interface specifies all the business operations for Contact entity
 * @author vijetaagrawal
 *
 */
public interface ContactService {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public void delete(Integer[] contactIds);
	
	/**
	 * This method Returns users who are logged in
	 * @param userID
	 * @return
	 */
	public List<Contact> findUserContact(Integer userID);
	
	/**
	 * The method search contact for user(userId) based on given free-text-criteria  (txt)
	 * @param userID user who is logged in
	 * @param txt criteria used to search - free text search criteria
	 * @return
	 */
	public List<Contact> findUserContact(Integer userID, String txt);


	
}
