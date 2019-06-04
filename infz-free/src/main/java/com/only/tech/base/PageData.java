package com.only.tech.base;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据类
 *
 * @author ZHI ZUN BAO
 * @since 2018/10/14
 */
@Data
@AllArgsConstructor
public class PageData<T> implements Serializable{

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer pageNo;

    /**
     * 页条数
     */
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;

    /**
     * 总数
     */
    @ApiModelProperty(value = "总数")
    private Integer count;

    /**
     * 当前页数据
     */
    @ApiModelProperty(value = "当前页数据")
    private List<T> data;

    /**
     *
     */
    @ApiModelProperty(value = "备用字段")
    private List otherData;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Integer pages;

    public PageData(){ super();}

    public PageData(Page page) {
        this.pageNo = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.count = Long.valueOf(page.getTotal()).intValue();
        this.data = page.getResult();
        this.pages = page.getPages();
    }

    public PageData(Integer pageNo, Integer pageSize, Integer count,Integer pages, List<T> data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.data = data;
        this.pages = pages;
    }
}
