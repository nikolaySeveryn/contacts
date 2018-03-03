package nks.contacts.web.model;

import java.util.ArrayList;
import java.util.List;

import nks.contacts.domain.contact.Contact;
import nks.contacts.domain.contact.Contacts;
import nks.contacts.domain.pagination.PageableSource;

public class ContactModelConverter implements PageableSource<ContactViewModel> {

    private final Contacts origin;

    public ContactModelConverter(Contacts origin) {
        this.origin = origin;
    }

    @Override
    public Long itemCount() {
        return origin.itemCount();
    }

    @Override
    public List<ContactViewModel> pagedItems(Integer offset, Integer count) {
        List<Contact> domainModels = origin.pagedItems(offset, count);
        List<ContactViewModel> viewModels = new ArrayList<>(domainModels.size());
        for (Contact model : domainModels) {
            viewModels.add(new ContactViewModel(model));
        }
        return viewModels;
    }

}
