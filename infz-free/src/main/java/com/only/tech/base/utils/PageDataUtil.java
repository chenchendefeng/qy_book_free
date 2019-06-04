package com.only.tech.base.utils;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;

import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/21
 */
public class PageDataUtil {

    public static PageData getPageData(PageReq pageReq, List dtoList){

        Integer listSize = dtoList.size();
        PageData pageData = new PageData<>();
        Integer pageNo = pageReq.getPageNo();
        Integer pageSize = pageReq.getPageSize();
        pageData.setPageNo(pageNo);
        pageData.setPageSize(pageSize);
        if (!dtoList.isEmpty()){
            pageData.setCount(listSize);
            int pages = listSize / pageSize;
            int mo = listSize % pageSize;
            if (mo != 0){
                pages++;
            }
            pageData.setPages(pages);

            int index = (pageNo - 1) * pageSize;
            int toIndex = index + pageSize;
            if (index < listSize && toIndex < listSize){
                List result = dtoList.subList(index,toIndex);
                pageData.setData(result);
            }else {
                pageData.setData(dtoList.subList(index,listSize));
            }
        }
        return pageData;
    }
}
