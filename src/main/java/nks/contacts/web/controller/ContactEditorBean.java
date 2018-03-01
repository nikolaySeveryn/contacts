package nks.contacts.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nks.contacts.domain.contact.Contacts;
import nks.contacts.web.Message;
import nks.contacts.web.model.ContactViewModel;

@Component
@SessionScoped
@ManagedBean
public class ContactEditorBean {
	
	@Autowired
	private Contacts contacts;
	
	private ContactViewModel editingContact;
	
	public void setEditingContact(ContactViewModel editingContact) {
		this.editingContact = editingContact;
	}
	
	public ContactViewModel getEditingContact() {
		return editingContact;
	}

	public String getModalTitle(){
		if(editingContact == null){
			return "";
		}
		else if(editingContact.toDomainModel().isNew()){
			return "New contact";
		}
		else{
			return "Edit contact";
		}
	}

	public boolean isEditingActive(){
		return editingContact != null;
	}
	
	public void save(){
		try{
			contacts.save(this.editingContact.toDomainModel());
			Message.infoMessage("Success", "Contact has been saved").show();
			editingContact = null;
		}
		catch (Exception e) {
			//TODO: log exception
			Message.errorMessge("Unexpected error on saving contact").show();
		}
	}

	public void cancel(){
		this.editingContact = null;
	}

}
