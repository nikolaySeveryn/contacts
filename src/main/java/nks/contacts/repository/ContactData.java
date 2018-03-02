package nks.contacts.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ContactData {
	@Id
	@SequenceGenerator(name="contact_id",sequenceName="seq_contact_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="contact_id")
	private Integer id;
	
	@Column(name="full_name", nullable=false)
	private String fullName;
	@Column(name="phone_number", nullable=false)
	private String phoneNumber;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
