package nks.contacts.repository;

import javax.persistence.*;

@Entity
@Table(schema = "catalog", name = "contacts")
public class ContactData {
    @Id
    @SequenceGenerator(name = "seq_contact_id", schema = "catalog", sequenceName = "seq_contact_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contact_id")
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "phone_number", nullable = false)
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
