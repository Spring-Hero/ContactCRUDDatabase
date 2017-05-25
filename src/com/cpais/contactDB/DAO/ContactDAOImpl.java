package com.cpais.contactDB.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpais.contactDB.entity.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Contact> getContacts() {
		// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
			Query theQuery = currentSession.createQuery("from Contact order by name");
		
		// execute query, store resultlist
			List<Contact> contacts = theQuery.getResultList();
		
		// return results as a list
		return contacts;
	}


	@Override
	public void saveContact(Contact theContact) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the imported contact
		currentSession.saveOrUpdate(theContact);
		
	}


	@Override
	public Contact getContact(int theId) {
		// get current session
			Session currentSession = sessionFactory.getCurrentSession();
			
		// retrieve contact using the id
			Contact theContact = currentSession.get(Contact.class, theId);
		
		return theContact;
	}


	@Override
	public void deleteContact(int theId) {
		// get current session
			Session currentSession = sessionFactory.getCurrentSession();
		// create deletion query
			Query theQuery = currentSession.createQuery("delete from Contact where id=:theId");
		// supply deletion query's parameter with theId
			theQuery.setParameter("theId",theId);
		// execute the query
			theQuery.executeUpdate();
	}

}
