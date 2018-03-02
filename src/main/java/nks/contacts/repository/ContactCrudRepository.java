package nks.contacts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactCrudRepository extends PagingAndSortingRepository<ContactData, Integer> {

}
