package com.cpais.contactDB.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpais.contactDB.entity.Contact;
import com.cpais.contactDB.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping("/list")
	public String listContacts(Model theModel){
		
		// retrieve contacts 
		List<Contact> contacts = contactService.getContacts();
		
		// add to model, so jsp can reference
		theModel.addAttribute("contacts", contacts);
		
		return  "contact-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		// create new contact object
		Contact theContact = new Contact();
		
		// pass object into model for jsp form fields to reference and fill
		theModel.addAttribute("contact",theContact);
		
		return "contact-form";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@Valid @ModelAttribute("contact") Contact theContact,
								BindingResult theBindingResult){
		
		if(theBindingResult.hasErrors()){
			return "contact-form";
		}
		else{
		// retrieve modelAttribute, now filled, and save it with service
		contactService.saveContact(theContact);
		
		return "redirect:/contact/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contactId") int theId,
									Model theModel){
		// retrieve a given tempContact's id
		
		// get an object from database with that id
		Contact theContact = contactService.getContact(theId);
		
		// add it to model, to pre-fill form fields
		theModel.addAttribute("contact",theContact);
		return "contact-form";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") int theId){
		
		contactService.deleteContact(theId);
		return "redirect:/contact/list";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor theEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, theEditor);
	}
	
}
