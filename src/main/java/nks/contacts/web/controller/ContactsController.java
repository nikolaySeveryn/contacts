package nks.contacts.web.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import nks.contacts.domain.contact.Contact;

import nks.contacts.domain.contact.Contacts;
import nks.contacts.web.Message;
import nks.contacts.web.model.ContactModelConverter;
import nks.contacts.web.model.ContactViewModel;
import nks.contacts.web.pagination.PaginationModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@SessionScoped
@ManagedBean
public class ContactsController {

    @Autowired
    private Contacts contacts;
    @Autowired
    private ContactEditorBean editor;
    private LazyDataModel<ContactViewModel> model;

    @PostConstruct
    public void init() {
        model = new PaginationModel<>(new ContactModelConverter(contacts));
    }

    public LazyDataModel<ContactViewModel> getContacts() {
        return model;
    }

    public void startEditing(ContactViewModel contact) {
        Contact refreshedModel = contacts.find(contact.getId());
        ContactViewModel refreshedViewModel = new ContactViewModel(refreshedModel);
        editor.setEditingContact(refreshedViewModel);
    }

    public void startAdding() {
        editor.setEditingContact(new ContactViewModel());
    }

    public void delete(ContactViewModel contact) {
        contacts.remove(contact.getId());
        Message.infoMessage("Deleted", "Contact has been deleted").show();
    }

}
