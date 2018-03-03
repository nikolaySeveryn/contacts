package nks.contacts.domain.contact;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void validNameTest() {
        Contact contact = new Contact("John Dow", null);
        assertTrue(contact.isValidName());
    }

    @Test
    public void nullNameTest() {
        Contact contact = new Contact(null, null);
        assertFalse(contact.isValidName());
    }

    @Test
    public void emptyNameTest() {
        Contact contact = new Contact("", null);
        assertFalse(contact.isValidName());
    }

    @Test
    public void validPhoneNumberTest() {
        Contact contact = new Contact(null, "43123123123");
        assertTrue(contact.isValidPhoneNumber());
    }

    @Test
    public void nullPhoneNumberTest() {
        Contact contact = new Contact(null, null);
        assertFalse(contact.isValidPhoneNumber());
    }

    @Test
    public void emptyPhoneNumberTest() {
        Contact contact = new Contact(null, "");
        assertFalse(contact.isValidPhoneNumber());
    }

    @Test
    public void nonNumericalPhoneTest() {
        Contact contact = new Contact(null, "(098)12-31-123");
        assertFalse(contact.isValidPhoneNumber());

        contact = new Contact(null, "abc");
        assertFalse(contact.isValidPhoneNumber());

        contact = new Contact(null, "abc123");
        assertFalse(contact.isValidPhoneNumber());

        contact = new Contact(null, "123abc");
        assertFalse(contact.isValidPhoneNumber());

        contact = new Contact(null, "123abc123");
        assertFalse(contact.isValidPhoneNumber());
    }

    @Test
    public void newContactTest() {
        Contact contact = new Contact(null, null);
        assertTrue(contact.isNew());
    }

    @Test
    public void oldContactTest() {
        Contact contact = new Contact(123, null, null);
        assertFalse(contact.isNew());
    }
}