package com.only.tech.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author ZHI ZUN BAO
 * @since 2018/10/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageReq implements Serializable {

    private Integer pageNo;

    private Integer pageSize;

    public Integer getPageNo() {
        if (pageNo == null || pageNo <= 1){
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize <= 0){
            return 20;
        }
        if(pageSize > 500){
            return 500;
        }
        return pageSize;
    }
}
