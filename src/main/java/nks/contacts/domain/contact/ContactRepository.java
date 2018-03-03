package nks.contacts.domain.contact;

import java.util.List;

public interface ContactRepository {

	Long count();
    Contact findById(Integer id);
    void removeById(Integer id);
    Boolean exists(Integer id);
    void save(Contact contact);
    List<Contact> retrievePaged(Integer page, Integer size);
}
