package nks.contacts.domain.pagination;

import java.util.List;

public interface PageableSource<T> {
	Integer getId(T object);
	T getById(Integer id);
	Integer itemCount();
    List<T> pagedItems(PageCriteria criteria);
}
