package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.Faq;
import com.only.tech.exposeinfz.user.dto.FaqDto;
import com.only.tech.user.common.model.PaginationDto;
import com.only.tech.user.dto.FaqRespDto;
import com.only.tech.user.mapper.FaqMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * FAQ 服务实现类
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/7
 */
@Service("faqService")
public class FaqServiceImpl extends ServiceImpl<FaqMapper, Faq> implements FaqService{

    @Autowired
    private FaqMapper faqMapper;

    @Override
    public PageData<FaqRespDto> getFaqList(String channle, PageReq pageReq) {
        if(pageReq.getPageNo() == null) {
            pageReq.setPageNo(1);
        }
        if(pageReq.getPageSize() == null) {
            pageReq.setPageSize(20);
        }
        Page<Faq> page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());

        List<FaqRespDto> list =  faqMapper.getFaqList(channle);

        PageData pageData = new PageData();
        pageData.setData(page.getResult());
        pageData.setCount(Long.valueOf(page.getTotal()).intValue());
        pageData.setPageNo(page.getPageNum());
        pageData.setPageSize(page.getPageSize());
        return pageData;
    }

    @Override
    public List<FaqDto> getFaqDtoList(Integer status, String channle) {
        if (StringUtils.isNotBlank(channle)){
            channle = "%"+channle+"%";
        }
        return faqMapper.getFaqDtoList(status,channle);
    }

}
