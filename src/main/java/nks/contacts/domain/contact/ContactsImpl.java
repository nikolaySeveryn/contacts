package nks.contacts.domain.contact;

import nks.contacts.domain.DomainException;
import nks.contacts.domain.pagination.PageCriteria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ContactsImpl implements Contacts{

    private final ContactRepository repository;

    @Autowired
    public ContactsImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Contact contact) {
        if(!contact.isValid()){
            throw new DomainException(String.format("%s is invalid for saving", contact.toString()));
        }
        repository.save(contact);
    }

    @Override
    public void remove(Integer id) {
        if(!repository.exists(id)){
            throw new DomainException(String.format("Removing contact %d does not exists", id));
        }
        repository.removeById(id);
    }

    @Override
    public List<Contact> pagedItems(PageCriteria criteria) {
        return repository.retrievePaged(criteria.getOffset(), criteria.getCount());
    }

	@Override
	public Integer itemCount() {
		return repository.count();
	}

	@Override
	public Contact getById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Integer getId(Contact object) {
		return object.getId();
	}
}
