package nks.contacts.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import nks.contacts.domain.contact.Contact;

import nks.contacts.domain.contact.Contacts;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

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


	public void onRowEdit(RowEditEvent event) {
		try {
			updateContact(event);
		}
		catch (Exception e ){
			//log
			showMessage(FacesMessage.SEVERITY_FATAL, "Undefined error", "Can not update contact");
		}
	}

	private void updateContact(RowEditEvent event) {
		Contact updated = (Contact) event.getObject();

		if (updated.isValid()) {
			contacts.save(updated);
            showMessage(FacesMessage.SEVERITY_INFO, "Success", "Contact has been updated");
        } else {
            showErrors(updated);
        }
	}

	private void showErrors(Contact updated) {
		if(!updated.isValidName()) {
			String details = String.format("Name \"%s\" is invalid", updated.getFullName());
			showMessage(FacesMessage.SEVERITY_ERROR, "Error", details);
		}
		if(!updated.isValidPhoneNumber()) {
			String details = String.format("Phone number \"%s\" is invalid", updated.getPhoneNumber());
			showMessage(FacesMessage.SEVERITY_ERROR, "Error", details);
		}
	}

	private void showMessage(FacesMessage.Severity severityError, String title, String details) {
		FacesMessage msg = new FacesMessage(severityError, title, details);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


}
