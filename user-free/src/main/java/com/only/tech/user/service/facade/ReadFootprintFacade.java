package com.only.tech.user.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.ReadFootprint;
import com.only.tech.exposeinfz.book.api.BookInfoInfz;
import com.only.tech.exposeinfz.book.dto.BookInfoDto;
import com.only.tech.user.dto.ReadFootprintDto;
import com.only.tech.user.service.biz.ReadFootprintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HUA MAN LOU
 * @since 2019/5/14
 */
@Slf4j
@Service
public class ReadFootprintFacade {

    @Autowired
    private ReadFootprintService readFootprintService;

    @Reference
    private BookInfoInfz bookInfoInfz;

    public boolean record(Long cuId, Long bid) {

        Wrapper qw = new QueryWrapper<>().eq("cuId",cuId).eq("bid",bid);
        ReadFootprint record = readFootprintService.getOne(qw);
        if (record == null){
            record = new ReadFootprint();
        }

        record.setCuId(cuId);
        record.setBID(bid);
        record.setCreateDate(new Date());

        boolean flag = false;
        Long id = record.getId();
        if (id == null){
            flag = readFootprintService.save(record);
        }else {
            flag = readFootprintService.updateById(record);
        }
        return flag;
    }


    public PageData<ReadFootprintDto> getPage(Long cuId, PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        Wrapper qw = new QueryWrapper<>().eq("cuId", cuId).orderByDesc("createDate");
        List<ReadFootprint> list = readFootprintService.list(qw);

        PageData pageData = new PageData<>(page);
        if (!list.isEmpty()) {
            List<ReadFootprintDto> dlist = new ArrayList<>(list.size());

            for (ReadFootprint data : list) {
                ReadFootprintDto dto = new ReadFootprintDto();
                BeanUtils.copyProperties(data, dto);
                Long bid = data.getBID();
                BookInfoDto bookInfo = bookInfoInfz.getBookInfo(bid);
                if (bookInfo != null) {
                    dto.setName(bookInfo.getName());
                    dto.setCoverImg(bookInfo.getCoverImg());
                }
                dlist.add(dto);
            }
            pageData.setData(dlist);
        }
        return pageData;
    }


    public boolean delete(Long id) {
        return readFootprintService.removeById(id);
    }
}
