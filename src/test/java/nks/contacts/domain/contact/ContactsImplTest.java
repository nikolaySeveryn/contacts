package nks.contacts.domain.contact;

import nks.contacts.domain.DomainException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactsImplTest {

    @Mock
    private ContactRepository repository;

    @InjectMocks
    private ContactsImpl contacts;

    @Test
    public void saveTest() {
        Contact contact = mock(Contact.class);
        when(contact.isValid()).thenReturn(true);
        contacts.save(contact);
        verify(repository).save(contact);
    }

    @Test
    public void invalidSaveTest() {
        Contact contact = mock(Contact.class);
        when(contact.isValid()).thenReturn(false);
        try {
            contacts.save(contact);
            fail("Exception was expected, but there was not");
        }
        catch (DomainException e) {}
        verify(repository, never()).save(contact);
    }

    @Test
    public void removeTest() {
        Integer id = 12;
        when(repository.exists(id)).thenReturn(true);
        contacts.remove(id);
        verify(repository).exists(id);
        verify(repository).removeById(id);
    }

    @Test
    public void removeNonexistentTest() {
        Integer id = 12;
        when(repository.exists(id)).thenReturn(false);
        try {
            contacts.remove(id);
            fail("Exception was expected, but there was not");
        }
        catch (DomainException e) {}
        verify(repository).exists(id);
        verify(repository, never()).removeById(id);
    }

    @Test
    public void pagedItems() {
        //TODO: write test
    }
}