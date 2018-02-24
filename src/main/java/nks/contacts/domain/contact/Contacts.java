package nks.contacts.domain.contact;

import nks.contacts.domain.pagination.PageableSource;

public interface Contacts extends PageableSource<Contact> {

    void save(Contact contact);
    void remove(Integer id);
}
