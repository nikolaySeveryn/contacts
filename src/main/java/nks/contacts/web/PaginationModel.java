package nks.contacts.web;

import nks.contacts.domain.contact.Contact;
import nks.contacts.domain.pagination.PageCriteria;
import nks.contacts.domain.pagination.PageableSource;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public class PaginationModel<T> extends LazyDataModel<T>{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4677276249016807764L;
	private final PageableSource<T> service;

    public PaginationModel(PageableSource<T> contacts) {
        this.service = contacts;
    }
    
    @Override
    public T getRowData(String rowKey) {
    	return service.getById(Integer.parseInt(rowKey));
    }
    
    @Override
    public Object getRowKey(T object) {
    	return service.getId(object);
    }

    
    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder,
    		Map<String, Object> filters) {
    	
    	this.setRowCount(service.itemCount());
    	return service.pagedItems(new PageCriteria() {
            @Override
            public Integer getOffset() {
                return first;
            }

            @Override
            public Integer getCount() {
                return pageSize;
            }
        });
    }
}
