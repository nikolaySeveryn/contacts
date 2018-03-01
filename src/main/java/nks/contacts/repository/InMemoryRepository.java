package nks.contacts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nks.contacts.domain.contact.Contact;
import nks.contacts.domain.contact.ContactRepository;

@Component
public class InMemoryRepository implements ContactRepository{
	
	private List<Contact> contacts = new ArrayList<>();
	
	public InMemoryRepository() {
		contacts.add(new Contact(1, "John Dow", "123123123"));
		contacts.add(new Contact(2, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(3, "Elvis Presly", "3321412"));
		contacts.add(new Contact(4, "John Dow", "123123123"));
		contacts.add(new Contact(5, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(6, "Elvis Presly", "3321412"));
		contacts.add(new Contact(7, "John Dow", "123123123"));
		contacts.add(new Contact(8, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(9, "Elvis Presly", "3321412"));
		contacts.add(new Contact(10, "John Dow", "123123123"));
		contacts.add(new Contact(11, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(12, "Elvis Presly", "3321412"));
		contacts.add(new Contact(13, "John Dow", "123123123"));
		contacts.add(new Contact(14, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(15, "Elvis Presly", "3321412"));
		contacts.add(new Contact(16, "John Dow", "123123123"));
		contacts.add(new Contact(17, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(17, "Elvis Presly", "3321412"));
		contacts.add(new Contact(19, "John Dow", "123123123"));
		contacts.add(new Contact(20, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(21, "Elvis Presly", "3321412"));
		contacts.add(new Contact(22, "John Dow", "123123123"));
		contacts.add(new Contact(23, "Peter Capaldi", "4575645"));
		contacts.add(new Contact(24, "Elvis Presly", "3321412"));
		
	}

	@Override
	public Contact findById(Integer id) {
		for(Contact contact : contacts) {
			if(contact.getId().equals(id)) {
				return contact;
			}
		}
		throw new RuntimeException(String.format("Contact with id %d does not exists", id));
	}

	@Override
	public void removeById(Integer id) {
		
	}

	@Override
	public Boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Contact contact) {
		if(contact.isNew()){
			contacts.add(contact);
		}
		else{
			Contact existing = findById(contact.getId());
			int index = contacts.indexOf(existing);
			contacts.set(index, contact);
		}
	}

	@Override
	public List<Contact> retrievePaged(Integer offset, Integer limit) {
		if(offset > contacts.size()) {
			throw new RuntimeException();
		}
		int to = offset+limit;
		if(to > contacts.size()) {
			to = contacts.size();
		}
		List<Contact> results = this.contacts.subList(offset, to);
		return copyContact(results);
	}

	/**
	 * We copy contacts to emulate persistent storage
	 * @param originalContacts
	 * @return list of other instances of the same contacts
	 */
	private List<Contact> copyContact(List<Contact> originalContacts){
		List<Contact> copy = new ArrayList<>(originalContacts.size());
		for(Contact original : originalContacts){
			copy.add(new Contact(original.getId(), original.getFullName(), original.getPhoneNumber()));
		}
		return copy;
	}

	@Override
	public Integer count() {
		return contacts.size();
	}

}
