package nks.contacts.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import nks.contacts.domain.contact.Contact;

import nks.contacts.domain.contact.Contacts;
import org.primefaces.model.LazyDataModel;

import nks.contacts.domain.contact.ContactsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@ManagedBean
public class ContactsController {

	@Autowired
	private Contacts contacts;
	private LazyDataModel<Contact> model;
	
	@PostConstruct
	public void init(){
		model = new PaginationModel<>(contacts);
	}
	
	public LazyDataModel<Contact> getContacts(){
		return model;
	}
	
}
