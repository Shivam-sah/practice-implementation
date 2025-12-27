package com.practise.project.builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class Paging implements Serializable{
	
	private static final long serialVersionUID = 5830511735456698918L;
    public static final int MAX_PAGE_SIZE = 1000;
    private int pageNumber;
    private int pageSize;
    private List<com.practise.project.builder.Sort> sort;
    
    @JsonIgnore
    public Sort getSortInstance() {
        if (this.sort != null && !this.sort.isEmpty()) {
            List<Sort.Order> orders = new ArrayList();

            for(com.practise.project.builder.Sort s : this.sort) {
                if (StringUtils.isNotBlank(s.getProperty())) {
                    if ("desc".equalsIgnoreCase(s.getDirection())) {
                        orders.add(Order.desc(s.getProperty()));
                    } else {
                        orders.add(Order.asc(s.getProperty()));
                    }
                }
            }

            if (!orders.isEmpty()) {
                return Sort.by(orders);
            }
        }

        return null;
    }

    @JsonIgnore
    public Pageable getPageableInstance() {
        Sort s = this.getSortInstance();
        int num = this.pageNumber;
        int size = this.pageSize;
        if (num < 0) {
            num = 0;
        }

        if (size <= 0 || size > 1000) {
            log.warn("Pagination max allowed page size is {}; Received: {}; Restricted to {}", new Object[]{1000, size, 1000});
            size = 1000;
        }

        return s != null ? PageRequest.of(num, size, s) : PageRequest.of(num, size);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return this.pageNumber < 0 || this.pageSize <= 0;
    }

    public static Pageable getPageableInstance(Paging paging) {
        return (Pageable)(paging == null ? PageRequest.of(0, 1000) : paging.getPageableInstance());
    }

}
