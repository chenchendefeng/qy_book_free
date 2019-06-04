package com.only.tech.user.common.model;

import java.io.Serializable;

import com.only.tech.user.common.constant.Constants;

/**
 * 分页查询dto
 */
public class PaginationQueryDto implements Serializable {

    /**
     * 页数
     */
    private Integer page = Constants.DEFAULT_PAGE;

    /**
     * 每页条数
     */
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    public PaginationQueryDto() {
    }

    public PaginationQueryDto(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        if(page == null || page < 1) {
            page = Constants.DEFAULT_PAGE;
        }

        if(pageSize == null || pageSize < 1) {
            pageSize = Constants.DEFAULT_PAGE_SIZE;
        }
        return (page - 1) * pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public PaginationQueryDto setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PaginationQueryDto setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
