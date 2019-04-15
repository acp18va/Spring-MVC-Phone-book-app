package com.capp.dao;

import java.util.List;
import com.capp.domain.Contact;

/**
 * @author vijetaagrawal
 *
 */

public interface ContactDAO {
	public void save(Contact c); // save the user object
	public void update(Contact c); // update the user object
	public void delete(Contact c); // delete the user object
	public void delete(Integer contactId); // delete the user by its userId
	public Contact findById(Integer contactId); // find the user by its userId
	public List<Contact> findAll();
	public List<Contact> findByProperty(String propName, Object propValue);

}
