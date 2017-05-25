package com.cpais.contactDB.service;

import java.util.List;

import com.cpais.contactDB.entity.Contact;


public interface ContactService {
	
	public List<Contact> getContacts();

	public void saveContact(Contact theContact);

	public Contact getContact(int theId);

	public void deleteContact(int theId);
		

	
	

}
