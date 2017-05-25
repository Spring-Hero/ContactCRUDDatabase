package com.cpais.contactDB.DAO;

import java.util.List;

import com.cpais.contactDB.entity.Contact;

public interface ContactDAO {
	
	public List<Contact>getContacts();

	public void saveContact(Contact theContact);

	public Contact getContact(int theId);

	public void deleteContact(int theId);

}
