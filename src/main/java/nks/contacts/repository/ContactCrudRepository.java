package nks.contacts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

interface ContactCrudRepository extends PagingAndSortingRepository<ContactData, Integer> {

}
