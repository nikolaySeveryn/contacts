package nks.contacts.web;

import nks.contacts.domain.pagination.PageableSource;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public class PaginationModel<T> extends LazyDataModel<T>{

	private final PageableSource<T> service;

    public PaginationModel(PageableSource<T> service) {
        this.service = service;
        this.setRowCount(service.itemCount());
    }
    
    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder,
    		Map<String, Object> filters) {
    	this.setRowCount(service.itemCount());
    	return service.pagedItems(first, pageSize);
    }
}
