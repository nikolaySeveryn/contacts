package nks.contacts.web.model;

import nks.contacts.domain.contact.Contact;
import nks.contacts.web.Mask;

public class ContactViewModel {
	
	private final static String PHONE_MASK = "(999) 99-99-999";
	
	private final Mask mask = new Mask(PHONE_MASK);

	private final Integer id;
	private String fullName;
	private String phoneNumber;
	
	public ContactViewModel(){
		this.id = null;
		this.fullName = "";
		this.phoneNumber = "";
	}
	
	public ContactViewModel(Contact contact){
		this.id = contact.getId();
		this.fullName = contact.getFullName();
		this.phoneNumber = contact.getPhoneNumber();
	}
	
	public Contact toDomainModel(){
		return new Contact(id, fullName, phoneNumber);
	}
	
	public Integer getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return mask.cast(phoneNumber);
	}
	

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber.replaceAll("[^\\d.]", "");
	}
	
	public String getMask(){
		return mask.getMaskValue();
	}
	
}
