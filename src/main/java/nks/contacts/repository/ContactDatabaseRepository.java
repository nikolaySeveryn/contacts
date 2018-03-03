package nks.contacts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import nks.contacts.domain.contact.Contact;
import nks.contacts.domain.contact.ContactRepository;

@Repository
public class ContactDatabaseRepository implements ContactRepository {
	
	@Autowired
	private ContactCrudRepository crudRepository;

	@Override
	public Long count() {
		return crudRepository.count();
	}

	@Override
	public Contact findById(Integer id) {
		ContactData data = crudRepository.findById(id).get();
		return createContact(data);
	}


	@Override
	public void removeById(Integer id) {
		crudRepository.deleteById(id);
	}

	@Override
	public Boolean exists(Integer id) {
		return crudRepository.existsById(id);
	}

	@Override
	public void save(Contact contact) {
		ContactData data = new ContactData();
		data.setId(contact.getId());
		data.setFullName(contact.getFullName());
		data.setPhoneNumber(contact.getPhoneNumber());
		crudRepository.save(data);
	}

	@Override
	public List<Contact> retrievePaged(Integer page, Integer size) {
		Page<ContactData> allData = crudRepository.findAll(PageRequest.of(page, size));
		List<Contact> contacts = new ArrayList<>(allData.getSize());
		for(ContactData data : allData){
			contacts.add(createContact(data));
		}
		return contacts;
	}
	
	private Contact createContact(ContactData data) {
		return new Contact(data.getId(), data.getFullName(), data.getPhoneNumber());
	}

}
