package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.exposeinfz.user.api.FaqInfz;
import com.only.tech.exposeinfz.user.dto.FaqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author HUA MAN LOU
 * @since 2019/5/20
 */
@Slf4j
@Service
public class HelpFacade {

    @Reference
    private FaqInfz faqInfz;

    public ResultDto<PageData<FaqDto>> getPage(Integer status, String channle, PageReq pageReq) {

        PageData<FaqDto> pageData = faqInfz.getPage(status,channle,pageReq);

        return ResultDto.succesResult(pageData);
    }

    public ResultDto<FaqDto> getFaq(Long id) {
        FaqDto faqDto = faqInfz.getFaq(id);
        if (faqDto != null){
            return ResultDto.succesResult(faqDto);
        }
        return ResultDto.errorResult("反馈不存在");
    }

    public ResultDto insertFaq(FaqDto faqDto) {

        return faqInfz.insertFaq(faqDto);
    }

    public ResultDto updateFaq(FaqDto faqDto) {

        return faqInfz.updateFaq(faqDto);
    }

    public ResultDto daleteFaq(Long id) {

        return faqInfz.deleteFaq(id);
    }
}
