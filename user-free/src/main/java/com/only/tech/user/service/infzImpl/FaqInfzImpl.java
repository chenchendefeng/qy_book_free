package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.entity.user.Faq;
import com.only.tech.exposeinfz.user.api.FaqInfz;
import com.only.tech.exposeinfz.user.dto.FaqDto;
import com.only.tech.user.service.biz.FaqService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author HUA MAN LOU
 * @since 2019/5/20
 */
@Slf4j
@Component
@Service(interfaceClass = FaqInfz.class)
public class FaqInfzImpl implements FaqInfz {

    @Autowired
    private FaqService faqService;


    @Override
    public PageData<FaqDto> getPage(Integer status, String channle, PageReq pageReq) {

        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());

        List<FaqDto> list = faqService.getFaqDtoList(status,channle);

        PageData pageData = new PageData(page);

        return pageData;
    }

    @Override
    public FaqDto getFaq(Long id) {
        if (id == null){
            return null;
        }
        Faq faq = faqService.getById(id);

        if (faq != null){
            FaqDto faqDto = new FaqDto();
            BeanUtils.copyProperties(faq,faqDto);
            return faqDto;
        }
        return null;
    }

    @Override
    public ResultDto insertFaq(FaqDto faqDto) {
        if (faqDto == null){
            return ResultDto.errorResult("添加失败，参数错误");
        }
        Faq faq = new Faq();
        BeanUtils.copyProperties(faqDto,faq);

        String channle = faq.getChannle();
        if (StringUtils.isBlank(channle)){
            faq.setChannle("-1");
        }

        Date now = new Date();
        faq.setCreateTime(now);
        faq.setUpdateTime(now);
        boolean save = faqService.save(faq);
        if (save){
            return ResultDto.succesResult("添加成功");
        }
        return ResultDto.errorResult("添加失败");
    }

    @Override
    public ResultDto updateFaq(FaqDto faqDto) {
        if (faqDto == null){
            return ResultDto.errorResult("添加失败，参数错误");
        }
        Faq faq = new Faq();
        BeanUtils.copyProperties(faqDto,faq);

        String channle = faq.getChannle();
        if (StringUtils.isBlank(channle)){
            faq.setChannle("-1");
        }

        Date now = new Date();
        faq.setUpdateTime(now);
        boolean update = faqService.updateById(faq);
        if (update){
            return ResultDto.succesResult("修改成功");
        }
        return ResultDto.errorResult("修改失败");
    }

    @Override
    public ResultDto deleteFaq(Long id) {
        boolean remove = faqService.removeById(id);
        if (remove){
            return ResultDto.succesResult("删除成功");
        }
        return ResultDto.errorResult("删除失败");
    }
}
