package nks.contacts.domain.contact;

import java.util.List;

public interface ContactRepository {

    Contact findById();
    void removeById(Integer id);
    Boolean exists(Integer id);
    void save(Contact contact);
    List<Contact> retrievePaged(Integer offset, Integer limit);
}
