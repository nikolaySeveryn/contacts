package nks.contacts.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import nks.contacts.domain.contact.Contact;

import org.primefaces.model.LazyDataModel;

import nks.contacts.domain.contact.Contacts;
import nks.contacts.domain.contact.ContactsImpl;
import nks.contacts.repository.InMemoryRepository;

@ViewScoped
@ManagedBean
public class ContactsController {
	
//	@Autowired
	private ContactsImpl contacts = new ContactsImpl();
	
	public ContactsController() {
		contacts.setRepository(new InMemoryRepository());
	}
	
	public List<Contact> getContacts(){
		return contacts.pagedItems(0, 100);
//		return new PaginationModel<Contact>(contacts);
		
	}
	
	public String getName() {
		return "Contacts";
	}

}
