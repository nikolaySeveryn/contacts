package nks.contacts.domain.contact;

import java.util.Objects;

public class Contact {

    private final Integer id;
    private final String fullName;
    private final String phoneNumber;

    public Contact(Integer id, String fullName, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String fullName, String phoneNumber){
        this(null, fullName, phoneNumber);
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isNew(){
        return id == null;
    }

    public boolean isValid(){
        return isValidName() && isValidPhoneNumber();
    }

    public boolean isValidName() {
        if(fullName == null || fullName.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean isValidPhoneNumber() {
        if(phoneNumber == null || phoneNumber.isEmpty()){
            return false;
        }
        if(! phoneNumber.matches("[0-9]+")){
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(fullName, contact.fullName) &&
                Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
