package nks.contacts.domain.pagination;

import java.util.List;

public interface PageableSource<T> {
    List<T> pagedItems(PageCriteria criteria);
}
