package nks.contacts.web;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import nks.contacts.domain.contact.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import nks.contacts.domain.contact.Contacts;
import nks.contacts.domain.pagination.PageCriteria;

import java.util.List;

@Named
@RequestScoped
public class ContactsController {
	
	@Autowired
	private Contacts contacts;
	
	public List<Contact> getContacts(){
		return contacts.pagedItems(new PageCriteria() {
			
			@Override
			public Integer getOffset() {
				return 0;
			}
			
			@Override
			public Integer getCount() {
				return 100;
			}
		});
	}

}
