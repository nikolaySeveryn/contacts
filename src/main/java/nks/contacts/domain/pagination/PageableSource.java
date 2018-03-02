package nks.contacts.domain.pagination;

import java.util.List;

public interface PageableSource<T> {
	Long itemCount();
    List<T> pagedItems(Integer offset, Integer count);
}
