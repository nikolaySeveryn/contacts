package nks.contacts.domain.contact;

import nks.contacts.domain.DomainException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ContactsImpl implements Contacts {

    private ContactRepository repository;

    @Autowired
    public void setRepository(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Contact contact) {
        if (!contact.isValid()) {
            throw new DomainException(String.format("%s is invalid for saving", contact.toString()));
        }
        repository.save(contact);
    }

    @Override
    public void remove(Integer id) {
        if (!repository.exists(id)) {
            throw new DomainException(String.format("Removing contact %d does not exists", id));
        }
        repository.removeById(id);
    }

    @Override
    public List<Contact> pagedItems(Integer offset, Integer count) {
        if (count < 1) {
            return new ArrayList<>();
        }
        int page = offset / count;
        return repository.retrievePaged(page, count);
    }

    @Override
    public Long itemCount() {
        return repository.count();
    }

    @Override
    public Contact find(Integer id) {
        return repository.findById(id);
    }
}
