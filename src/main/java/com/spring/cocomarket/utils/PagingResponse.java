package com.spring.cocomarket.utils;

import com.spring.cocomarket.entities.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PagingResponse {
    /**
     * entity count
     */
    private Long count;
    /**
     * page number, 0 indicate the first page.
     */
    private Long pageNumber;
    /**
     * size of page, 0 indicate infinite-sized.
     */
    private Long pageSize;
    /**
     * Offset from the of pagination.
     */
    private Long pageOffset;
    /**
     * the number total of pages.
     */
    private Long pageTotal;
    /**
     * elements of page.
     */
    private List<User> elements;
}
