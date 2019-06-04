package com.only.tech.user.common.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class PaginationDto<T> implements Serializable {

    /**
     * 数据总数
     */
    @ApiModelProperty(value = "数据总数", name = "total")
    private Integer total;

    /**
     * 数据列表
     */
    @ApiModelProperty(value = "数据列表", name = "data")
    private List<T> data;

    /**
     * 页码
     */
    @ApiModelProperty(value = "页码", name = "page")
    private Integer page;

    @ApiModelProperty(value = "总页数", name = "pages")
    private int pages;

    public Integer getTotal() {
        return total;
    }

    public PaginationDto setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public PaginationDto setData(List<T> data) {
        this.data = data;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public PaginationDto setPage(Integer page) {
        this.page = page;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public PaginationDto setPages(int pages) {
        this.pages = pages;
        return this;
    }
}
